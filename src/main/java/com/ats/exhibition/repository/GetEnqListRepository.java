package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.exhibition.model.GetEnqList;

public interface GetEnqListRepository extends JpaRepository<GetEnqList, Integer>{
	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,v.visitor_mobile,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e ,m_visitor v,m_exhibitor x,m_exh_employee p WHERE  q.event_id=e.event_id AND  q.visitor_id=v.visitor_id AND x.exh_id=q.exh_id AND p.emp_id=q.emp_id AND q.is_used=1 AND q.emp_id=:empId AND q.exh_id=:exhId AND date=:date ", nativeQuery = true)
	List<GetEnqList> getEnquiryList(@Param("empId") int empId,@Param("exhId") int exhId,@Param("date") String date);

}
