package iss.sa46team12.springclub.services;

import iss.sa46team12.springclub.models.Subscription;

public interface SubscriptionService {
	
	Subscription createSubscription(Subscription subscription);

	Subscription findActiveSubscription(int i);

}
