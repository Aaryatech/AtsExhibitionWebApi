package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.ExhEmployee;

public interface ExhEmployeeRepository extends JpaRepository<ExhEmployee, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE ExhEmployee SET isUsed=0  WHERE emp_id=:empId")
	int deleteEmployee(@Param("empId") int empId);

}
