package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.VisitorProductMapping;

public interface VisitorProductMappingRepo extends JpaRepository<VisitorProductMapping, Integer> {

	 List<VisitorProductMapping> findByVisitorIdAndProductIdAndExhibitorId(int visitorId, int productId, int exhibitorId);


	@Transactional
	@Modifying
	@Query("UPDATE VisitorProductMapping SET like_status=:likeStatus  WHERE visitor_id=:visitorId AND product_id=:productId AND "
			+ " exhibitor_id=:exhibitorId")
	int updateStatus(@Param("visitorId") int visitorId, @Param("productId") int productId,@Param("exhibitorId") int exhibitorId,
			@Param("likeStatus") int likeStatus );

}
