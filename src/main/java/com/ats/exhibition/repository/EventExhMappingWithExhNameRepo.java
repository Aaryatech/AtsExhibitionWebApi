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

	@Query(value = "select \r\n" + 
			"    em.*,\r\n" + 
			"    ex.exh_name\r\n" + 
			"    from\r\n" + 
			"    t_event_exh_mapping em,\r\n" + 
			"    m_events e,\r\n" + 
			"    m_exhibitor ex\r\n" + 
			"    where \r\n" + 
			"    em.exh_id=:exhId\r\n" + 
			"    and em.exh_id = ex.exh_id\r\n" + 
			"    and em.is_used = 1\r\n" + 
			"    and e.event_id = em.event_id\r\n" + 
			"    and e.is_used = 1\r\n" + 
			"    and e.event_from_date between :fromDate and :toDate ", nativeQuery = true)
	List<EventExhMappingWithExhName> eventListByExhIdBetweenDate(@Param("exhId")int exhId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	

}
