package com.nagarro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.model.User;
import com.nagarro.services.RegisterService;
import com.nagarro.services.RegisterServiceProvider;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/registerThisUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegisterService registerService;
		@Override
		public void init() throws ServletException {
			registerService = new RegisterServiceProvider();
			super.init();
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	     String firstName = request.getParameter("firstName");
	     String middleName = request.getParameter("middleName");
	     String lastName = request.getParameter("lastName");
	     String emailId = request.getParameter("email");
	     String password = request.getParameter("password");
	     User user = new User(firstName,middleName,lastName, emailId, password);
	     
	     try(PrintWriter out = response.getWriter();) { 
	         boolean result = registerService.registerUser(user);      
	         if(result){
	             out.println("<h1>Thanks for Registering with us :</h1>");
	             request.getRequestDispatcher("/login.jsp").include(request, response);
	         }else{
	             out.println("<h1>Registration Failed Becase Email Id Alrady Exists</h1>");
	             request.getRequestDispatcher("/registeruser.jsp").include(request, response);
	         }
	     } 
	}
	             
}
