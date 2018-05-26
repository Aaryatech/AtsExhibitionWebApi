package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.SpinQueDetail;

public interface SpinQueDetailRepo extends JpaRepository<SpinQueDetail, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE SpinQueDetail SET isUsed=0  WHERE t_que_id=:tQueId")
	int deleteSpinQueDetail(@Param("tQueId") int tQueId);
	

}
