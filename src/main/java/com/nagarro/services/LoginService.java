package com.nagarro.services;

import com.nagarro.model.User;

public interface LoginService {
		boolean authenticateUser(String emailId,String password);
		User getUserById(String emailId);
}
