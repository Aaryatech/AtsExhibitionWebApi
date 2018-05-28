package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.SpinQueDetail;

public interface SpinQueDetailRepository extends JpaRepository<SpinQueDetail, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE SpinQueDetail SET isUsed=0  WHERE t_que_detail_id=:tQueDetailId")
	int deleteSpinQueDetail(@Param("tQueDetailId") int tQueDetailId);

}
