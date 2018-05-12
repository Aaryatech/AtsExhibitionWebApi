package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.MapEventEmp;

public interface MapEventEmpRepository extends JpaRepository<MapEventEmp, Integer>{

	
	@Transactional
	@Modifying
	@Query("UPDATE MapEventEmp SET isUsed=0  WHERE map_id=:mapId")
	int deleteMapEventEmp(@Param("mapId") int mapId);
}
