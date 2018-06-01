package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.EnquiryHeaderWithName;

public interface EnquiryHeaderWithNameRepo extends JpaRepository<EnquiryHeaderWithName, Integer> {

	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,v.visitor_mobile,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e "
			+ ",m_visitor v,m_exhibitor x,m_exh_employee p WHERE q.event_id=:eventId AND q.event_id=e.event_id AND "
			+ "q.visitor_id=v.visitor_id AND x.exh_id=q.exh_id AND p.emp_id=q.emp_id AND q.is_used=1", nativeQuery = true)
	List<EnquiryHeaderWithName> getAllEnquiryByEventId(@Param("eventId") int eventId);

	List<EnquiryHeaderWithName> getAllEnquiryByIsUsed(int i);

	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,v.visitor_mobile,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e ,m_visitor v,m_exhibitor x,m_exh_employee p WHERE  q.event_id=e.event_id AND  q.visitor_id=v.visitor_id AND x.exh_id=q.exh_id AND p.emp_id=q.emp_id AND q.is_used=1 AND date  BETWEEN :fromDate  AND :toDate AND q.emp_id=:empId AND q.exh_id=:exhId ", nativeQuery = true)
	List<EnquiryHeaderWithName> getAllEnquiryBetDatesAndByEmpIdAndExhId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("empId") int empId, @Param("exhId") int exhId);
	
	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,v.visitor_mobile,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e ,m_visitor v,m_exhibitor x,m_exh_employee p WHERE  q.event_id=e.event_id AND  q.visitor_id=v.visitor_id AND x.exh_id=q.exh_id AND p.emp_id=q.emp_id AND q.is_used=1 AND date  BETWEEN :fromDate  AND :toDate AND  q.exh_id=:exhId ", nativeQuery = true)
	List<EnquiryHeaderWithName> getAllEnquiryBetweenDatesAndByExhId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,  @Param("exhId") int exhId);

	@Query(value = "SELECT q.*, e.event_name,v.visitor_name,v.visitor_mobile,x.exh_name,p.emp_name FROM m_enquiry_header q ,m_events e "
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

	@Query(value = "select \r\n" + "    eq.*,\r\n" + "    v.visitor_name,\r\n" + "    e.event_name,\r\n"
			+ "    ex.exh_name,\r\n" + "    p.emp_name,v.visitor_mobile\r\n" + "    from\r\n"
			+ "    m_enquiry_header eq,\r\n" + "    m_visitor v,\r\n" + "    m_exhibitor ex,\r\n"
			+ "    m_events e,\r\n" + "    m_exh_employee p\r\n" + "    where \r\n" + "    eq.exh_id=:exhId \r\n"
			+ "    and eq.date between :fromDate and :toDate\r\n" + "    and v.visitor_id = eq.visitor_id \r\n"
			+ "    and eq.event_id=e.event_id \r\n" + "    AND ex.exh_id=eq.exh_id \r\n"
			+ "    AND p.emp_id=eq.emp_id AND eq.is_used=1\r\n" + "", nativeQuery = true)
	List<EnquiryHeaderWithName> enquiryBetweenDateByExhibitorId(@Param("exhId") int exhId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "select eq.*, v.visitor_name, e.event_name, ex.exh_name, p.emp_name,v.visitor_mobile from m_enquiry_header eq, m_visitor v, m_exhibitor ex, m_events e, "
			+ " m_exh_employee p where eq.exh_id=:exhId and eq.date not between :fromDate and :toDate and eq.next_meet_date between :fromDate and :toDate "
			+ "and v.visitor_id = eq.visitor_id and eq.event_id=e.event_id AND ex.exh_id=eq.exh_id AND p.emp_id=eq.emp_id AND eq.is_used=1 "
			+ "and status = :status", nativeQuery = true)
	List<EnquiryHeaderWithName> enquiryNotBetweenDateWithStatus(@Param("exhId") int exhId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") int status);

	@Query(value = "select\r\n" + "        eq.*,\r\n" + "        v.visitor_name,\r\n" + "        e.event_name,\r\n"
			+ "        ex.exh_name,\r\n" + "        p.emp_name,\r\n" + "        v.visitor_mobile \r\n" + "    from\r\n"
			+ "        m_enquiry_header eq,\r\n" + "        m_visitor v,\r\n" + "        m_exhibitor ex,\r\n"
			+ "        m_events e,\r\n" + "        m_exh_employee p \r\n" + "    where\r\n"
			+ "        eq.exh_id=:exhId \r\n" + "        and v.visitor_id = eq.visitor_id \r\n"
			+ "        and eq.event_id=e.event_id \r\n" + "        AND ex.exh_id=eq.exh_id \r\n"
			+ "        AND p.emp_id=eq.emp_id \r\n" + "        AND eq.is_used=1 \r\n"
			+ "        and status = :status", nativeQuery = true)
	List<EnquiryHeaderWithName> equiryListWithStatus(@Param("exhId") int exhId, @Param("status") int status);

}
