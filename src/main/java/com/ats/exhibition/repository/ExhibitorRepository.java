package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Exhibitor;

public interface ExhibitorRepository extends JpaRepository<Exhibitor, Integer>{

	List<Exhibitor> findByIsUsed(int isUsed);
	
	@Transactional
	@Modifying
	@Query("UPDATE Exhibitor SET isUsed=0  WHERE exh_id=:exhId")
	int deleteExhibitors(@Param("exhId") int exhId);

}
