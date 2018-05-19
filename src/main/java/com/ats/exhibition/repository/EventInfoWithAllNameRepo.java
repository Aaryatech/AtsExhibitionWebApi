package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.EventInfoWithAllName;

public interface EventInfoWithAllNameRepo extends JpaRepository<EventInfoWithAllName, Integer> {

	@Query(value = "SELECT c.*, o.org_name,l.location_name, p.company_type_name FROM m_events c,m_organiser o,m_company p,m_location l \r\n"
			+ "WHERE c.event_id=:eventId AND o.org_id=c.org_id AND p.company_type_id=c.company_type_id AND l.location_id=c.location_id AND c.is_used", nativeQuery = true)
	EventInfoWithAllName getAllEventsInfoByEventId(@Param("eventId") int eventId);

}
