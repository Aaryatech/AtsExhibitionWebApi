package com.ats.exhibition.repository.eventhistory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.eventhistory.GetEventHistory;

public interface GetEventHistoryRepo extends JpaRepository<GetEventHistory, Integer> {
	
			@Query(value=" 	SELECT m_events.event_id, m_events.event_name,m_events.event_location,m_events.event_from_date,m_events.event_to_date,"
					+ " m_exhibitor.exh_name,COALESCE((SELECT COUNT(t_visitor_exhibitor.like_status)"
					+ " FROM t_visitor_exhibitor WHERE m_events.event_id=t_visitor_exhibitor.event_id AND "
					+ " t_visitor_exhibitor.exhibitor_id=m_exhibitor.exh_id AND t_visitor_exhibitor.exhibitor_id=:exhbId "
					+ " GROUP BY t_visitor_exhibitor.event_id ),0)as like_count FROM m_exhibitor,m_events,t_event_exh_mapping "
					+ " WHERE m_exhibitor.exh_id=t_event_exh_mapping.exh_id AND m_events.event_id=t_event_exh_mapping.event_id "
					+ " AND t_event_exh_mapping.exh_id=:exhbId " + 
					" ",nativeQuery=true)
			
			List<GetEventHistory> getEventHistory(@Param("exhbId")int exhbId);
			
}
