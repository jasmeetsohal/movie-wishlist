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
import com.wishlist.model.Review;
import com.wishlist.model.User;
import com.wishlist.service.SearchServiceImpl;
import com.wishlist.service.UserServiceImpl;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public ReviewController()
   {
	   super();
   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieId = request.getParameter("movieId");
		
		HttpSession session = request.getSession();
		 session.getAttribute("user");
		UserServiceImpl search = new UserServiceImpl();
		Movie movie = new Movie();
		movie = search.aMovie(movieId);
		System.out.println("Movie Id"+movie.getMovieId());
		List<Review> moviereview= search.allReview(movieId);
		System.out.println("controller"+movieId);
		System.out.println("cont"+moviereview);
		User user= new User();
		String username= user.getuName();
		System.out.println(username);
		request.setAttribute("userName", username);
		request.setAttribute("myReviewList", moviereview);
		request.setAttribute("aMovie", movie);
		request.getRequestDispatcher("/review.jsp").forward(request, response);
		
		
	}

	

}
