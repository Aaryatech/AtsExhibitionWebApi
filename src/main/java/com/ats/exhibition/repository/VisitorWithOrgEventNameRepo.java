package com.ats.exhibition.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.exhibition.model.VisitorWithOrgEventName;



public interface VisitorWithOrgEventNameRepo extends JpaRepository<VisitorWithOrgEventName, Integer> {

	@Query(value = "SELECT v.*, e.event_name, o.org_name FROM m_visitor v,m_organiser o,m_events e WHERE v.visitor_id=:visitorId"
			+ " AND v.org_id=o.org_id AND v.event_id=e.event_id AND e.is_used=1", nativeQuery = true)
	VisitorWithOrgEventName getVisitorByVisitorId(@Param("visitorId") int visitorId);
	
	@Query(value = "SELECT v.*, e.event_name, o.org_name FROM m_visitor v,m_organiser o,m_events e WHERE v.visitor_name=:visitorName"
			+ " AND v.org_id=o.org_id AND v.event_id=e.event_id AND e.is_used=1", nativeQuery = true)
	VisitorWithOrgEventName getVisitorByVisitorName(@Param("visitorName") String visitorName);
	
	
	@Query(value = "SELECT v.*, e.event_name, o.org_name FROM m_visitor v,m_organiser o,m_events e WHERE v.visitor_mobile=:visitorMobile"
			+ " AND v.org_id=o.org_id AND v.event_id=e.event_id AND e.is_used=1", nativeQuery = true)
	VisitorWithOrgEventName getVisitorByVisitorMobile(@Param("visitorMobile") String visitorMobile);
	
	@Query(value = "SELECT v.*, e.event_name, o.org_name FROM m_visitor v,m_organiser o,m_events e WHERE v.org_id=o.org_id "
			+ "AND v.event_id=e.event_id AND v.is_used=1", nativeQuery = true)
	List<VisitorWithOrgEventName> getAllVisitorsByIsUsed();

	@Query(value = "SELECT\r\n" + 
			"        v.*,\r\n" + 
			"        e.event_name,\r\n" + 
			"        o.org_name \r\n" + 
			"    FROM\r\n" + 
			"        m_visitor v,\r\n" + 
			"        m_organiser o,\r\n" + 
			"        m_events e \r\n" + 
			"    WHERE\r\n" + 
			"        v.org_id=o.org_id \r\n" + 
			"        AND v.event_id=e.event_id \r\n" + 
			"        AND v.is_used=1\r\n" + 
			"        and v.org_id = :orgId", nativeQuery = true)
	List<VisitorWithOrgEventName> getAllVisitorsByOrgId(@Param("orgId") int orgId);
	
	@Query(value = "SELECT v.*, e.event_name, o.org_name FROM m_visitor v,m_organiser o,m_events e WHERE v.visitor_name=:visitorName"
			+ " AND v.org_id=o.org_id AND v.event_id=e.event_id AND e.is_used=1", nativeQuery = true)
	List<VisitorWithOrgEventName> getVsisitorListByVisitorName(@Param("visitorName") String visitorName);

}
