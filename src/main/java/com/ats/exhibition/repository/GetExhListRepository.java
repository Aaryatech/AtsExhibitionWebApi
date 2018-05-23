package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.exhibition.model.GetExhibitorsList;

public interface GetExhListRepository extends JpaRepository<GetExhibitorsList, Integer> {

	@Query(value = "SELECT m_exhibitor.exh_name,m_events.event_name, coalesce((Select t_visitor_exhibitor.like_status "
			+ "From t_visitor_exhibitor where m_exhibitor.exh_id=t_visitor_exhibitor.exhibitor_id AND "
			+ "t_visitor_exhibitor.visitor_id=:visitorId),0) AS likeSTATUS FROM m_exhibitor,m_events,`t_event_exh_mapping`"
			+ " WHERE m_exhibitor.exh_id=t_event_exh_mapping.exh_id and m_events.event_id=t_event_exh_mapping.event_id and"
			+ " t_event_exh_mapping.event_id=:eventId", nativeQuery = true)
	List<GetExhibitorsList> getAllExhListByEventIdAndVisitorId(@Param("eventId") int eventId,@Param("visitorId") int visitorId);
	

}
