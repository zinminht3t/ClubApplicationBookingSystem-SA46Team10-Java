package iss.sa46team12.springclub.services;

import iss.sa46team12.springclub.models.User;

public interface UserService {

	User findUserById(Integer id);
	User authenticate(String uname, String pwd);
}
