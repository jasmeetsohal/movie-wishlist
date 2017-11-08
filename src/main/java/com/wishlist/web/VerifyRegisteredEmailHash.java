package com.wishlist.web;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wishlist.dao.UserDao;
import com.wishlist.dao.UserDaoImpl;
import com.wishlist.db.DBException;
import com.wishlist.model.User;
import com.wishlist.util.BCrypt;
import com.wishlist.util.GlobalConstants;
import com.wishlist.util.MailUtil;
import com.wishlist.util.Utils;

/**
 * Servlet implementation class VerifyRegisteredEmailHash
 */
@WebServlet("/VerifyRegisteredEmailHash")
public class VerifyRegisteredEmailHash extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(VerifyRegisteredEmailHash.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifyRegisteredEmailHash() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get user Id and email verification code Hash code
		System.out.println("hello");
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		String hash = BCrypt.hashpw(request.getParameter("hash"), GlobalConstants.SALT);
		String scope = request.getParameter("scope");
		String message = null;
		User up;
		UserDao uDao = new UserDaoImpl();
		try {
			// verify with database
			if (UserDaoImpl.verifyEmailHash(userId.toString(), hash) && scope.equals(GlobalConstants.ACTIVATION)) {
				// update status as active
				UserDaoImpl.updateStaus(userId.toString(), "active");
				message = "Email verified successfully. Account was activated. Clic <a href=\"sign-up-in.jsp\">here</a> to login";
			} else if (UserDaoImpl.verifyEmailHash(userId.toString(), hash)
					&& scope.equals(GlobalConstants.RESET_PASSWORD)) {
				// update status as active
				UserDaoImpl.updateStaus(userId.toString(), "active");
				// put some session for user
				request.getSession().setAttribute(GlobalConstants.USER_ID, userId);
				request.getSession().setAttribute("user", uDao.getUserById(userId));
				request.getSession().setAttribute(GlobalConstants.IS_RESET_PASSWORD_VERIFIED, GlobalConstants.YES);
				request.getRequestDispatcher("/resetPassword.jsp").forward(request, response);
			} else {
				// now increment verification attempts
				int attempts = UserDaoImpl.incrementVerificationAttempts(userId.toString());
				if (attempts == 20) {
					// reset verification code if attempts equal to 20
					String hashcode = Utils.prepareRandomString(30);
					UserDaoImpl.updateEmailVerificationHash(userId.toString(),
							BCrypt.hashpw(hashcode, GlobalConstants.SALT));
					up = UserDaoImpl.selectUSER(userId.toString());
					MailUtil.sendEmailRegistrationLink(userId.toString(), up.getuEmail(), hashcode);
					message = "20 times Wrong Email Validation Input Given. So we are sent new activation link to your Email";
				} else {
					message = "Wrong Email Validation Input";
				}
			}
		} catch (DBException e) {
			LOGGER.debug(e.getMessage());
			message = e.getMessage();
		} catch (AddressException e) {
			message = e.getMessage();
			LOGGER.debug(e.getMessage());
		} catch (MessagingException e) {
			message = e.getMessage();
			LOGGER.debug(e.getMessage());
		}
		if (message != null) {
			request.setAttribute(GlobalConstants.MESSAGE, message);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
