package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.VisitorExhibitorMapping;

public interface VisitorExhibitorMappingRepository extends JpaRepository<VisitorExhibitorMapping, Integer> {

	VisitorExhibitorMapping findByVisitorIdAndExhibitorId(int visitorId, int exhibitorId);

	@Transactional
	@Modifying
	@Query("UPDATE VisitorExhibitorMapping SET like_status=:likeStatus  WHERE visitor_id=:visitorId AND exhibitor_id=:exhibitorId")
	int updateStatus(@Param("visitorId") int visitorId, @Param("exhibitorId") int exhibitorId,
			@Param("likeStatus") int likeStatus);

}
