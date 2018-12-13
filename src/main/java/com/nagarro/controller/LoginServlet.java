package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.model.User;
import com.nagarro.services.ImageServices;
import com.nagarro.services.LoginService;
import com.nagarro.services.LoginServiceProvider;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private ImageServices imageService;
	@Override
	public void init() throws ServletException {
		 loginService=new LoginServiceProvider();
		 super.init();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 String userId=request.getParameter("userName");
		 String userPassword=request.getParameter("userPassword");
		 boolean result=loginService.authenticateUser(userId, userPassword);
		 if(result==true){
			 User user=loginService.getUserById(userId);
			 request.getSession().setAttribute("user", user);
			 request.getRequestDispatcher("/showimage").forward(request, response);
		 }else{
			
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		 }
	}

}
