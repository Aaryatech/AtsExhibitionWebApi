package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.exhibition.model.EventWithOrgName;

public interface EventWithOrgNameRepository extends JpaRepository<EventWithOrgName, Integer> {

	@Query(value = "SELECT c.*, o.org_name FROM t_events c,m_organiser o WHERE c.org_id=1 AND o.org_id=c.org_id", nativeQuery = true)
	List<EventWithOrgName> getAllEventsByEventId(@Param("eventId") int eventId);

}
