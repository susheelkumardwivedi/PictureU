package com.nagarro.services;

import com.nagarro.model.User;

public interface RegisterService {
	boolean isUserAlreadyExit(String emailId);
	boolean registerUser(User user);
}
