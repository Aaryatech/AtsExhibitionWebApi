package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.SpinQueHeader;

public interface SpinQueHeaderRepo extends JpaRepository<SpinQueHeader, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE SpinQueHeader SET isUsed=0  WHERE t_que_id=:tQueId")
	int deleteSpinQueHeader(@Param("tQueId") int tQueId);
	

}
