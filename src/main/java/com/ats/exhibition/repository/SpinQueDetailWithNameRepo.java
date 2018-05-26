package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.exhibition.model.SpinQueDetailWithName;

public interface SpinQueDetailWithNameRepo extends JpaRepository<SpinQueDetailWithName, Integer> {

	@Query(value = "SELECT s.*,x.exh_name,v.visitor_name FROM t_spin_que s,m_exhibitor x,m_visitor v WHERE s.exh_id=x.exh_id AND s.visitor_id=v.visitor_id  AND\r\n"
			+ "s.is_used=1", nativeQuery = true)
	List<SpinQueDetailWithName> findByIsUsed();

}
