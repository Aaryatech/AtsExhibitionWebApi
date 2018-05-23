package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.EventWithOrgName;

public interface EventWithOrgNameRepository extends JpaRepository<EventWithOrgName, Integer> {

	@Query(value = "SELECT c.*, o.org_name FROM m_events c,m_organiser o WHERE c.event_id=:eventId AND o.org_id=c.org_id", nativeQuery = true)
	EventWithOrgName getAllEventsByEventId(@Param("eventId") int eventId);

	@Query(value = "SELECT c.*, o.org_name FROM m_events c,m_organiser o WHERE c.is_used=1 AND o.org_id=c.org_id and o.is_used=1", nativeQuery = true)
	List<EventWithOrgName> getAllEventsByIsUsed();

	@Query(value = "SELECT c.*, o.org_name FROM m_events c,m_organiser o WHERE c.org_id=:orgId AND o.org_id=c.org_id AND  c.is_used=:isUsed ", nativeQuery = true)
	List<EventWithOrgName> getAllEventsByOrgIdAndIsUsed(@Param("orgId") int orgId, @Param("isUsed") int isUsed);

	@Query(value = "SELECT c.*, o.org_name FROM m_events c,m_organiser o WHERE c.event_from_date BETWEEN :fromDate AND :toDate  AND o.org_id=c.org_id AND  c.is_used=1", nativeQuery = true)
	List<EventWithOrgName> getEventssBetweenDates(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT\r\n" + 
			"        c.*,\r\n" + 
			"        o.org_name \r\n" + 
			"    FROM\r\n" + 
			"        m_events c,\r\n" + 
			"        m_organiser o \r\n" + 
			"    WHERE\r\n" + 
			"        c.org_id in (:orgList)\r\n" + 
			"        AND o.org_id=c.org_id \r\n" + 
			"        AND  c.is_used=1", nativeQuery = true)
	 List<EventWithOrgName> eventListByMultipleOrgId(@Param("orgList") List<Integer> orgList);

}
