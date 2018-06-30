package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.SpinQueMasterWithName;

public interface SpinQueMasterWithNameRepo extends JpaRepository<SpinQueMasterWithName, Integer> {

	@Query(value = "SELECT s.*,x.exh_name FROM m_spin_que s,m_exhibitor x WHERE s.exh_id=x.exh_id AND s.is_used=1", nativeQuery = true)
	List<SpinQueMasterWithName> findByIsUsed();

	@Query(value = "SELECT s.*,x.exh_name FROM m_spin_que s,m_exhibitor x WHERE s.exh_id=x.exh_id AND s.is_used=1 AND  s.exh_id=:exhId", nativeQuery = true)
	List<SpinQueMasterWithName> findByExhId(@Param("exhId") int exhId);

	@Query(value = "SELECT s.*,x.exh_name FROM m_spin_que s,m_exhibitor x WHERE s.exh_id=x.exh_id AND s.is_used=1 AND  s.que_id=:queId", nativeQuery = true)
	SpinQueMasterWithName findByQueId(@Param("queId") int queId);

	

}
