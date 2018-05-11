package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.exhibition.model.EventExhMapping;

public interface EventExhMappingRepository  extends JpaRepository <EventExhMapping, Integer> {

}
