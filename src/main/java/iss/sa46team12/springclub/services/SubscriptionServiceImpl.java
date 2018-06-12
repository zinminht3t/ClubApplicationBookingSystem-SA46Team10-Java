package iss.sa46team12.springclub.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import iss.sa46team12.springclub.repositories.SubscriptionRepository;


@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	@Resource
	SubscriptionRepository facrepo;
	
	
}
