package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.exhibition.model.EventExhMappingWithExhName;

public interface EventExhMappingWithExhNameRepo extends JpaRepository<EventExhMappingWithExhName, Integer>{
	

	@Query(value = "SELECT c.*, e.exh_name FROM t_event_exh_mapping c,m_exhibitor e WHERE c.map_id=:mapId AND e.exh_id=c.exh_id AND c.is_used=1", nativeQuery = true)
	EventExhMappingWithExhName getExhMappingEmpByMapId(@Param("mapId") int mapId);
	
	
	@Query(value = "SELECT c.*, e.exh_name FROM t_event_exh_mapping c,m_exhibitor e WHERE e.exh_id=c.exh_id AND c.is_used=1", nativeQuery = true)
	List<EventExhMappingWithExhName> getAllExhMappingEmpByIsUsed();
	
	

}
