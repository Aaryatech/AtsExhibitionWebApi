package com.ats.exhibition.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.EventProductsInterest;

public interface EventProductsInterestRepository extends JpaRepository<EventProductsInterest, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE EventProductsInterest SET isUsed=0  WHERE tr_id=:trId")
	int deleteEventProductsInterest(@Param("trId") int trId);

}
