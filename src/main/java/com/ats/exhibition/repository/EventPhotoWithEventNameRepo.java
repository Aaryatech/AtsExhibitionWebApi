package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.exhibition.model.EventPhotoWithEventName;

public interface EventPhotoWithEventNameRepo extends JpaRepository<EventPhotoWithEventName, Integer> {

}
