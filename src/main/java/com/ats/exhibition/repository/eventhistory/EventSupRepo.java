package com.ats.exhibition.repository.eventhistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.exhibition.model.eventhistory.EventSup;

public interface EventSupRepo extends JpaRepository<EventSup, Integer>{
	
	EventSup save(EventSup eventSup);
	
	List<EventSup> findAllByIsUsed(int isUsed);
	
	EventSup findByEventId(int eventId);
	

}
