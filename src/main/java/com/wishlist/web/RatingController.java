package com.wishlist.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wishlist.model.Movie;
import com.wishlist.model.Rating;
import com.wishlist.model.User;
import com.wishlist.service.RatingServiceImpl;




@WebServlet("/rateMovie")

public class RatingController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws IOException , ServletException
	{
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = new User();
		user = (User) session.getAttribute("user");
		int id = user.getuId();
		int rating = Integer.parseInt(request.getParameter("my_input"));
		String comment = request.getParameter("comment");
		String mid = request.getParameter("movieId");
		
		Rating rr = new Rating();
		rr.setuId(id);
		rr.setRating(rating);
		rr.setComment(comment);
		rr.setmId(mid);
		
		
		RatingServiceImpl rService = new RatingServiceImpl();
	     boolean result =rService.validateIt(rr);
	     response.sendRedirect("./review?movieId="+mid);
			
	     if(result == true)
	     {
	    	 out.println("Rating Succeful");
	     }
	     
	}
	
	

}
