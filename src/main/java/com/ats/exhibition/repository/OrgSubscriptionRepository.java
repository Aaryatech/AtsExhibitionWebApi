package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.exhibition.model.OrgSubscription;

public interface OrgSubscriptionRepository extends JpaRepository<OrgSubscription, Integer> {

	OrgSubscription findByOrgIdAndStatus(int orgId, int status);

	

}
