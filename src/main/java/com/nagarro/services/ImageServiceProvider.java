package com.nagarro.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.hibernate.util.Connection;
import com.nagarro.model.Image;

public class ImageServiceProvider implements ImageServices {
	@Override
	public boolean saveImage(Image image) {
		EntityTransaction transaction = null;
		boolean result = false;
		try (Session session = Connection.getSession();) {
			transaction = session.getTransaction();
			transaction.begin();
			session.save(image);
			result = true;
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				result=false;
			}
		}

		return result;
	}

	@Override
	public List<Image> getAllImageOfUser(String userId) {
		List<Image> resultImage = new ArrayList<Image>();
		List<Image> imageList = null;
		try (Session session = Connection.getSession();) {
			Query query = session.createQuery("from Image image");
			imageList = query.getResultList();
			for (Image image : imageList) {
				if (image.getUser().getEmail().compareTo(userId) == 0) {
					resultImage.add(image);
				}
			}
		} catch (Exception e) {

		}
		return resultImage;
	}

	@Override
	public Image getImageById(long imageId) {
		Image image = null;
		try (Session session = Connection.getSession();) {
			image = (Image) session.get(Image.class, imageId);
		}
		return image == null ? null : image;
	}

	@Override
	public boolean updateImage(Image image) {
		Transaction transaction=null;
		boolean result=false;
		try(Session session=Connection.getSession();){
			transaction=session.getTransaction();
			session.beginTransaction();
			session.update(image);
			result=true;
			transaction.commit();
		}catch(Exception e){
			if(transaction!=null){
				transaction.rollback();
				result=false;
			}
		}
		return result;
	}
	@Override
	public boolean deleteImageById(long imageId) {
		org.hibernate.Transaction transaction = null;
		boolean result = false;
		try (Session session = Connection.getSession();) {
			Image image = getImageById(imageId);
			transaction = session.getTransaction();
			session.beginTransaction();
			session.delete(image);
			result = true;
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				result = false;
			}
		}
		return result;
	}
}