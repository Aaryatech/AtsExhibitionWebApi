package com.ats.exhibition.repository.feedback;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ats.exhibition.model.feedback.FeedbackQue;

public interface FeedbackQueRepo extends JpaRepository<FeedbackQue, Integer> {
	
	public FeedbackQue save(FeedbackQue feedbackQue);
	
	public List<FeedbackQue> findByIsUsedAndExhbId(int isUsed,int exbhId);
	
	
	FeedbackQue findByFbId(int fbId);
	
}
