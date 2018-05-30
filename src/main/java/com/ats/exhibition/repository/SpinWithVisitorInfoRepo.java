package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.SpinWithVisitorInfo;

public interface SpinWithVisitorInfoRepo extends JpaRepository<SpinWithVisitorInfo, Integer> {

	@Query(value = "SELECT s.*,x.exh_name,v.visitor_name,v.visitor_mobile,v.visitor_email, e.emp_name FROM  t_spin_que s,m_exhibitor x,m_visitor v,m_exh_employee e WHERE s.exh_id=x.exh_id AND s.visitor_id=v.visitor_id AND e.emp_id=s.emp_id  AND s.is_used=1 AND date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	List<SpinWithVisitorInfo> getSpinQueWithVisitorInfoBetDates(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT s.*,x.exh_name,v.visitor_name,v.visitor_mobile,v.visitor_email, e.emp_name FROM  t_spin_que s,m_exhibitor x,m_visitor v,m_exh_employee e WHERE s.exh_id=x.exh_id AND s.visitor_id=v.visitor_id AND e.emp_id=s.emp_id  AND s.is_used=1 AND t_que_id=1", nativeQuery = true)
	SpinWithVisitorInfo getVisitorInfoByTQueId(@Param("tQueId") int tQueId);

}
