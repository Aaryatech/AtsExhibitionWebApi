package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.EventListByVisId;


public interface EventListByVisIdRepo extends JpaRepository<EventListByVisId, Integer> {
	
	@Query(value = "SELECT e.event_id,e.org_id,o.org_name,e.event_name,e.event_from_date,e.event_to_date,e.from_time,"
			+ "e.to_time,e.event_location,e.event_loc_lat,e.event_loc_long,e.about_event,e.event_logo,e.contact_person_name1,"
			+ "e.contact_person_name2,e.person1_mob,e.person2_mob,e.person1_email_id,e.person2_email_id,e.is_used,e.location_id,"
			+ "l.location_name,e.company_type_id,c.company_type_name from m_events e,t_visitor_event ,m_location l,m_organiser"
			+ " o,m_company c where e.is_used=1 and l.location_id=e.location_id and e.org_id=o.org_id and e.event_id"
			+ " IN(select t_visitor_event.event_id from t_visitor_event where t_visitor_event.visitor_id=:visitorId and "
			+ "t_visitor_event.subscribe_status=1) group by e.event_id	  ", nativeQuery = true)
	List<EventListByVisId> getEventListByVisitorId(@Param("visitorId") int visitorId);

}
