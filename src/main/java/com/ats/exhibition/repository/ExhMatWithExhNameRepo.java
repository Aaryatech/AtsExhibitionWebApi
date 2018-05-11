package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ExhMatWithExhName;

public interface ExhMatWithExhNameRepo extends JpaRepository<ExhMatWithExhName, Integer> {
	
	
	@Query(value = "SELECT e.*, x.exh_name FROM m_exh_material e,m_exhibitor x WHERE e.tr_id=:trId AND x.exh_id=e.exh_id AND e.is_used=1", nativeQuery = true)
	ExhMatWithExhName getAllMaterialByTrId(@Param("trId") int trId);

}
