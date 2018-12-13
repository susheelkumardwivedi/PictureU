package com.nagarro.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.services.ImageServiceProvider;


public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImageServiceProvider imageServiceProvider;
	@Override
	public void init() throws ServletException {
		imageServiceProvider=new ImageServiceProvider();
		super.init();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int imageId = Integer.parseInt(request.getParameter("id"));

			byte byteArray[] = imageServiceProvider.getImageById(imageId).getImage();
			
			response.setContentType("image/gif");
			OutputStream os = response.getOutputStream();
			os.write(byteArray);
			os.flush();
			os.close();
		}

	}

