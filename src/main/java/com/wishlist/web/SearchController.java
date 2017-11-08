package com.wishlist.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wishlist.model.Movie;
import com.wishlist.service.SearchServiceImpl;

/**
 * Servlet implementation class UserHomeController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String movieTitle = request.getParameter("mtitle");
		String movieId = request.getParameter("mid");
		if (movieTitle != null) {
			SearchServiceImpl ss = new SearchServiceImpl();

			try {

				List<Movie> movieList = ss.byTitle(movieTitle);
				// HttpSession session = request.getSession();
				// List<String> imdbId = ss.getAddedMovieList(((User)
				// session.getAttribute("user")).getuId());
				request.setAttribute("movieList", movieList);
				// request.setAttribute("imdbid", imdbId);

				int page = ss.getTotalPages(ss.getTotalResults());
				request.setAttribute("total", page);

				request.getRequestDispatcher("/searchByTitle.jsp").forward(request, response);
			} catch (java.net.UnknownHostException ue) {
				ue.printStackTrace();
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} else if (movieId != null) {
			SearchServiceImpl ss = new SearchServiceImpl();
			try {
				Movie movieDetail = ss.byId(movieId);
				request.setAttribute("movieDetail", movieDetail);
				request.getRequestDispatcher("/movie-detail.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} else {
			System.out.println("Else executing");
		}
	}
}
