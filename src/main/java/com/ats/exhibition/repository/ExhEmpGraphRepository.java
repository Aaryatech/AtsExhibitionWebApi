package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.exhibition.model.ExhEmpGraph;

public interface ExhEmpGraphRepository extends JpaRepository<ExhEmpGraph, Integer> {

	@Query(value = "Select h.enq_id,e.emp_id,e.emp_name,\r\n"
			+ "coalesce((Select COUNT(*) From m_enquiry_header  where m_enquiry_header.is_used=1 and m_enquiry_header.emp_id=e.emp_id and m_enquiry_header.date between :fromDate AND :toDate ),0) As no_of_enq,\r\n"
			+ "\r\n"
			+ "coalesce((Select COUNT(*) From m_enquiry_header  where m_enquiry_header.is_used=1 and m_enquiry_header.status=1 and m_enquiry_header.emp_id=e.emp_id and m_enquiry_header.next_meet_date between :fromDate AND :toDate),0) AS pending,\r\n"
			+ "\r\n"
			+ "coalesce((Select COUNT(*) From m_enquiry_header  where m_enquiry_header.is_used=1 and m_enquiry_header.status=2 and m_enquiry_header.emp_id=e.emp_id and m_enquiry_header.next_meet_date between :fromDate AND :toDate),0) AS processing,\r\n"
			+ "\r\n"
			+ "coalesce((Select COUNT(*) From m_enquiry_header  where m_enquiry_header.is_used=1 and m_enquiry_header.status=4 and m_enquiry_header.emp_id=e.emp_id and m_enquiry_header.next_meet_date between :fromDate AND :toDate),0) AS closed,\r\n"
			+ "\r\n"
			+ "coalesce((Select COUNT(*) From m_enquiry_header  where m_enquiry_header.is_used=1 and m_enquiry_header.status=5 and m_enquiry_header.emp_id=e.emp_id and m_enquiry_header.next_meet_date between :fromDate AND :toDate),0) AS completed\r\n"
			+ "\r\n" + "\r\n"
			+ "from m_exh_employee e,m_enquiry_header h where h.exh_id=:exhId and e.emp_id=h.emp_id group by e.emp_id", nativeQuery = true)
	List<ExhEmpGraph> getInfo(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("exhId") int exhId);

}
