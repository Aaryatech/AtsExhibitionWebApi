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
	
	@Query(value = "SELECT COUNT(t_event_exh_mapping.exh_id) FROM t_event_exh_mapping WHERE t_event_exh_mapping.is_used=1 "
			+ "AND t_event_exh_mapping.event_id=:eventId"
			+ "", nativeQuery = true)
	Integer totalCountOfExhId(@Param("eventId") int eventId);
	
	
	
	@Query(value = "SELECT t_event_exh_mapping.* FROM t_event_exh_mapping WHERE t_event_exh_mapping.exh_id=:exhbId AND " + 
			"t_event_exh_mapping.is_used=1 "
			+ "", nativeQuery = true)
	List<EventExhMapping> getAllEventByExhbId(@Param("exhbId") int exhbId);


	@Query(value = "select em.map_id, em.event_id, e.event_name, em.exh_id , e.org_id as is_used  from t_event_exh_mapping em , "
			+ "m_events e where em.exh_id=:exhbId  and em.is_used=1 and em.event_id=e.event_id", nativeQuery = true)
	List<EventExhMapping> eventMappingListByExhibitorId(@Param("exhbId") int exhiId);


}
