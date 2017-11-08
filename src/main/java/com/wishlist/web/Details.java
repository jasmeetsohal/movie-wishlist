package com.wishlist.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wishlist.model.Movie;
import com.wishlist.service.SearchServiceImpl;

/**
 * Servlet implementation class AddToWishlistController
 */
@WebServlet("/details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String movieId = request.getParameter("movieId");

		SearchServiceImpl search = new SearchServiceImpl();
		try {
			Movie movie = search.byId(movieId);
			request.setAttribute("movieDetail", movie);
			request.getRequestDispatcher("/movie-detail.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
