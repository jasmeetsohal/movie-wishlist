package com.wishlist.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wishlist.model.User;
import com.wishlist.service.SearchFriendService;
import com.wishlist.service.SearchFriendServiceImpl;

@WebServlet("/searchFrieds")
public class SearchFriendController extends HttpServlet {
	SearchFriendService sFrnd;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = new ArrayList<User>();
		try {
			sFrnd = new SearchFriendServiceImpl();
			users = sFrnd.searchFriendByName(req.getParameter("user-search"));
			req.setAttribute("users", users);
			req.getRequestDispatcher("search-friend-list.jsp").forward(req, resp);

		} catch (Exception e) {

		}
	}

}
