package iss.sa46team12.springclub.repositories;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Maintenance;
import iss.sa46team12.springclub.models.Subscription;


public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

	@Query("select s from Subscription s where s.active = true and s.userid=:uid and s.expirydate IN (select max(ss.expirydate) from Subscription ss)")
	Subscription findActiveSubscription(@Param("uid") int userid);
	

//	@Query (value="select s from Subscriptions s where s.active = true and s.userid=:uid and s.expirydate IN (select max(ss.expirydate) from Subscriptions ss) limit 1", nativeQuery=true)
//	Subscription findActiveSubscription(@Param("uid") int userid);
}
