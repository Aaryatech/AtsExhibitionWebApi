package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.VisitorProductMapping;

public interface VisitorProductMappingRepo extends JpaRepository<VisitorProductMapping, Integer> {

	VisitorProductMapping findByVisitorIdAndProductId(int visitorId, int productId);

	@Transactional
	@Modifying
	@Query("UPDATE VisitorProductMapping SET like_status=:likeStatus  WHERE visitor_id=:visitorId AND product_id=:productId")
	int updateStatus(@Param("visitorId") int visitorId, @Param("productId") int productId,
			@Param("likeStatus") int likeStatus);

}
