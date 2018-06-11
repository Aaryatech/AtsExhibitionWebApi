package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.SortedExhibitor;

public interface SortedExhibitorRepository extends JpaRepository<SortedExhibitor, Integer>{

	@Query(value="select \r\n" + 
			"    em.*,\r\n" + 
			"    ex.exh_name,\r\n" + 
			"    l.location_name,\r\n" + 
			"    l.location_id,\r\n" + 
			"    c.company_type_name,\r\n" + 
			"    c.company_type_id\r\n" + 
			"    from \r\n" + 
			"        t_event_exh_mapping em,\r\n" + 
			"        m_exhibitor ex,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c\r\n" + 
			"    where \r\n" + 
			"        em.event_id in (:eventId)\r\n" + 
			"    and em.is_used=1\r\n" + 
			"    and ex.exh_id = em.exh_id \r\n" + 
			"    and l.location_id = ex.location_id \r\n" + 
			"    and c.company_type_id = ex.company_type_id"
			+ " ORDER BY ex.exh_name",nativeQuery=true)
	 List<SortedExhibitor> sortedExhibitorByLocationAndCompanyType(@Param("eventId") List<Integer> eventId);

	@Query(value="select \r\n" + 
			"    em.*,\r\n" + 
			"    ex.exh_name,\r\n" + 
			"    l.location_name,\r\n" + 
			"    l.location_id,\r\n" + 
			"    c.company_type_name,\r\n" + 
			"    c.company_type_id\r\n" + 
			"    from \r\n" + 
			"        t_event_exh_mapping em,\r\n" + 
			"        m_exhibitor ex,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c\r\n" + 
			"    where \r\n" + 
			"        em.event_id in (:eventId)\r\n" + 
			"    and em.is_used=1\r\n" + 
			"    and ex.exh_id = em.exh_id \r\n" + 
			"    and l.location_id = ex.location_id\r\n" + 
			"    and c.company_type_id in (:companyType)\r\n" + 
			"    and c.company_type_id = ex.company_type_id ORDER BY ex.exh_name",nativeQuery=true)
	List<SortedExhibitor> sortedExhibitorByAllLocation(@Param("eventId")List<Integer> eventId,@Param("companyType") List<Integer> companyType);

	@Query(value="select \r\n" + 
			"    em.*,\r\n" + 
			"    ex.exh_name,\r\n" + 
			"    l.location_name,\r\n" + 
			"    l.location_id,\r\n" + 
			"    c.company_type_name,\r\n" + 
			"    c.company_type_id\r\n" + 
			"    from \r\n" + 
			"        t_event_exh_mapping em,\r\n" + 
			"        m_exhibitor ex,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c\r\n" + 
			"    where \r\n" + 
			"        em.event_id in (:eventId)\r\n" + 
			"    and em.is_used=1\r\n" + 
			"    and ex.exh_id = em.exh_id\r\n" + 
			"    and ex.location_id in (:locationId)\r\n" + 
			"    and l.location_id = ex.location_id \r\n" + 
			"    and c.company_type_id = ex.company_type_id ORDER BY ex.exh_name",nativeQuery=true)
	List<SortedExhibitor> sortedExhibitorByAllCompanyType(@Param("eventId")List<Integer> eventId,@Param("locationId")List<Integer> locationId);

	@Query(value=" select \r\n" + 
			"    em.*,\r\n" + 
			"    ex.exh_name,\r\n" + 
			"    l.location_name,\r\n" + 
			"    l.location_id,\r\n" + 
			"    c.company_type_name,\r\n" + 
			"    c.company_type_id\r\n" + 
			"    from \r\n" + 
			"        t_event_exh_mapping em,\r\n" + 
			"        m_exhibitor ex,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c\r\n" + 
			"    where \r\n" + 
			"        em.event_id in (:eventId)\r\n" + 
			"    and em.is_used=1\r\n" + 
			"    and ex.exh_id = em.exh_id\r\n" + 
			"    and ex.location_id in (:locationId)\r\n" + 
			"    and l.location_id = ex.location_id\r\n" + 
			"    and c.company_type_id in (:companyType)\r\n" + 
			"    and c.company_type_id = ex.company_type_id ORDER BY ex.exh_name",nativeQuery=true)
	List<SortedExhibitor> sortedExhibitorBy(@Param("eventId")List<Integer> eventId, @Param("locationId") List<Integer> locationId, @Param("companyType") List<Integer> companyType);

	
	@Query(value="select\r\n" + 
			"        em.*,\r\n" + 
			"        ex.exh_name,\r\n" + 
			"        l.location_name,\r\n" + 
			"        l.location_id,\r\n" + 
			"        c.company_type_name,\r\n" + 
			"        c.company_type_id      \r\n" + 
			"    from\r\n" + 
			"        t_event_exh_mapping em,\r\n" + 
			"        m_exhibitor ex,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c ,\r\n" + 
			"        m_events e\r\n" + 
			"    where\r\n" + 
			"        em.event_id  = e.event_id\r\n" + 
			"        and ex.org_id = e.org_id\r\n" + 
			"        and ex.org_id = :orgId\r\n" + 
			"        and em.is_used=1      \r\n" + 
			"        and ex.exh_id = em.exh_id       \r\n" + 
			"        and l.location_id = ex.location_id       \r\n" + 
			"        and c.company_type_id = ex.company_type_id \r\n" + 
			"    ORDER BY\r\n" + 
			"        ex.exh_name",nativeQuery=true)
	List<SortedExhibitor> sortedExhibitorByLocationAndCompanyType(@Param("orgId")int orgId);

	@Query(value="select \r\n" + 
			"    em.*,\r\n" + 
			"    ex.exh_name,\r\n" + 
			"    l.location_name,\r\n" + 
			"    l.location_id,\r\n" + 
			"    c.company_type_name,\r\n" + 
			"    c.company_type_id\r\n" + 
			"    from \r\n" + 
			"        t_event_exh_mapping em,\r\n" + 
			"        m_exhibitor ex,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c,m_events e\r\n" + 
			"    where  em.event_id  = e.event_id\r\n" + 
			"        and ex.org_id = e.org_id\r\n" + 
			"        and ex.org_id = :orgId and em.is_used=1\r\n" + 
			"    and ex.exh_id = em.exh_id \r\n" + 
			"    and l.location_id = ex.location_id\r\n" + 
			"    and c.company_type_id in (:companyType)\r\n" + 
			"    and c.company_type_id = ex.company_type_id ORDER BY ex.exh_name",nativeQuery=true)
	List<SortedExhibitor> sortedExhibitorByAllLocation(@Param("companyType")List<Integer> companyType, @Param("orgId")int orgId);

	@Query(value="select \r\n" + 
			"    em.*,\r\n" + 
			"    ex.exh_name,\r\n" + 
			"    l.location_name,\r\n" + 
			"    l.location_id,\r\n" + 
			"    c.company_type_name,\r\n" + 
			"    c.company_type_id\r\n" + 
			"    from \r\n" + 
			"        t_event_exh_mapping em,\r\n" + 
			"        m_exhibitor ex,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c,m_events e\r\n" + 
			"    where  em.event_id  = e.event_id\r\n" + 
			"        and ex.org_id = e.org_id\r\n" + 
			"        and ex.org_id = :orgId " + 
			"    and em.is_used=1\r\n" + 
			"    and ex.exh_id = em.exh_id\r\n" + 
			"    and ex.location_id in (:locationId)\r\n" + 
			"    and l.location_id = ex.location_id \r\n" + 
			"    and c.company_type_id = ex.company_type_id ORDER BY ex.exh_name",nativeQuery=true)
	List<SortedExhibitor> sortedExhibitorByAllCompanyType(@Param("locationId")List<Integer> locationId,@Param("orgId") int orgId);

	@Query(value=" select \r\n" + 
			"    em.*,\r\n" + 
			"    ex.exh_name,\r\n" + 
			"    l.location_name,\r\n" + 
			"    l.location_id,\r\n" + 
			"    c.company_type_name,\r\n" + 
			"    c.company_type_id\r\n" + 
			"    from \r\n" + 
			"        t_event_exh_mapping em,\r\n" + 
			"        m_exhibitor ex,\r\n" + 
			"        m_location l,\r\n" + 
			"        m_company c,m_events e\r\n" + 
			"    where  em.event_id  = e.event_id\r\n" + 
			"        and ex.org_id = e.org_id\r\n" + 
			"        and ex.org_id = :orgId and em.is_used=1\r\n" + 
			"    and ex.exh_id = em.exh_id\r\n" + 
			"    and ex.location_id in (:locationId)\r\n" + 
			"    and l.location_id = ex.location_id\r\n" + 
			"    and c.company_type_id in (:companyType)\r\n" + 
			"    and c.company_type_id = ex.company_type_id ORDER BY ex.exh_name",nativeQuery=true)
	List<SortedExhibitor> sortedExhibitorBy(@Param("locationId")List<Integer> locationId,@Param("companyType") List<Integer> companyType,@Param("orgId") int orgId);

}
