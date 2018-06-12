package iss.sa46team12.springclub.services;

import java.sql.Date;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.Subscription;
import iss.sa46team12.springclub.repositories.SubscriptionRepository;


@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	@Resource
	SubscriptionRepository facrepo;
	
	@Override
	@Transactional
	public ArrayList<Subscription> findUserByDate(Date date) {
		ArrayList<Subscription> getuserbydate = facrepo.findByDate(date);
		return getuserbydate;
	}
	
	@Override
	@Transactional
	public ArrayList<Subscription> findall(){
		return (ArrayList<Subscription>) facrepo.findAll();
	}

	
}
