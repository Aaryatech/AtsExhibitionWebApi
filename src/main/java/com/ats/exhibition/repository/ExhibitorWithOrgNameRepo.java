package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ExhibitorWithOrgName;

public interface ExhibitorWithOrgNameRepo extends JpaRepository<ExhibitorWithOrgName, Integer> {

	@Query(value = "SELECT x.*, o.org_name,l.location_name,c.company_type_name FROM m_exhibitor x,m_organiser o,m_location l,m_company c WHERE x.exh_id=:exhId AND o.org_id=x.org_id and l.location_id=x.location_id and c.company_type_id = x.company_type_id", nativeQuery = true)
	ExhibitorWithOrgName getAllExhibitorsByExhId(@Param("exhId") int exhId);

	@Query(value = "SELECT x.*, o.org_name FROM m_exhibitor x,m_organiser o WHERE x.is_used=1 AND o.org_id=x.org_id", nativeQuery = true)
	List<ExhibitorWithOrgName> findByIsUsed();

	@Query(value = "SELECT x.*, o.org_name,l.location_name,c.company_type_name \r\n" + 
			"FROM m_exhibitor x,m_organiser o,m_location l,m_company c \r\n" + 
			"WHERE x.org_id=:orgId \r\n" + 
			"AND o.org_id=x.org_id \r\n" + 
			"AND x.is_used=1 \r\n" + 
			"and l.location_id=x.location_id \r\n" + 
			"and c.company_type_id = x.company_type_id", nativeQuery = true)
	List<ExhibitorWithOrgName> getAllExhibotorsByorgIdAndIsUsed(@Param("orgId") int orgId);

}
