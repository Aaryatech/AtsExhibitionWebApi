package com.ats.exhibition.repository.feedback;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.feedback.FeedbackListHeader;

public interface FeedbackListHeaderRepo extends JpaRepository<FeedbackListHeader, Integer> {

	@Query(value = "select f.fb_tx_id,f.exhb_id,f.event_id,SUM(rating) as rating,SUM(out_of_rating) as out_of_rating,"
			+ "f.user_id as visitor_id ,v.visitor_name,f.is_used from t_feedback f,m_visitor v where v.visitor_id=f.user_id "
			+ "and f.exhb_id=:exhbId and f.event_id=:eventId" + " ", nativeQuery = true)
	List<FeedbackListHeader> getFeedbackHeaderList(@Param("exhbId") int exhbId, @Param("eventId") int eventId);

}
