package com.wishlist.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wishlist.model.User;
import com.wishlist.service.FollowFriendService;
import com.wishlist.service.FriendFollowServiceImpl;

@WebServlet("/follow")
public class FollowFriendController extends HttpServlet {
	FollowFriendService fSer;
	User user;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		fSer = new FriendFollowServiceImpl();
		user = new User();
		try {
			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("uid"));
			user = (User) session.getAttribute("user");

			fSer.followFriend(id, user.getuId());

			resp.sendRedirect("./friendProfile?uid=" + id);
			// @formatter:on

		} catch (Exception e) {
			System.out.println("friend follow" + e);
		}
	}

}
