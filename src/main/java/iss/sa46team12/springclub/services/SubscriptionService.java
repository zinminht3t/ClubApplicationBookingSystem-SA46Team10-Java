package iss.sa46team12.springclub.services;

import java.sql.Date;
import java.util.ArrayList;

import iss.sa46team12.springclub.models.Subscription;

public interface SubscriptionService {

	public ArrayList<Subscription> findall();
	ArrayList<Subscription> findUserByDate(Date date);
}
