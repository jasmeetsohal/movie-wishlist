package com.wishlist.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wishlist.model.Movie;
import com.wishlist.model.User;
import com.wishlist.service.FollowFriendService;
import com.wishlist.service.FriendFollowServiceImpl;
import com.wishlist.service.UserService;
import com.wishlist.service.UserServiceImpl;

@WebServlet("/friendProfile")
public class FriendProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FollowFriendService fService;
		try {
			boolean isFollow = false;
			User user = new User();
			fService = new FriendFollowServiceImpl();
			UserService us = new UserServiceImpl();
			List<Movie> mvList = null;
			HttpSession session = req.getSession();

			int uId = Integer.parseInt(req.getParameter("uid"));
			user = us.getUserById(uId);
			mvList = us.myLatestAddMovie(uId, 5);
			isFollow = fService.isAlreadyExist(uId, ((User) session.getAttribute("user")).getuId());
			req.setAttribute("myMovieList", mvList);
			req.setAttribute("ownUser", user);
			req.setAttribute("isFollow", isFollow);

			req.getRequestDispatcher("friend-profile.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("Controller exception " + e);
		}

	}

}
