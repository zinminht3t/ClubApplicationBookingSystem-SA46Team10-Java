package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.User;

public interface UserService {

	User findUserById(Integer id);	
	
	ArrayList<User> getAllUsers();

}
