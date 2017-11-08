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

import com.wishlist.model.Movie;
import com.wishlist.model.User;
import com.wishlist.service.FriendListService;
import com.wishlist.service.FriendListServiceImpl;
import com.wishlist.service.UserService;
import com.wishlist.service.UserServiceImpl;

@WebServlet("/myProfile")
public class MyProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FriendListService fList;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("my profile");
		UserService umove = new UserServiceImpl();
		List<User> users = new ArrayList<User>();
		List<User> followers = new ArrayList<User>();
		fList = new FriendListServiceImpl();

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<Movie> mvlist = null;

		users = fList.getFriendList(user.getuId());
		followers = fList.getFollowers(user.getuId());
		mvlist = umove.myLatestAddMovie(user.getuId(), 5);
		req.setAttribute("myMovieList", mvlist);
		req.setAttribute("friendList", users);
		req.setAttribute("followersList", followers);
		req.getRequestDispatcher("my-profile.jsp").forward(req, resp);

	}

}