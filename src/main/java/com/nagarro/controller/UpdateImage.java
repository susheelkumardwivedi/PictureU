package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.model.Image;
import com.nagarro.services.ImageServiceProvider;
import com.nagarro.util.ImageReader;

/**
 * Servlet implementation class UploadImage
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 10)
public class UpdateImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImageServiceProvider imageService;
	ImageReader imageReader;
	@Override
	public void init() throws ServletException {
		imageService = new ImageServiceProvider();
		imageReader=new ImageReader();
		super.init();
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			Image newImage=imageReader.getImageObject(request);
			long imageId=Long.parseUnsignedLong(request.getParameter("id"));
			newImage.setId(imageId);
			boolean result=imageService.updateImage(newImage);
			if (result == true) {
				request.getRequestDispatcher("/showimage").forward(request, response);
			} else {
				request.getRequestDispatcher("imageUploadFail.jsp").forward(request, response);
			}
		}

	}


