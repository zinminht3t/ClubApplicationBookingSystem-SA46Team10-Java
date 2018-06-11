package iss.sa46team12.springclub.services;

import iss.sa46team12.springclub.models.User;

public interface UserService {

	User createUser(User users);
	
	User findUserById(Integer id);	
	
	ArrayList<User> getAllUsers();
	
	User authenticate(String uname, String pwd);
}
