package iss.sa46team12.springclub.services;

import java.sql.Date;
import java.util.ArrayList;

import iss.sa46team12.springclub.models.Subscription;

public interface SubscriptionService {

	
	Subscription createSubscription(Subscription subscription);

	Subscription findActiveSubscription(int i);

	public ArrayList<Subscription> findall();
	ArrayList<Subscription> findUserByDate(Date date);

	Subscription editSub(Subscription u);
}
