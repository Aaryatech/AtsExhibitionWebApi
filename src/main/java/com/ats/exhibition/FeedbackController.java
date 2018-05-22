package com.ats.exhibition;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ats.exhibition.model.feedback.FeedbackQue;
import com.ats.exhibition.model.feedback.FeedbackTxn;
import com.ats.exhibition.model.feedback.GetFbQueTxn;
import com.ats.exhibition.repository.feedback.FeedbackQueRepo;
import com.ats.exhibition.repository.feedback.FeedbackTxnRepo;
import com.ats.exhibition.repository.feedback.GetFbQueTxnRepo;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackQueRepo feedbackQueRepo;
	
	@Autowired
	FeedbackTxnRepo feedbackTxnRepo;
	
	@Autowired
	GetFbQueTxnRepo getFbQueTxnRepo;
	
	
	@RequestMapping(value = { "/getFbQueTxnByExhbId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFbQueTxn> getFbQueTxnByExhbId(@RequestParam("exhbId") int exhbId) {

		List<GetFbQueTxn> getFbQueTxnRes = null;
		try {
			
			getFbQueTxnRes = getFbQueTxnRepo.findFbQueTxnByExhibId(exhbId);
			
		} catch (Exception e) {
			
			System.err.println("Exception in getting getFbQueTxnByExhbId @ /FeedbackController");

			e.printStackTrace();

		}
		
		return getFbQueTxnRes;

	}
	
	
	@RequestMapping(value = { "/getFbQueTxnByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFbQueTxn> getFbQueTxnByEventId(@RequestParam("eventId") int eventId) {

		List<GetFbQueTxn> getFbQueTxnRes = null;
		try {
			
			getFbQueTxnRes = getFbQueTxnRepo.findFbQueTxnByEventId(eventId);
			
		} catch (Exception e) {
			
			System.err.println("Exception in getting getFbQueTxnByEventId @ /FeedbackController");

			e.printStackTrace();

		}
		
		return getFbQueTxnRes;

	}
	
	
	
	
	@RequestMapping(value = { "/saveFeedbackTxn" }, method = RequestMethod.POST)
	public @ResponseBody FeedbackTxn saveFeedbackTxn(@RequestBody FeedbackTxn fbTxn) {

		FeedbackTxn fbTxnResponse = new FeedbackTxn();

		try {

			fbTxnResponse = feedbackTxnRepo.saveAndFlush(fbTxn);

		} catch (Exception e) {

			System.err.println("Exception in saving saveFeedbackTxn @ /FeedbackController");
			e.printStackTrace();

		}
		return fbTxnResponse;

	}
	
	

	@RequestMapping(value = { "/saveFeedbackQue" }, method = RequestMethod.POST)
	public @ResponseBody FeedbackQue saveFeedbackQue(@RequestBody FeedbackQue feedbackQue) {

		FeedbackQue fbResponse = new FeedbackQue();

		try {

			fbResponse = feedbackQueRepo.saveAndFlush(feedbackQue);

		} catch (Exception e) {

			System.err.println("Exception in saving FeedbackQue @ /FeedbackController");
			e.printStackTrace();

		}
		return fbResponse;

	}
	
	@RequestMapping(value = { "/getFeedbackQueByExbId" }, method = RequestMethod.POST)
	public @ResponseBody List<FeedbackQue> getFeedbackQueByExbId(@RequestParam("exhbId") int exhbId) {

		List<FeedbackQue> fbQueList = null;
		try {
			
			fbQueList = feedbackQueRepo.findByIsUsedAndExhbId(1, exhbId);
			
		} catch (Exception e) {
			
			System.err.println("Exception in getting getFeedbackQueByExbId @ /FeedbackController");

			e.printStackTrace();

		}
		
		return fbQueList;

	}
	
	@RequestMapping(value = { "/getFbQueByFbId" }, method = RequestMethod.POST)
	public @ResponseBody FeedbackQue getFbQueByFbId(@RequestParam("fbId") int fbId) {

		FeedbackQue fbQue = null;
		try {
			
			fbQue = feedbackQueRepo.findByFbId(fbId);
			
		} catch (Exception e) {
			
			System.err.println("Exception in getting getFbQueByFbId @ /FeedbackController");

			e.printStackTrace();

		}
		
		return fbQue;

	}

}
