package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.CommitteeMembers;

public interface CommitteeMemRepository extends JpaRepository<CommitteeMembers, Integer> {

	
	@Query(value = "SELECT c.* FROM m_org_committee_members c", nativeQuery = true)
	List<CommitteeMembers> findCommitteeMembers();
	
	@Transactional
	@Modifying
	@Query("UPDATE CommitteeMembers SET isUsed=0  WHERE mem_id=:memId")
	int deleteCommitteeMember(@Param("memId") int memId);
}
