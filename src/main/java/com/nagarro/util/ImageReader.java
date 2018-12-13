package com.nagarro.util;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.nagarro.model.Image;
import com.nagarro.model.User;

public class ImageReader {
		public Image getImageObject(HttpServletRequest request) throws ServletException,IOException {
			Part part = request.getPart("file");
			if(part==null){
				System.out.println("hello part");
				return null;
			}
			String imageName = getFileName(part);
			int imageSize = (int) part.getSize();
			InputStream inputStream = part.getInputStream();
			byte[] imageStream = new byte[imageSize];
			if(inputStream.read(imageStream)!=imageSize){
				throw new IOException("error reading stream");
			}
			User user = (User) request.getSession().getAttribute("user");
			Image image = new Image(user, imageName, imageSize, imageStream);
			return image;
		}
		
		private String getFileName(Part part) {
			String contentDisp = part.getHeader("content-disposition");
			System.out.println("content-disposition header= " + contentDisp);
			String[] tokens = contentDisp.split(";");
			for (String token : tokens) {
				if (token.trim().startsWith("filename")) {
					return token.substring(token.indexOf("=") + 2,
							token.length() - 1);
				}
			}
			return "";
		}
}
