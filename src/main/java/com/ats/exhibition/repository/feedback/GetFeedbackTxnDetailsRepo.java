package com.ats.exhibition.repository.feedback;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.exhibition.model.feedback.GetFeedbackTxnDetails;

public interface GetFeedbackTxnDetailsRepo extends JpaRepository<GetFeedbackTxnDetails, Integer> {
	
	
	@Query(value = " SELECT m_feedback_que.question,m_feedback_que.que_desc,t_feedback.fb_tx_id,t_feedback.exhb_id,t_feedback.fb_id,t_feedback.event_id," + 
			" t_feedback.rating,t_feedback.remark,m_visitor.visitor_id,m_visitor.visitor_name,m_visitor.visitor_mobile " + 
			" FROM t_feedback,m_feedback_que,m_visitor " + 
			" WHERE t_feedback.user_id=m_visitor.visitor_id AND t_feedback.fb_id=m_feedback_que.fb_id AND t_feedback.fb_id=:fbId ", nativeQuery = true)
	List<GetFeedbackTxnDetails> getFbQueDetailByFbId(@Param("fbId") int fbId);
	

}
