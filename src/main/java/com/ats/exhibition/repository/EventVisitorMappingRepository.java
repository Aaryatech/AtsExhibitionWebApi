package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.EventVisitorMapping;

public interface EventVisitorMappingRepository extends JpaRepository<EventVisitorMapping, Integer> {

	EventVisitorMapping findByVisitorIdAndEventId(int visitorId, int eventId);
	
	@Transactional
	@Modifying
	@Query("UPDATE EventVisitorMapping SET subscribe_status=:subscribeStatus  WHERE visitor_id=:visitorId AND event_id=:eventId")
	int updateStatus(@Param("visitorId") int visitorId, @Param("eventId") int eventId, @Param("subscribeStatus") int subscribeStatus);


}
