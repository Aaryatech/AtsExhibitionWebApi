package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.EventPhotoWithEventName;

public interface EventPhotoWithEventNameRepo extends JpaRepository<EventPhotoWithEventName, Integer> {
	
	@Query(value = "SELECT c.*, e.event_name FROM t_event_photo c,m_events e WHERE c.photo_id=:photoId AND e.event_id=c.event_id AND c.is_used=1", nativeQuery = true)
	EventPhotoWithEventName getAllEvnetsByPhotoId(@Param("photoId") int photoId);
	
	@Query(value = "SELECT c.*, e.event_name FROM t_event_photo c,m_events e WHERE  e.event_id=c.event_id AND c.is_used=1", nativeQuery = true)
	List<EventPhotoWithEventName> getAllPhotoAndEventByIsUsed();


}
