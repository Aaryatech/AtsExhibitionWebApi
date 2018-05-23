package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ExhibitorWithOrgName;

public interface ExhibitorWithOrgNameRepo extends JpaRepository<ExhibitorWithOrgName, Integer> {

	@Query(value = "SELECT x.*, o.org_name,l.location_name,c.company_type_name FROM m_exhibitor x,m_organiser o,m_location l,m_company c WHERE x.exh_id=:exhId AND o.org_id=x.org_id and l.location_id=x.location_id and c.company_type_id = x.company_type_id", nativeQuery = true)
	ExhibitorWithOrgName getAllExhibitorsByExhId(@Param("exhId") int exhId);

	@Query(value = "SELECT x.*, o.org_name,l.location_name,c.company_type_name  FROM m_exhibitor x,m_organiser o,m_location l,m_company c  WHERE x.is_used=1 AND o.org_id=x.org_id and l.location_id=x.location_id and c.company_type_id = x.company_type_id", nativeQuery = true)
	List<ExhibitorWithOrgName> findByIsUsed();

	@Query(value = "SELECT x.*, o.org_name,l.location_name,c.company_type_name "
			+ "FROM m_exhibitor x,m_organiser o,m_location l,m_company c " + "WHERE x.org_id=:orgId "
			+ "AND o.org_id=x.org_id " + "AND x.is_used=1 " + "and l.location_id=x.location_id "
			+ "and c.company_type_id = x.company_type_id", nativeQuery = true)
	List<ExhibitorWithOrgName> getAllExhibotorsByorgIdAndIsUsed(@Param("orgId") int orgId);

	@Query(value = "SELECT e.exh_id,e.exh_name,e.exh_company,e.logo,e.contact_person_name1,e.contact_person_name2,"
			+ "e.person_mob1,e.person_mob2,e.person_email1,e.person_email2,e.address,e.comp_lat,e.comp_long,"
			+ "e.user_mob,e.password,e.about_company,e.company_type,e.is_used,e.org_id,e.location_id,e.company_type_id ,"
			+ "o.org_name,c.company_type_name,l.location_name FROM m_exhibitor e , m_location l,m_organiser o, m_company c "
			+ "WHERE e.location_id=l.location_id AND e.company_type_id=c.company_type_id AND e.org_id=o.org_id AND e.is_used=1 "
			+ "AND exh_id IN (SELECT t_visitor_exhibitor .exhibitor_id FROM t_visitor_exhibitor WHERE t_visitor_exhibitor.visitor_id=:visitorId "
			+ "AND  t_visitor_exhibitor.like_status=1)", nativeQuery = true)
	List<ExhibitorWithOrgName> getAllExhibitorsByVisitorIdAndLikeStatus(@Param("visitorId") int visitorId);

	@Query(value = "SELECT\r\n" + 
			"    x.*, o.org_name,l.location_name,c.company_type_name \r\n" + 
			"FROM \r\n" + 
			"    m_exhibitor x,m_organiser o,m_location l,m_company c \r\n" + 
			"WHERE  \r\n" + 
			"    o.org_id=x.org_id \r\n" + 
			"    and l.location_id=x.location_id \r\n" + 
			"    and c.company_type_id = x.company_type_id \r\n" + 
			"order by \r\n" + 
			"    x.exh_name", nativeQuery = true)
	List<ExhibitorWithOrgName> sortedExhibitorListByLocationAndCompType();

	@Query(value = "SELECT\r\n" + 
			"    x.*, o.org_name,l.location_name,c.company_type_name \r\n" + 
			"FROM \r\n" + 
			"    m_exhibitor x,m_organiser o,m_location l,m_company c \r\n" + 
			"WHERE  \r\n" + 
			"    o.org_id=x.org_id\r\n" + 
			"    and x.company_type_id in (:companyType)\r\n" + 
			"    and l.location_id=x.location_id \r\n" + 
			"    and c.company_type_id = x.company_type_id \r\n" + 
			"order by \r\n" + 
			"    x.exh_name", nativeQuery = true)
	List<ExhibitorWithOrgName> sortedExhibitorByAllLocation(@Param("companyType")List<Integer> companyType);

	@Query(value = "SELECT\r\n" + 
			"    x.*, o.org_name,l.location_name,c.company_type_name \r\n" + 
			"FROM \r\n" + 
			"    m_exhibitor x,m_organiser o,m_location l,m_company c \r\n" + 
			"WHERE  \r\n" + 
			"    o.org_id=x.org_id\r\n" + 
			"    and x.location_id in (:locationId)\r\n" + 
			"    and l.location_id=x.location_id \r\n" + 
			"    and c.company_type_id = x.company_type_id \r\n" + 
			"order by \r\n" + 
			"    x.exh_name", nativeQuery = true)
	List<ExhibitorWithOrgName> sortedExhibitorByAllCompanyType(@Param("locationId")List<Integer> locationId);

	@Query(value = "SELECT x.*, o.org_name,l.location_name,c.company_type_name FROM m_exhibitor x,m_organiser o,m_location l,m_company c WHERE x.user_mob=:mob AND o.org_id=x.org_id and l.location_id=x.location_id and c.company_type_id = x.company_type_id", nativeQuery = true)
	List<ExhibitorWithOrgName> getExhibitorsByParam1(@Param("mob")String parameter);

	@Query(value = "SELECT x.*, o.org_name,l.location_name,c.company_type_name FROM m_exhibitor x,m_organiser o,m_location l,m_company c WHERE x.exh_id=:exhId AND o.org_id=x.org_id and l.location_id=x.location_id and c.company_type_id = x.company_type_id", nativeQuery = true)
	List<ExhibitorWithOrgName> getExhibitorsByParam2(@Param("exhId")String parameter);

	@Query(value = "SELECT x.*, o.org_name,l.location_name,c.company_type_name FROM m_exhibitor x,m_organiser o,m_location l,m_company c WHERE x.exh_name=:exhName AND o.org_id=x.org_id and l.location_id=x.location_id and c.company_type_id = x.company_type_id", nativeQuery = true)
	List<ExhibitorWithOrgName> getExhibitorsByParam3(@Param("exhName")String parameter);

}
