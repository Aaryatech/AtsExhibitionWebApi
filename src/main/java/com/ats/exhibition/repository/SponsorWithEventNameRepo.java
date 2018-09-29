package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.SponsorWithEventName;

public interface SponsorWithEventNameRepo extends JpaRepository<SponsorWithEventName, Integer> {

	@Query(value = "SELECT s.*, e.event_name ,c.company_type_name FROM m_sponsor s,m_events e,m_company c WHERE s.event_id=:eventId AND e.event_id=s.event_id \r\n"
			+ "AND c.company_type_id=s.company_id AND s.is_used=1", nativeQuery = true)
	List<SponsorWithEventName> getAllSponsorByEventId(@Param("eventId") int eventId);

}
