package com.wishlist.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wishlist.model.Movie;
import com.wishlist.model.User;
import com.wishlist.service.AddToWishlistServiceImpl;
import com.wishlist.service.SearchServiceImpl;

/**
 * Servlet implementation class AddToWishlistController
 */
@WebServlet("/wishlist")
public class AddToWishlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToWishlistController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String movieId = request.getParameter("movieId");
		System.out.println(movieId);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		SearchServiceImpl search = new SearchServiceImpl();
		try {
			Movie movie = search.byId(movieId);
			AddToWishlistServiceImpl addToWishlist = new AddToWishlistServiceImpl();
			boolean b = addToWishlist.addToWishlist(user.getuId(), movie);
			if (b) {
				System.out.println("added to wishlist");
				request.getRequestDispatcher("./MyMovie").forward(request, response);
				// request.getRequestDispatcher("index.jsp");
			} else {
				System.out.println("not added");
				request.getRequestDispatcher("./MyMovie").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
