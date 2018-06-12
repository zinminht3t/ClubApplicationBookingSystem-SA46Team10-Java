package iss.sa46team12.springclub.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iss.sa46team12.springclub.models.SubscriptionPackage;

public interface SubscriptionPackageRepository extends JpaRepository<SubscriptionPackage, Integer> {

	@Query("SELECT sp FROM SubscriptionPackage sp WHERE sp.active = true")
	ArrayList<SubscriptionPackage> findActiveSubscriptions();
	
}
