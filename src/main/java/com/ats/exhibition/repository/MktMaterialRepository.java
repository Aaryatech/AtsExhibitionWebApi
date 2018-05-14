package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.MktMaterial;

public interface MktMaterialRepository  extends JpaRepository<MktMaterial, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE MktMaterial SET isUsed=0  WHERE mat_id=:matId")
	int deleteMktMaterial(@Param("matId") int matId);

}
