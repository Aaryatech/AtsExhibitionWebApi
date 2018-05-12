package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.EventExhMapping;

public interface EventExhMappingRepository  extends JpaRepository <EventExhMapping, Integer> {

	List<EventExhMapping> findByEventIdAndIsUsed(int eventId, int isUsed);
	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE EventExhMapping SET isUsed=0  WHERE map_id=:mapId")
	int deleteExhMapping(@Param("mapId") int mapId);

}
