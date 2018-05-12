package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.exhibition.model.EventExhMapping;

public interface EventExhMappingRepository  extends JpaRepository <EventExhMapping, Integer> {

	List<EventExhMapping> findByEventIdAndIsUsed(int eventId, int isUsed);

}
