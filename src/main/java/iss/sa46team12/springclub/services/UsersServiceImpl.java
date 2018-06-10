package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.Users;
import iss.sa46team12.springclub.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Resource
	UsersRepository uRepo;
	
	@Override
	@Transactional
	public Users createUser(Users users) {
		return uRepo.saveAndFlush(users);
	}
	

}
