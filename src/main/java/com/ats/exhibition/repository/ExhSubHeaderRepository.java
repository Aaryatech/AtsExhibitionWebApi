package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.ExhSubHeader;
import com.ats.exhibition.model.ExhSubHeaderWithExhName;

public interface ExhSubHeaderRepository extends JpaRepository<ExhSubHeader,Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE ExhSubHeader SET isUsed=0  WHERE sub_id=:subId")
	int deleteExhSubHeader(@Param("subId") int subId);
	
	@Query(value = "SELECT * FROM t_exh_sub_header  WHERE t_exh_sub_header.exh_id=:exhId AND  from_date <:toDay  and to_date>:toDay  AND t_exh_sub_header.is_used=1 ORDER BY from_date ", nativeQuery = true)
	List<ExhSubHeader> getAllSubHeaderBetweenDates(@Param("exhId") int exhId,@Param("toDay") String toDay);

	
	ExhSubHeader findByExhId(int exhId);

}
