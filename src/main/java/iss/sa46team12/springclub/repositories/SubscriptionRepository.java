package iss.sa46team12.springclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import iss.sa46team12.springclub.models.Subscription;


public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

}
