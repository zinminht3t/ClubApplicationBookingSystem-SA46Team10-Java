package iss.sa46team12.springclub.services;

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
	
	
}
