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
	UserRepository userRepository;

	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		return (ArrayList<User>) userRepository.findAll();
	}

	@Override
	@Transactional
	public User editUser(User u) {
		return userRepository.saveAndFlush(u);
	}

	@Override
	@Transactional
	public ArrayList<User> findUserByCriteria(User user) {
		return null;
	}

	@Override
	@Transactional
	public User createUser(User users) {
		return userRepository.saveAndFlush(users);
	}

	@Override
	@Transactional
	public User findUserById(Integer userId) {
		return userRepository.findOne(userId);
	}

	@Override
	@Transactional
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (ArrayList<User>) userRepository.findAll();
	}

	// @Transactional
	// public User authenticate(String user, String pwd) {
	// User u = userRepository.findUserbyEmailPwd(user, pwd);
	// return u;
	// }

	@Override
	@Transactional
	public User authenticate(String uname, String pwd) {
		User u = userRepository.findUserByNamePwd(uname, pwd);
		return u;
	}

	@Override
	@Transactional
	public User findByEmail(String uname) {
		User u = userRepository.findUserByName(uname);
		return u;
	}
	// @Override
	// @Transactional
	// public ArrayList<User> findUserByDate(Date date) {
	// ArrayList<User> getuserbydate = userRepository.findUserByDate(date);
	// return getuserbydate;
	// }

}
