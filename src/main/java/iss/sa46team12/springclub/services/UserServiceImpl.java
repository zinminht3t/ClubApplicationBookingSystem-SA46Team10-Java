package iss.sa46team12.springclub.services;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserRepository urepo;
	
	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		return (ArrayList<User>) urepo.findAll();	
		}
		
//	@Override
//	@Transactional
//	public User findUserByNric(String nric) {
//		User user = urepo.findOne(nric);		 
//		return user;
//	}	
	
	@Override
	@Transactional
	public User editUser(User u) {
		return urepo.saveAndFlush(u);
	}
	
	@Override
	@Transactional
	public ArrayList<User> findUserByCriteria(User user) {
		return null;
	}

}
