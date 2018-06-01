package com.ats.exhibition.repository.eventhistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.eventhistory.GetAllEventForExhb;

public interface GetAllEventForExhbRepo  extends JpaRepository<GetAllEventForExhb, Integer>{
	
	@Query(value = " SELECT t_event_exh_mapping.event_id,m_events.event_name,m_exhibitor.exh_name "
			+ " FROM t_event_exh_mapping,m_events,m_exhibitor"
			+ " WHERE t_event_exh_mapping.exh_id=:exhbId  AND m_events.event_id=t_event_exh_mapping.event_id  " + 
			" AND t_event_exh_mapping.exh_id=m_exhibitor.exh_id AND m_events.is_used=1 "
			+ " GROUP BY t_event_exh_mapping.event_id", nativeQuery = true)
	
	List<GetAllEventForExhb> getAllEventsbyExhb(@Param("exhbId") int exhbId);

	

}
