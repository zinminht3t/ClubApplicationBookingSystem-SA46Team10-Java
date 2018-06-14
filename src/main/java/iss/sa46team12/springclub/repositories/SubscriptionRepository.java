package iss.sa46team12.springclub.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
	@Query("SELECT s FROM Subscription s where s.expirydate=:date")
	ArrayList<Subscription> findByDate(@Param("date") Date date);

	@Query(value = "select s.* from Subscriptions s where s.active = true and s.userid = :uid and s.expirydate IN (select max(ss.expirydate) from Subscriptions ss where ss.userid = :uid) limit 1", nativeQuery = true)
	Subscription findActiveSubscription(@Param("uid") int userid);
}
