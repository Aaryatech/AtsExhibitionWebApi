package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ExhibitorWithOrgName;

public interface ExhibitorWithOrgNameRepo extends JpaRepository<ExhibitorWithOrgName, Integer> {

	@Query(value = "SELECT x.*, o.org_name FROM t_exhibitor x,m_organiser o WHERE x.exh_id=:exhId AND o.org_id=x.org_id", nativeQuery = true)
	ExhibitorWithOrgName getAllExhibitorsByExhId(@Param("exhId") int exhId);

	@Query(value = "SELECT x.*, o.org_name FROM t_exhibitor x,m_organiser o WHERE x.is_used=1 AND o.org_id=x.org_id", nativeQuery = true)
	List<ExhibitorWithOrgName> findByIsUsed();

	@Query(value = "SELECT x.*, o.org_name FROM t_exhibitor x,m_organiser o WHERE x.org_id=:orgId AND o.org_id=x.org_id AND x.is_used=1", nativeQuery = true)
	List<ExhibitorWithOrgName> getAllExhibotorsByorgIdAndIsUsed(@Param("orgId") int orgId);

}
