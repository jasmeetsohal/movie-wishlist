package com.wishlist.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wishlist.dao.UserDaoImpl;
import com.wishlist.db.DBException;
import com.wishlist.model.StatusPojo;
import com.wishlist.model.User;
import com.wishlist.service.FollowFriendService;
import com.wishlist.service.FriendFollowServiceImpl;
import com.wishlist.util.BCrypt;
import com.wishlist.util.GlobalConstants;
import com.wishlist.util.Utils;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
	private static String mId = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userId = (String) request.getSession().getAttribute(GlobalConstants.USER_ID);
		mId = request.getParameter("movieId");
		System.out.println(mId + " dddddddddddddddddddddddddddddddd");
		if (mId != null || mId != "") {
			request.getRequestDispatcher("wishlist?movieId=" + mId).forward(request, response);
		} else {
			out.println("else ");

			// doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputEmail = request.getParameter("inputEmail");

		String inputPassword = BCrypt.hashpw(request.getParameter("inputPassword"), GlobalConstants.SALT);
		StatusPojo sp = new StatusPojo();
		LOGGER.debug(inputEmail);
		try {
			User up = UserDaoImpl.verifyLogin(inputEmail, inputPassword);
			if (up != null) {
				if (up.getSTATUS().equals(GlobalConstants.ACTIVE)
						|| up.getSTATUS().equals(GlobalConstants.IN_RESET_PASSWORD)) {
					request.getSession().setAttribute(GlobalConstants.USER_ID, up.getuId());
					request.getSession().setAttribute(GlobalConstants.USER_NAME, up.getuName());
					sp.setCode(0);
					sp.setMessage("Success");
					FollowFriendService fService = new FriendFollowServiceImpl();
					List<User> notify = new ArrayList<User>();
					notify = fService.getNotification(up.getuId());
					HttpSession session = request.getSession();
					session.setAttribute("user", up);
					session.setAttribute("notify", notify);
					String referrer = request.getHeader("referer");
					if (request.getHeader("referer").substring(36).equals("sign-up-in.jsp")) {
						request.getRequestDispatcher("index.jsp").forward(request, response);

					} else {

						System.out.println(referrer.substring(36));
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/wishlist?" + referrer.substring(45));
						dispatcher.forward(request, response);
					}

				} else if (up.getSTATUS().equals(GlobalConstants.NEW)) {
					sp.setCode(-1);
					sp.setMessage("Account activation is in pending");
				} else {
					sp.setCode(-1);
					sp.setMessage("Unknown error");
				}

			} else {
				sp.setCode(-1);
				sp.setMessage("Email or Password is not valid");
			}
		} catch (DBException e) {
			LOGGER.debug(e.getMessage());
			sp.setCode(-1);
			sp.setMessage(e.getMessage());
		}
		PrintWriter pw = response.getWriter();
		pw.write(Utils.toJson(sp));
		pw.flush();
		pw.close();
	}

}
