package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.User;

public interface UserService {

	User createUser(User users);
	
	User findUserById(Integer id);	
	
	ArrayList<User> getAllUsers();

}