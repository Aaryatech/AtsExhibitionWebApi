package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.OrgSubscriptionDetail;

public interface OrgSubscriptionDetailRepo extends JpaRepository<OrgSubscriptionDetail, Integer> {
	
	
	@Transactional
	@Modifying
	@Query("UPDATE OrgSubscriptionDetail SET isUsed=0  WHERE org_sub_detail_id=:orgSubDetailId")
	int deleteOrgSubscriptionDetail(@Param("orgSubDetailId") int orgSubDetailId);

}
