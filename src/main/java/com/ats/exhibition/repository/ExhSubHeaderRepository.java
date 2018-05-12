package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.ExhSubHeader;

public interface ExhSubHeaderRepository extends JpaRepository<ExhSubHeader,Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE ExhSubHeader SET isUsed=0  WHERE sub_id=:subId")
	int deleteExhSubHeader(@Param("subId") int subId);


}
