
package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.SubscriptionPackage;

public interface SubscriptionPackageService {

	ArrayList<SubscriptionPackage> findAllSubscriptionPackages();

	ArrayList<SubscriptionPackage> findActiveSubscriptionPackages();

	SubscriptionPackage findPackage(int packageid);
}