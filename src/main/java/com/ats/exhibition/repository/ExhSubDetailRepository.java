package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.ExhSubDetail;

public interface ExhSubDetailRepository extends JpaRepository<ExhSubDetail, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE ExhSubDetail SET isUsed=0  WHERE sub_detail_id=:subDetailId")
	int deleteExhSubDetail(@Param("subDetailId") int subDetailId);

}
