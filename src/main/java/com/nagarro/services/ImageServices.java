package com.nagarro.services;

import java.util.List;

import com.nagarro.model.Image;

public interface ImageServices {
	boolean saveImage(Image image);
	List<Image> getAllImageOfUser(String userId);
	Image getImageById(long imageId);
	boolean deleteImageById(long imageId);
	boolean updateImage(Image image);
}
