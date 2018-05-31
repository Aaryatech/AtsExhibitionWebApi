package com.ats.exhibition.repository.feedback;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.feedback.FeedbackTxn; 

public interface FeedbackTxnRepo extends JpaRepository<FeedbackTxn, Integer> {

	@Query(value = "select \n" + 
			"    f.* \n" + 
			"    from\n" + 
			"    t_feedback f, \n" + 
			"    m_events e\n" + 
			"    where \n" + 
			"    f.exhb_id=:exhId \n" + 
			"    and e.event_from_date between :fromDate and :toDate\n" + 
			"    and e.event_id=f.event_id ", nativeQuery = true)
	List<FeedbackTxn> feedbackbetweenDate(@Param("exhId")int exhId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	 
}
