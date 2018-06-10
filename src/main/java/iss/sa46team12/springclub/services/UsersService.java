package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.Users;

public interface UsersService {

	Users createUser(Users users);

}