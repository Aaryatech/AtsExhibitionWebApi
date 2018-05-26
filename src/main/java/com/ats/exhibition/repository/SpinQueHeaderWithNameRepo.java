package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.SpinQueHeaderWithName;

public interface SpinQueHeaderWithNameRepo extends JpaRepository<SpinQueHeaderWithName, Integer> {

	@Query(value = "SELECT s.*,x.exh_name FROM m_spin_que s,m_exhibitor x WHERE s.exh_id=x.exh_id AND s.is_used=1", nativeQuery = true)
	List<SpinQueHeaderWithName> findByIsUsed();

	@Query(value = "SELECT s.*,x.exh_name FROM m_spin_que s,m_exhibitor x WHERE s.exh_id=x.exh_id AND s.is_used=1 AND  s.exh_id=:exhId", nativeQuery = true)
	List<SpinQueHeaderWithName> findByExhId(@Param("exhId") int exhId);

	@Query(value = "SELECT s.*,x.exh_name FROM m_spin_que s,m_exhibitor x WHERE s.exh_id=x.exh_id AND s.is_used=1 AND  s.que_id=:queId", nativeQuery = true)
	SpinQueHeaderWithName findByQueId(@Param("queId") int queId);

}
