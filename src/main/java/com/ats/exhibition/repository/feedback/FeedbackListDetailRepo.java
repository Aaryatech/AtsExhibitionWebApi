package com.ats.exhibition.repository.feedback;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.feedback.FeedbackListDetail;

public interface FeedbackListDetailRepo extends JpaRepository<FeedbackListDetail, Integer> {

	@Query(value = "select t_feedback.fb_tx_id,t_feedback.exhb_id,t_feedback.fb_id,t_feedback.event_id,t_feedback.rating,t_feedback.que_type,"
			+ "t_feedback.options,t_feedback.remark,t_feedback.out_of_rating,t_feedback.user_id as visitor_id,t_feedback.is_used,v.visitor_name,q.question "
			+ "from t_feedback,m_visitor v,m_feedback_que q where  v.visitor_id=t_feedback.user_id and t_feedback.exhb_id=:exhbId and "
			+ "t_feedback.event_id=:eventId and t_feedback.user_id=:visitorId and q.fb_id=t_feedback.fb_id \r\n"
			+ " ", nativeQuery = true)
	List<FeedbackListDetail> getFeedbackDetailList(@Param("exhbId") int exhbId, @Param("eventId") int eventId,@Param("visitorId")int visitorId);


}
