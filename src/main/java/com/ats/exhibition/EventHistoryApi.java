package com.ats.exhibition;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ats.exhibition.model.eventhistory.GetEventHistory;
import com.ats.exhibition.repository.eventhistory.GetEventHistoryRepo;

@RestController
public class EventHistoryApi {

	@Autowired
	GetEventHistoryRepo getEventHistoryRepo;
	
	@RequestMapping(value = { "/getEventHistory" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEventHistory> getFeedbackTxnDetailsRepo(@RequestParam("exhbId") int exhbId) {

		List<GetEventHistory> eventHistoryList = null;
		
		try {
			
			eventHistoryList = getEventHistoryRepo.getEventHistory(exhbId);
			
		} catch (Exception e) {
			
			System.err.println("Exception in getting getEventHistory @ /EventHistoryApi" +e.getMessage());

			e.printStackTrace();

		}
		
		return eventHistoryList;

	}
	
	
	
	
	
	
	
	
	
	
}
