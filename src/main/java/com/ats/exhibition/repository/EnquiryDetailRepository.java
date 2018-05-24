package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.EnquiryDetail;

public interface EnquiryDetailRepository extends JpaRepository<EnquiryDetail, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE EnquiryDetail SET isUsed=0  WHERE enq_detail_id=:enqDetailId")
	int deleteEnquiryDetail(@Param("enqDetailId") int enqDetailId);

	List<EnquiryDetail> getAllEnquiryDetailByIsUsed(int i);

}
