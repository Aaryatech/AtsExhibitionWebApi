package com.ats.exhibition.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.FloarMap;

@Repository
public interface FloarMapRepository extends JpaRepository<FloarMap, Integer>{


	@Transactional
	@Modifying
	@Query("UPDATE FloarMap SET isUsed=0  WHERE floarMapId=:floarMapId")
	int deleteFloarMap(@Param("floarMapId")int floarMapId);

}
