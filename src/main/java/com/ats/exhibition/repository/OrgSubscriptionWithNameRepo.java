package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.OrgSubscriptionWithName;

public interface OrgSubscriptionWithNameRepo extends JpaRepository<OrgSubscriptionWithName, Integer> {

	@Query(value = "SELECT c.*, o.org_name,p.pkg_name FROM t_org_subscription c,m_organiser o,m_package p  WHERE c.pkg_id=p.pkg_id AND o.org_id=c.org_id AND c.is_used=1", nativeQuery = true)
	List<OrgSubscriptionWithName> getAllSubscriptions();

	
	@Query(value = "SELECT c.*, o.org_name,p.pkg_name FROM t_org_subscription c,m_organiser o,m_package p  WHERE c.sub_id=:subId AND  c.pkg_id=p.pkg_id AND o.org_id=c.org_id AND c.is_used=1", nativeQuery = true)
	OrgSubscriptionWithName getSubscriptionById(@Param("subId") int subId);

	
	
}
