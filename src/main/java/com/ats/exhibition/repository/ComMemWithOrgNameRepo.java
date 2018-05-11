package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ComMemWithOrgName;

public interface ComMemWithOrgNameRepo extends JpaRepository<ComMemWithOrgName, Integer> {

	@Query(value = "SELECT c.*, o.org_name FROM m_org_committee_members c,m_organiser o WHERE c.org_id=:orgId AND o.org_id=c.org_id", nativeQuery = true)
	List<ComMemWithOrgName> getAllCommitteeMembersByOrgId(@Param("orgId") int orgId);

}
