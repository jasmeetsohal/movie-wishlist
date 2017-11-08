package com.wishlist.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wishlist.model.User;
import com.wishlist.service.FollowFriendService;
import com.wishlist.service.FriendFollowServiceImpl;
import com.wishlist.service.UserServiceImpl;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/login")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("uEmail");
		String password = request.getParameter("uPass");

		List<User> notify = new ArrayList<User>();
		FollowFriendService fService = new FriendFollowServiceImpl();
		UserServiceImpl userService = new UserServiceImpl();
		User user = userService.login(email, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			notify = fService.getNotification(user.getuId());
			session.setAttribute("notify", notify);
			// System.out.println("notify ......................." +
			// notify.getuName());
			response.sendRedirect("index.jsp");

		} else
			out.println("Authentication failed");
	}

}
