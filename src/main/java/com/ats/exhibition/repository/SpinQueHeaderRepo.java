package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.SpinQuestionHeader;

public interface SpinQueHeaderRepo extends JpaRepository<SpinQuestionHeader, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE SpinQuestionHeader SET isUsed=0  WHERE que_id=:queId")
	int deleteSpinQueHeader(@Param("queId") int queId);
	

}
