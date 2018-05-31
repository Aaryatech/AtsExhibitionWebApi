package com.ats.exhibition.repository.eventhistory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.exhibition.model.eventhistory.GetEventVisitorName;

public interface GetEventVisitorNameRepo extends JpaRepository<GetEventVisitorName, Integer> {
	
	@Query(value=" SELECT m_visitor.visitor_name,m_visitor.visitor_email,m_visitor.visitor_mobile ,t_visitor_exhibitor.visitor_id, "
			+ " COUNT(t_visitor_exhibitor.like_status) AS like_count "
			+ " FROM m_visitor, t_visitor_exhibitor WHERE " + 
			" m_visitor.event_id=t_visitor_exhibitor.event_id AND m_visitor.visitor_id=t_visitor_exhibitor.visitor_id AND "
			+ " t_visitor_exhibitor.event_id=:eventId GROUP BY t_visitor_exhibitor.visitor_id " + 
			" ",nativeQuery=true)
	
	List<GetEventVisitorName> getEventVisitorNames(@Param("eventId")int eventId);
	
	@Query(value=" SELECT m_visitor.visitor_name,m_visitor.visitor_email,m_visitor.visitor_mobile ,t_visitor_exhibitor.visitor_id, "
			+ " COUNT(t_visitor_exhibitor.like_status) AS like_count "
			+ " FROM m_visitor, t_visitor_exhibitor WHERE " + 
			" m_visitor.event_id=t_visitor_exhibitor.event_id AND m_visitor.visitor_id=t_visitor_exhibitor.visitor_id "
			+ "  GROUP BY t_visitor_exhibitor.visitor_id " + 
			" ",nativeQuery=true)
	
	List<GetEventVisitorName> getEventVisitorNamesAllEvent();
	
}
