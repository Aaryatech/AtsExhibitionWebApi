package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.EnquiryHeaderWithName;

public interface EnquiryHeaderWithNameRepo extends JpaRepository<EnquiryHeaderWithName, Integer> {

	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e "
			+ ",m_visitor v,m_exhibitor x,m_exh_employee p WHERE q.event_id=:eventId AND q.event_id=e.event_id AND "
			+ "q.visitor_id=v.visitor_id AND x.exh_id=q.exh_id AND p.emp_id=q.emp_id AND q.is_used=1", nativeQuery = true)
	List<EnquiryHeaderWithName> getAllEnquiryByEventId(@Param("eventId") int eventId);

	List<EnquiryHeaderWithName> getAllEnquiryByIsUsed(int i);

	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e "
			+ ",m_visitor v,m_exhibitor x,m_exh_employee p WHERE  q.event_id=e.event_id AND "
			+ "q.visitor_id=v.visitor_id AND x.exh_id=q.exh_id AND p.emp_id=q.emp_id AND q.is_used=1", nativeQuery = true)
	List<EnquiryHeaderWithName> getAllEnquiryByIsUsed();

	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,v.visitor_mobile,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e ,m_visitor v,m_exhibitor x,m_exh_employee p WHERE  q.event_id=e.event_id AND  q.visitor_id=v.visitor_id AND x.exh_id=q.exh_id AND p.emp_id=q.emp_id AND q.is_used=1 AND date  BETWEEN :fromDate  AND :toDate ", nativeQuery = true)
	List<EnquiryHeaderWithName> getAllEnquiryBetweenDates(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,v.visitor_mobile,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e ,m_visitor v,m_exhibitor x,m_exh_employee p WHERE  q.event_id=e.event_id AND  q.visitor_id=v.visitor_id AND x.exh_id=q.exh_id AND p.emp_id=q.emp_id AND q.is_used=1 AND enq_id=:enqId", nativeQuery = true)
	EnquiryHeaderWithName getEnquiryByEnqId(@Param("enqId") int enqId);
	/*
	 * @Query(value = "SELECT * FROM m_enquiry_header WHERE is_used=1", nativeQuery
	 * = true) List<EnquiryHeaderWithName> getAllEnquiryByIsUsed();
	 */
}
