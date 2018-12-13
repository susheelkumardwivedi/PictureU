package com.nagarro.services;

import org.hibernate.Session;

import com.nagarro.hibernate.util.Connection;
import com.nagarro.model.User;

public class LoginServiceProvider implements LoginService{

	@Override
	public boolean authenticateUser(String emailId, String password) {
		User user=null;
		boolean result=false;
		try(Session session=Connection.getSession();){
			user=(User)session.get(User.class, emailId);
			if(user!=null){
				result=password.equals(user.getPassword());
			}
			
		}catch(Exception e){
			
			}
		return result;
	}

	@Override
	public User getUserById(String emailId) {
		User user=null;
		try(Session session=Connection.getSession();){
			user=(User)session.get(User.class, emailId);
		}catch(Exception e){
			
			}
		return user;
	}

}
