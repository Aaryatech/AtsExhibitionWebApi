package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Sponsor;
@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Sponsor SET isUsed=0  WHERE sponsorId=:sponsorId")
	int deleteSponsor(@Param("sponsorId")int sponsorId);

	Sponsor findBySponsorId(int sponsorId);

}
