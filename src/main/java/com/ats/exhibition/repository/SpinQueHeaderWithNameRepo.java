package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.exhibition.model.SpinQueHeaderWithName;

public interface SpinQueHeaderWithNameRepo extends JpaRepository<SpinQueHeaderWithName, Integer> {

	@Query(value = "SELECT s.*,x.exh_name,v.visitor_name, e.emp_name FROM t_spin_que s,m_exhibitor x,m_visitor v,m_exh_employee e WHERE s.exh_id=x.exh_id AND s.visitor_id=v.visitor_id AND e.emp_id=s.emp_id  AND s.is_used=1", nativeQuery = true)

	List<SpinQueHeaderWithName> findByIsUsed();

}
