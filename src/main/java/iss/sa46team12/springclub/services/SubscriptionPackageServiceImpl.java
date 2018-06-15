package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.SubscriptionPackage;
import iss.sa46team12.springclub.repositories.SubscriptionPackageRepository;

@Service
public class SubscriptionPackageServiceImpl implements SubscriptionPackageService {

	@Resource
	SubscriptionPackageRepository subscriptionPackageRepository;

	@Override
	@Transactional
	public ArrayList<SubscriptionPackage> findAllSubscriptionPackages() {
		return (ArrayList<SubscriptionPackage>) subscriptionPackageRepository.findAll();
	}

	@Override
	@Transactional
	public ArrayList<SubscriptionPackage> findActiveSubscriptionPackages() {
		return subscriptionPackageRepository.findActiveSubscriptions();
	}

	@Override
	@Transactional
	public SubscriptionPackage findPackage(int packageid) {
		return subscriptionPackageRepository.findOne(packageid);
	}

}
