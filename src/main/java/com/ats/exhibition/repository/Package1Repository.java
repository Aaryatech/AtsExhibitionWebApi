package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Package1;

public interface Package1Repository extends JpaRepository<Package1, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Package1 SET isUsed=0  WHERE pkg_id=:pkgId")
	int deletePackage(@Param("pkgId") int pkgId);

	List<Package1> findByIsUsed(int i);

}
