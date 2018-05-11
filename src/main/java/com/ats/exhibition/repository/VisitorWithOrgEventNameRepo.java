package com.ats.exhibition.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.exhibition.model.VisitorWithOrgEventName;

public interface VisitorWithOrgEventNameRepo extends JpaRepository<VisitorWithOrgEventName, Integer> {

	@Query(value = "SELECT v.*, e.event_name, o.org_name FROM m_visitor v,m_organiser o,m_events e WHERE v.visitor_id=:visitorId"
			+ " AND v.org_id=o.org_id AND v.event_id=e.event_id AND e.is_used=1", nativeQuery = true)
	VisitorWithOrgEventName getVisitorByVisitorId(@Param("visitorId") int visitorId);

}
