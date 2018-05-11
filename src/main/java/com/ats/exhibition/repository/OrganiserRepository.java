package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Organiser;

public interface OrganiserRepository extends JpaRepository<Organiser, Integer> {

	Organiser findByOrgId(int orgId);

	List<Organiser> findByIsUsed(int isUsed);

	@Transactional
	@Modifying
	@Query("UPDATE Organiser SET isUsed=0  WHERE org_id=:orgId")
	int deleteOrganiser(@Param("orgId") int orgId);

	Organiser findByUserMobAndUserPasswordAndIsUsed(String userMob, String userPassword, int i);

}
