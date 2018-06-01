package com.ats.exhibition;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ats.exhibition.model.eventhistory.GetEventHistory;
import com.ats.exhibition.model.eventhistory.GetEventVisitorName;
import com.ats.exhibition.repository.eventhistory.GetEventHistoryRepo;
import com.ats.exhibition.repository.eventhistory.GetEventVisitorNameRepo;
 
@RestController
public class EventHistoryApi {

	@Autowired
	GetEventHistoryRepo getEventHistoryRepo;
	
	@Autowired
	GetEventVisitorNameRepo getEventVisitorNameRepo;
	
	
	@RequestMapping(value = { "/getEventVisitorName" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEventVisitorName> getEventVisitorName(@RequestParam("eventId") int eventId,@RequestParam("exhbId") int exhbId) {

		List<GetEventVisitorName> eventVistorNames = null;
		
		try {
			
			if(eventId!=0) {
				
			eventVistorNames = getEventVisitorNameRepo.getEventVisitorNames(eventId);
			
			}
			else {
				
				eventVistorNames = getEventVisitorNameRepo.getEventVisitorNamesAllEvent(exhbId);
			}
		} catch (Exception e) {
			
			System.err.println("Exception in getting getEventVisitorName @ /EventHistoryApi" +e.getMessage());

			e.printStackTrace();

		}
		
		return eventVistorNames;

	}
	
	
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
