package iss.sa46team12.springclub.services;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.repositories.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
//	@Resource
//	UserRepository userRepository;
//	
//	@Override
//	@Transactional
//	public User validateuser(String user, String password) {
//		// if method to see if user role is active
////		return user.equalsIgnoreCase("jayden") && password.equals("plswork");
//		User u = userRepository.findUserbyEmailPwd(user, password);
//		return u;
//	}
	
//	@Override
//	@Transactional
//	public String checkuserrole(String user) {
//		return userRepository.findRoleByEmail(user);
//	}

}
