package com.niit.DAO;

import com.niit.model.User;

public interface UserDAO {
public boolean registerUser(User user);
public boolean checkUser(User user);
public User getUser(String loginname);
	
	
}
