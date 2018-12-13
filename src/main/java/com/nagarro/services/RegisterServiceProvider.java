package com.nagarro.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.hibernate.util.Connection;
import com.nagarro.model.User;

public class RegisterServiceProvider implements RegisterService{
	@Override
	public boolean registerUser(User user){
		boolean result=false;
	     if(isUserAlreadyExit(user.getEmail())!=false){
	     Transaction transaction = null;
	     try(Session session = Connection.getSession();) {
	         transaction = session.getTransaction();
	         transaction.begin();
	         session.save(user);
	         result=true;
	         transaction.commit();
	     } catch (Exception e) {
	         if (transaction != null) {
	             transaction.rollback();
	             result=false;
	         }
	     }
	     }
	     return result;
	}
	@Override 
	public boolean isUserAlreadyExit(String emailId){
	     User user=null;
	     try ( Session session = Connection.getSession();){
	    	  user=(User) session.get(User.class,emailId);
	     }catch(Exception ex){
	        
	     }
	     return (user==null);
	}

	
}
