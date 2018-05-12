package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ExhSubHeaderWithExhName;

public interface ExhSubHeaderWithExhNameRepo extends JpaRepository<ExhSubHeaderWithExhName, Integer> {

	@Query(value = "SELECT c.*, x.exh_name FROM t_exh_sub_header c,m_exhibitor x WHERE c.sub_id=:subId AND x.exh_id=c.exh_id AND c.is_used=1", nativeQuery = true)
	ExhSubHeaderWithExhName getSubHeaderBySubIdAndIsUsed(@Param("subId") int subId);

}
