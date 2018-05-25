package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.SortedVisitor;

public interface SortedVisitorRepository extends JpaRepository<SortedVisitor, Integer>{

	@Query(value="select  \r\n" + 
			"        ve.*,\r\n" + 
			"        e.event_name,\r\n" + 
			"        v.visitor_name,\r\n" + 
			"        v.visitor_email,\r\n" + 
			"        v.visitor_mobile,\r\n" + 
			"        l.location_name,\r\n" + 
			"        l.location_id,\r\n" + 
			"        c.company_type_name,\r\n" + 
			"        c.company_type_id            \r\n" + 
			"    from\r\n" + 
			"        t_visitor_event ve,\r\n" + 
			"        m_visitor v,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c,\r\n" + 
			"        m_events e\r\n" + 
			"    where\r\n" + 
			"        ve.event_id  in (:eventId)              \r\n" + 
			"        and v.visitor_id = ve.visitor_id                 \r\n" + 
			"        and l.location_id = v.location_id                 \r\n" + 
			"        and c.company_type_id = v.company_type_id\r\n" + 
			"        and e.event_id = ve.event_id\r\n" + 
			"    ORDER BY\r\n" + 
			"        v.location_id,\r\n" + 
			"        v.company_type_id,\r\n" + 
			"        v.visitor_name"
			+ " limit 2 " + 
			"    offset :next",nativeQuery=true)
	List<SortedVisitor> sortedVisitorByLocationAndCompanyType(@Param("eventId") List<Integer> eventId,@Param("next") int next);

	@Query(value="select\r\n" + 
			"        ve.*,\r\n" + 
			"        e.event_name,\r\n" + 
			"        v.visitor_name,\r\n" + 
			"        v.visitor_email,\r\n" + 
			"        v.visitor_mobile, \r\n" + 
			"        l.location_name,\r\n" + 
			"        l.location_id,\r\n" + 
			"        c.company_type_name,\r\n" + 
			"        c.company_type_id            \r\n" + 
			"    from\r\n" + 
			"        t_visitor_event ve,\r\n" + 
			"        m_visitor v,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c,\r\n" + 
			"        m_events e\r\n" + 
			"    where\r\n" + 
			"        ve.event_id  in (:eventId)              \r\n" + 
			"        and v.visitor_id = ve.visitor_id                 \r\n" + 
			"        and l.location_id = v.location_id          \r\n" + 
			"        and v.company_type_id in (:companyType)          \r\n" + 
			"        and c.company_type_id = v.company_type_id\r\n" + 
			"        and e.event_id = ve.event_id\r\n" + 
			"    ORDER BY\r\n" + 
			"        v.location_id,\r\n" + 
			"        v.company_type_id,\r\n" + 
			"        v.visitor_name "
			+ "limit 2\r\n" + 
			"    offset :next",nativeQuery=true)
	List<SortedVisitor> sortedVisitorByAllLocation(@Param("eventId")List<Integer> eventId,@Param("companyType") List<Integer> companyType,@Param("next") int next);

	@Query(value="select\r\n" + 
			"        ve.*,\r\n" + 
			"        e.event_name,\r\n" + 
			"        v.visitor_name,\r\n" + 
			"        v.visitor_email,\r\n" + 
			"        v.visitor_mobile, \r\n" + 
			"        l.location_name,\r\n" + 
			"        l.location_id,\r\n" + 
			"        c.company_type_name,\r\n" + 
			"        c.company_type_id            \r\n" + 
			"    from\r\n" + 
			"        t_visitor_event ve,\r\n" + 
			"        m_visitor v,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c,\r\n" + 
			"        m_events e\r\n" + 
			"    where\r\n" + 
			"        ve.event_id  in (:eventId)              \r\n" + 
			"        and v.visitor_id = ve.visitor_id                 \r\n" + 
			"        and l.location_id = v.location_id          \r\n" + 
			"        and v.location_id in ( :locationId)          \r\n" + 
			"        and c.company_type_id = v.company_type_id\r\n" + 
			"        and e.event_id = ve.event_id \r\n" + 
			"    ORDER BY\r\n" + 
			"       v.location_id,\r\n" + 
			"        v.company_type_id,\r\n" + 
			"        v.visitor_name "
			+ "limit 2\r\n" + 
			"    offset :next",nativeQuery=true)
	List<SortedVisitor> sortedVisitorByAllCompanyType(@Param("eventId")List<Integer> eventId,@Param("locationId") List<Integer> locationId,@Param("next") int next);

	@Query(value="select\r\n" + 
			"        ve.*,\r\n" + 
			"        e.event_name,\r\n" + 
			"        v.visitor_name,\r\n" + 
			"        v.visitor_email,\r\n" + 
			"        v.visitor_mobile, \r\n" + 
			"        l.location_name,\r\n" + 
			"        l.location_id,\r\n" + 
			"        c.company_type_name,\r\n" + 
			"        c.company_type_id            \r\n" + 
			"    from\r\n" + 
			"        t_visitor_event ve,\r\n" + 
			"        m_visitor v,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c,\r\n" + 
			"        m_events e\r\n" + 
			"    where\r\n" + 
			"        ve.event_id  in (:eventId)             \r\n" + 
			"        and v.visitor_id = ve.visitor_id                 \r\n" + 
			"        and l.location_id = v.location_id \r\n" + 
			"        and v.location_id in (:locationId) " + 
			"        and v.company_type_id in (:companyType)          \r\n" + 
			"        and c.company_type_id = v.company_type_id\r\n" + 
			"        and e.event_id = ve.event_id\r\n" + 
			"    ORDER BY\r\n" + 
			"        v.location_id,\r\n" + 
			"        v.company_type_id,\r\n" + 
			"        v.visitor_name "
			+ "limit 2\r\n" + 
			"    offset :next",nativeQuery=true)
	List<SortedVisitor> sortedVisitorByLocationAndCompanyType(@Param("eventId")List<Integer> eventId,@Param("companyType") List<Integer> companyType,
			@Param("locationId")List<Integer> locationId,@Param("next") int next);

}
