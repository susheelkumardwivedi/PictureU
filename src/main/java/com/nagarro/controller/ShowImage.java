package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.model.Image;
import com.nagarro.model.User;
import com.nagarro.services.ImageServiceProvider;
import com.nagarro.services.ImageServices;

/**
 * Servlet implementation class ShowImage
 */
public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImageServices imageServices;
	
	@Override
	public void init() throws ServletException {
		imageServices=new ImageServiceProvider();
		super.init();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		 List<Image> imageList=imageServices.getAllImageOfUser(user.getEmail());
		 request.setAttribute("imageList", imageList);
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
		 response.setHeader("Pragma", "no-cache");
		 request.getRequestDispatcher("/imageviewer.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		System.out.println(user.getEmail());
		 List<Image> imageList=imageServices.getAllImageOfUser(user.getEmail());
		 System.out.println(imageList.size()+"fsfsfsdf===");
		 request.setAttribute("imageList", imageList);
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
		 response.setHeader("Pragma", "no-cache");
		 request.getRequestDispatcher("/imageviewer.jsp").forward(request, response);
	}

}
