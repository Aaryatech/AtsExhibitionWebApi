package com.ats.exhibition.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.EnquiryHeader;

public interface EnquiryHeaderRepository extends JpaRepository<EnquiryHeader, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE EnquiryHeader SET isUsed=0  WHERE enq_id=:enqId")
	int deleteEnquiryHeader(@Param("enqId") int enqId);

	EnquiryHeader findByEnqId(int enqId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE EnquiryHeader SET empId=:empId, nextMeetDate=:meetDate ,status=:status WHERE enq_id=:enqId")
	int editEnqHeader(@Param("empId") int empId,@Param("enqId") int enqId,@Param("meetDate") Date meetDate,
			@Param("status") int status);

	
	@Transactional
	@Modifying
	@Query("UPDATE EnquiryHeader SET  nextMeetDate=:meetDate ,status=:status WHERE enq_id=:enqId")
	int updateEnqHeaderForFollowup(@Param("enqId") int enqId,@Param("meetDate") Date meetDate,
			@Param("status") int status);
}
	

