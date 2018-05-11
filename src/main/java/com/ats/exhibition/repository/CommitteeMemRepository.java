package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.exhibition.model.CommitteeMembers;

public interface CommitteeMemRepository extends JpaRepository<CommitteeMembers, Integer> {

	
	@Query(value = "SELECT c.* FROM m_org_committee_members c", nativeQuery = true)
	List<CommitteeMembers> findCommitteeMembers();
}
