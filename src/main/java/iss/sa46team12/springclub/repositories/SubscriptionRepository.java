package iss.sa46team12.springclub.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Subscription;


public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
	@Query("SELECT s FROM Subscription s where s.expirydate=:date")
	ArrayList <Subscription> findByDate(@Param("date") Date date);
}
