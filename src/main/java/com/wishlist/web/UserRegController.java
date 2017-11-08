package com.wishlist.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wishlist.model.User;
import com.wishlist.service.UserService;
import com.wishlist.service.UserServiceImpl;

/**
 * Servlet implementation class UserRegController
 */
@WebServlet("/reg")
public class UserRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upass");

		UserService service = new UserServiceImpl();
		String msg = service.checkByEmail(email);

		if (msg.equals("not-found")) {
			User user = new User();
			user.setuName(name);
			user.setuEmail(email);
			user.setuPassword(password);
			int id = service.register(user);

			if (id != 0) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", id);
				RequestDispatcher req = request.getRequestDispatcher("index.jsp");
				req.forward(request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		}

		else {
			out.println("User Already Exist");
		}
	}

}
