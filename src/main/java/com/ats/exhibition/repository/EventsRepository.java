package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Events;

public interface EventsRepository extends JpaRepository<Events, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Events SET isUsed=0  WHERE event_id=:eventId")
	int deleteEvent(@Param("eventId") int eventId);

	Events findByEventId(int eventId);

}
