package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.OrgSubscription;

public interface OrgSubscriptionRepository extends JpaRepository<OrgSubscription, Integer> {

	OrgSubscription findByOrgIdAndStatus(int orgId, int status);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE OrgSubscription SET isUsed=0  WHERE sub_id=:subId")
	int deleteOrgSubscription(@Param("subId") int subId);

	List<OrgSubscription> findAllOrgSubscriptionByIsUsed(int i);


	OrgSubscription findBySubId(int subId);	

}
