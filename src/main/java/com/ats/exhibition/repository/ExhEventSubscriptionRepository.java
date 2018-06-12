package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.exhibition.model.ExhEventSubscription;
@Repository
public interface ExhEventSubscriptionRepository extends JpaRepository<ExhEventSubscription, Integer>{

	
	ExhEventSubscription save(ExhEventSubscription exhEventSubscription);
	
	
}
