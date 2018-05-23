package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.EventPhoto;

public interface EventPhotoRepository extends JpaRepository<EventPhoto, Integer>{
	
	
	@Transactional
	@Modifying
	@Query("UPDATE EventPhoto SET isUsed=0  WHERE photo_id=:photoId")
	int deleteEventPhoto(@Param("photoId") int photoId);
	
	@Query(value="select count(*) as count from t_event_photo where t_event_photo.event_id=:eventId ",nativeQuery=true)
	int getGallaryCount(@Param("eventId")int eventId);


}
