package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.ExhMaterial;

public interface ExhMaterialRepository extends JpaRepository<ExhMaterial, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE ExhMaterial SET isUsed=0  WHERE tr_id=:trId")
	int deleteMaterial(@Param("trId") int trId);

}
