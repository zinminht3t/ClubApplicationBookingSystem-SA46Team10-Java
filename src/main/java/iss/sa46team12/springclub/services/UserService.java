package iss.sa46team12.springclub.services;


import java.sql.Date;
import java.util.ArrayList;

import iss.sa46team12.springclub.models.User;

public interface UserService {

	ArrayList<User> findAllUsers();
	
<<<<<<< HEAD
	User findByEmail(String uname);
	
	//User findUserByNric(String nric);		
=======
//	User findUserByNric(String nric);		
>>>>>>> branch 'master' of https://github.com/zinminht3t/SA46Team12CABProject

	User editUser(User u);

	ArrayList<User> findUserByCriteria(User user);

	User createUser(User users);
	
	User findUserById(Integer id);	
	
	ArrayList<User> getAllUsers();
	
	User authenticate(String uname, String pwd);
	
//	ArrayList<User> getAllUserByDate(Date date);
}
