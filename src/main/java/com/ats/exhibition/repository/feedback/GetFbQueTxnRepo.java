package com.ats.exhibition.repository.feedback;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.exhibition.model.feedback.GetFbQueTxn;

public interface GetFbQueTxnRepo extends JpaRepository<GetFbQueTxn, Integer> {
	
	@Query(value = "SELECT t_feedback.fb_tx_id,t_feedback.exhb_id,t_feedback.fb_id,SUM(t_feedback.rating),t_feedback.que_type,t_feedback.options,"
			+ "t_feedback.remark,t_feedback.outOfRating,t_feedback.userId,t_feedback.isUsed "
			+ " ,m_feedback_que.question FROM t_feedback,m_feedback_que "
			+ "WHERE t_feedback.fb_id=m_feedback_que.fb_id AND t_feedback.exhb_id=:exhbId  GROUP BY t_feedback.fb_id ", nativeQuery = true)
	List<GetFbQueTxn> findFbQueTxnByExhibId(@Param("exhbId") int exhbId);
	
	@Query(value = "SELECT t_feedback.fb_tx_id,t_feedback.exhbId,t_feedback.fbId,SUM(t_feedback.rating),t_feedback.queType,t_feedback.options," + 
			"t_feedback.remark,t_feedback.outOfRating,t_feedback.userId,t_feedback.isUsed ,m_feedback_que.question FROM t_feedback,m_feedback_que "
			+ "WHERE t_feedback.fb_id=m_feedback_que.fb_id AND t_feedback.event_id=:eventId GROUP BY t_feedback.fb_id ", nativeQuery = true)
	List<GetFbQueTxn> findFbQueTxnByEventId(@Param("eventId") int eventId);
	
}
