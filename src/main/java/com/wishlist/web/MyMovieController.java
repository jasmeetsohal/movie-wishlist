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
import com.wishlist.service.UserServiceImpl;

/**
 * Servlet implementation class MyMovieController
 */
@WebServlet("/MyMovie")
public class MyMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String offsetValue = request.getParameter("num");
		User user = new User();
		List<Movie> mvlist = null;
		if (offsetValue != null) {
			user = (User) session.getAttribute("user");
			UserServiceImpl umove = new UserServiceImpl();
			mvlist = umove.myMovie(user.getuId(), Integer.parseInt(offsetValue));
		}

		else {
			user = (User) session.getAttribute("user");
			UserServiceImpl umove = new UserServiceImpl();
			mvlist = umove.myMovie(user.getuId(), 0);
		}

		System.out.println(user.getuName());
		request.setAttribute("myMovieList", mvlist);
		request.getRequestDispatcher("/my-movies.jsp").forward(request, response);
	}
}
