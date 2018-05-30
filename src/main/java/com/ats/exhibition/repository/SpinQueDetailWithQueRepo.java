package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.SpinQueDetailWithQue;

public interface SpinQueDetailWithQueRepo extends JpaRepository<SpinQueDetailWithQue, Integer> {

	@Query(value = "SELECT s.*,q.question FROM t_spin_que_detail s,m_spin_que q WHERE s.que_id=q.que_id AND s.is_used=1", nativeQuery = true)

	List<SpinQueDetailWithQue> findByIsUsed();
	
	@Query(value = "SELECT s.*,q.question FROM  t_spin_que_detail s,m_spin_que q WHERE s.que_id=q.que_id  AND s.is_used=1 AND t_que_id=:tQueId ", nativeQuery = true)

	List<SpinQueDetailWithQue> getAllQuestionsByTQueId(@Param("tQueId") int tQueId);

}
