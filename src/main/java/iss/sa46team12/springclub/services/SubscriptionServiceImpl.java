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
	SubscriptionRepository srepo;

	@Override
	@Transactional
	public Subscription findActiveSubscription(int i) {
		return srepo.findActiveSubscription(1);
	}

	@Override
	@Transactional
	public Subscription createSubscription(Subscription subscription) {
		return srepo.saveAndFlush(subscription);
	}
	
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
