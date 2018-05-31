	package com.ats.exhibition.repository.eventhistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.eventhistory.EventsWithSubStatus;

public interface EventsWithSubStatusRepo extends JpaRepository<EventsWithSubStatus, Integer> {
	
	@Query(value = "\r\n" + "select m_events.* ,coalesce((SELECT 1 FROM m_events e WHERE EXISTS(SELECT m.event_id FROM"
			+ " t_event_exh_mapping m WHERE m.event_id = e.event_id and exh_id=:exhId and e.event_id=m_events.event_id)),0)"
			+ "as sub_status from m_events where m_events.is_used=1 and :toDay >=  m_events.event_from_date AND  "
			+ " :toDay <= m_events.event_to_date\r\n" + "", nativeQuery = true)
	List<EventsWithSubStatus> getAllEventsWithExhId(@Param("exhId") int exhId, @Param("toDay") String toDay);
	

}
