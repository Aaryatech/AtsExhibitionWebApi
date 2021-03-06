package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Location SET isUsed=0  WHERE location_id=:locationId")
	int deleteLocation(@Param("locationId") int locationId);

	List<Location> findAllByIsUsed(int i);

	Location findByLocationIdAndIsUsed(int locationId, int i);

	


	
	

}
