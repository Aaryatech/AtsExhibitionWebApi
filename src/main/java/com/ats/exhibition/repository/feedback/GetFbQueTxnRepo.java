package com.ats.exhibition.repository.feedback;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.exhibition.model.feedback.GetFbQueTxn;

public interface GetFbQueTxnRepo extends JpaRepository<GetFbQueTxn, Integer> {
	
	@Query(value = "SELECT t_feedback.fb_tx_id,t_feedback.exhb_id,t_feedback.fb_id,SUM(t_feedback.rating) AS rating, SUM(t_feedback.rating)/(select count(*) from t_feedback f where f.fb_id=t_feedback.fb_id AND f.exhb_id=:exhbId) AS rating_avg,t_feedback.que_type,t_feedback.options,"
			+ "t_feedback.remark,t_feedback.out_of_rating,t_feedback.user_id,t_feedback.is_used "
			+ " ,m_feedback_que.question,t_feedback.event_id FROM t_feedback,m_feedback_que "
			+ "WHERE t_feedback.fb_id=m_feedback_que.fb_id AND t_feedback.exhb_id=:exhbId  GROUP BY t_feedback.fb_id ", nativeQuery = true)
	List<GetFbQueTxn> findFbQueTxnByExhibId(@Param("exhbId") int exhbId);
	
	
	
	@Query(value = "SELECT t_feedback.fb_tx_id,t_feedback.exhb_id,t_feedback.fb_id,SUM(t_feedback.rating) AS rating, SUM(t_feedback.rating)/(select count(*) from t_feedback f where f.fb_id=t_feedback.fb_id AND f.event_id=:eventId) AS rating_avg,t_feedback.que_type,t_feedback.options," + 
			"t_feedback.remark,t_feedback.out_of_rating,t_feedback.user_id,t_feedback.is_used ,m_feedback_que.question,t_feedback.event_id FROM t_feedback,m_feedback_que "
			+ "WHERE t_feedback.fb_id=m_feedback_que.fb_id AND t_feedback.event_id=:eventId GROUP BY t_feedback.fb_id , t_feedback.event_id ", nativeQuery = true)
	List<GetFbQueTxn> findFbQueTxnByEventId(@Param("eventId") int eventId);
	
	
	@Query(value = "SELECT\n" + 
			"        t_feedback.fb_tx_id,\n" + 
			"        t_feedback.exhb_id,\n" + 
			"        t_feedback.fb_id,\n" + 
			"        t_feedback.rating ,\n" + 
			"        coalesce(0)  AS rating_avg,\n" + 
			"        t_feedback.que_type,\n" + 
			"        t_feedback.options,\n" + 
			"        t_feedback.remark,\n" + 
			"        t_feedback.out_of_rating,\n" + 
			"        t_feedback.user_id,\n" + 
			"        t_feedback.is_used ,\n" + 
			"        m_feedback_que.question,t_feedback.event_id \n" + 
			"    FROM\n" + 
			"        t_feedback,\n" + 
			"        m_feedback_que \n" + 
			"    WHERE\n" + 
			"        t_feedback.fb_id=m_feedback_que.fb_id \n" + 
			"        AND t_feedback.event_id=:eventId\n" + 
			"        AND t_feedback.fb_id=:fbId", nativeQuery = true)
	List<GetFbQueTxn> findFbQueTxnByFbIdAndEventId(@Param("fbId") int fbId,@Param("eventId") int eventId);
	
}
