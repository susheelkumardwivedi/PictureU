package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.services.ImageServiceProvider;
import com.nagarro.services.ImageServices;

/**
 * Servlet implementation class DeleteImage
 */
public class DeleteImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImageServices imageServices;
	@Override
	public void init() throws ServletException {
		imageServices=new ImageServiceProvider();
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		    long imageId = Integer.parseInt(request.getParameter("id"));
		    boolean result=imageServices.deleteImageById(imageId);
		    if(result==true){
		    	request.getRequestDispatcher("/showimage").forward(request, response);
		    }else{
		    	
		    }
	}
}
