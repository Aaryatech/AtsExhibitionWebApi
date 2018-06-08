package com.ats.exhibition.repository.emptaskenq;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.exhibition.model.emptaskenq.GetEmpEnquiry;

public interface GetEmpEnquiryRepo extends JpaRepository<GetEmpEnquiry, Integer> {
	
	@Query(value = " SELECT m_enquiry_header.enq_id,m_enquiry_header.emp_id,m_visitor.visitor_name,m_visitor.visitor_email,m_visitor.visitor_mobile,m_events.event_name,m_exh_employee.emp_name," + 
			" DATE_FORMAT(m_enquiry_header.approximate_time,'%r') AS approximate_time,m_enquiry_header.status,m_enquiry_header.next_meet_date FROM m_enquiry_header,m_visitor,m_events,m_exh_employee " + 
			" WHERE m_enquiry_header.emp_id=:empId AND m_enquiry_header.is_used=1 AND m_enquiry_header.emp_id=m_exh_employee.emp_id AND " + 
			" m_enquiry_header.visitor_id=m_visitor.visitor_id AND m_enquiry_header.event_id=m_events.event_id " + 
			" AND m_enquiry_header.next_meet_date BETWEEN :fromDate AND :toDate ORDER BY m_enquiry_header.next_meet_date,  m_enquiry_header.emp_id ", nativeQuery = true)
	List<GetEmpEnquiry> getEmpEnquiry(@Param("empId") int empId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
	
	@Query(value = " SELECT m_enquiry_header.enq_id,m_enquiry_header.emp_id,m_visitor.visitor_name,m_visitor.visitor_email,m_visitor.visitor_mobile,m_events.event_name,m_exh_employee.emp_name," + 
			" DATE_FORMAT(m_enquiry_header.approximate_time,'%r') AS approximate_time,m_enquiry_header.status,m_enquiry_header.next_meet_date FROM m_enquiry_header,m_visitor,m_events,m_exh_employee " + 
			" WHERE m_enquiry_header.exh_id=:exhbId AND m_enquiry_header.is_used=1 AND m_enquiry_header.emp_id=m_exh_employee.emp_id AND " + 
			" m_enquiry_header.visitor_id=m_visitor.visitor_id AND m_enquiry_header.event_id=m_events.event_id " + 
			" AND m_enquiry_header.next_meet_date BETWEEN :fromDate AND :toDate ORDER BY m_enquiry_header.next_meet_date, m_enquiry_header.emp_id", nativeQuery = true)
	List<GetEmpEnquiry> getEmpEnquiryAllEmp(@Param("exhbId") int exhbId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
}
