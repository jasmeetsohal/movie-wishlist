package com.wishlist.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wishlist.dao.UserDaoImpl;
import com.wishlist.db.DBException;
import com.wishlist.model.StatusPojo;
import com.wishlist.model.User;
import com.wishlist.util.BCrypt;
import com.wishlist.util.GlobalConstants;
import com.wishlist.util.MailUtil;
import com.wishlist.util.Utils;

/**
 * Servlet implementation class RegisterEmail
 */
@WebServlet("/RegisterEmail")
public class RegisterEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(RegisterEmail.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterEmail() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// collect all input values
		String email = request.getParameter("inputEmail");
		// String firstName = request.getParameter("inputFirstName");
		String name = request.getParameter("inputLastName");
		String password = request.getParameter("inputPassword");
		StatusPojo sp = new StatusPojo();
		String output = "";
		if (!validate(email, name, password)) {
			sp.setCode(-1);
			sp.setMessage("Invalid Input");
			output = Utils.toJson(sp);
		} else {
			User up = new User();
			up.setuEmail(email);
			up.setuName(name);

			// generate hash for password
			up.setuPassword(BCrypt.hashpw(password, GlobalConstants.SALT));

			// generate hash code for email verification
			String hash = Utils.prepareRandomString(30);

			// generate hash for password
			up.setEMAIL_VERIFICATION_HASH(BCrypt.hashpw(hash, GlobalConstants.SALT));
			try {

				// check whether email exists or not
				if (!UserDaoImpl.isEmailExists(email)) {
					// create account if email not exists
					String id = UserDaoImpl.insertRow(up);
					// send verification email
					MailUtil.sendEmailRegistrationLink(id, email, hash);
					sp.setCode(0);
					sp.setMessage("Registation Link Was Sent To Your Mail Successfully. Please Verify Your Email");
					output = Utils.toJson(sp);
				} else {
					// tell user that the email already in use
					sp.setCode(-1);
					sp.setMessage("This Email was already registered");
					output = Utils.toJson(sp);
				}

			} catch (DBException | MessagingException e) {
				LOGGER.debug(e.getMessage());
				sp.setCode(-1);
				sp.setMessage(e.getMessage());
				output = Utils.toJson(sp);
			}
		}
		// send output to user
		PrintWriter pw = response.getWriter();
		pw.write(output);
		pw.flush();
		pw.close();
	}

	public static boolean validate(String email, String name, String password) {
		if (email == null) {
			return false;
		}

		if (name == null) {
			return false;
		}
		if (password == null) {
			return false;
		}
		return true;
	}
}
