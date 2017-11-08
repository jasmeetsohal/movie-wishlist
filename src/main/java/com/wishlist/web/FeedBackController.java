package com.wishlist.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wishlist.service.FeedBackService;
import com.wishlist.service.FeedBackServiceImpl;

@WebServlet("/feedBack")
public class FeedBackController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FeedBackService fSer;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String subject = req.getParameter("subject");
		String mes = req.getParameter("message");
		fSer = new FeedBackServiceImpl();
		boolean res = fSer.sendFeedBack(name, email, subject, mes);
		req.setAttribute("feed", res);
		req.getRequestDispatcher("contact.jsp").forward(req, resp);
		// System.out.println(res);

	}

}
