package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Visitor SET isUsed=0  WHERE visitor_id=:visitorId")
	int deleteVisitor(@Param("visitorId") int visitorId);

	Visitor findByVisitorMobile(String visitorMobile);

	Visitor findByVisitorId(int visitorId);

	@Transactional
	@Modifying
	@Query("UPDATE Visitor SET token=:token  WHERE visitor_id=:visitorId")
	int updateToken(@Param("visitorId") int visitorId, @Param("token") String token);

	List<Visitor> findByEventIdAndIsUsed(int eventId, int isUsed);


}
