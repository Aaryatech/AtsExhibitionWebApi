package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ExhEmpWithExhName;

public interface ExhEmpWithExhNameRepo extends JpaRepository<ExhEmpWithExhName, Integer> {

	@Query(value = "SELECT e.*, x.exh_name FROM m_exh_employee e,m_exhibitor x WHERE e.emp_id=:empId AND x.exh_id=e.exh_id AND e.is_used=1", nativeQuery = true)
	ExhEmpWithExhName getAllEmployeeByEmpId(@Param("empId") int empId);
}
