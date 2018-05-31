package com.ats.exhibition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.exhibition.model.EnquiryHeaderWithName; 
import com.ats.exhibition.model.EventExhMappingWithExhName;
import com.ats.exhibition.model.EventWithOrgName;
import com.ats.exhibition.model.ExhibitorWithOrgName;
import com.ats.exhibition.model.GetEventSheduleDetail;
import com.ats.exhibition.model.GetEventSheduleHeader;
import com.ats.exhibition.model.Package1;
import com.ats.exhibition.model.SortedExhibitor;
import com.ats.exhibition.model.SortedVisitor;
import com.ats.exhibition.model.VisitorByExhiId;
import com.ats.exhibition.model.VisitorWithOrgEventName;
import com.ats.exhibition.model.feedback.FeedbackTxn;
import com.ats.exhibition.model.feedback.GetFbQueTxn; 
import com.ats.exhibition.repository.Package1Repository;
import com.ats.exhibition.repository.SortedExhibitorRepository;
import com.ats.exhibition.repository.SortedVisitorRepository;
import com.ats.exhibition.repository.VisitorByExhiIdRepo;
import com.ats.exhibition.repository.VisitorWithOrgEventNameRepo;
import com.ats.exhibition.repository.feedback.FeedbackTxnRepo; 
import com.ats.exhibition.repository.EnquiryHeaderWithNameRepo;
import com.ats.exhibition.repository.EventExhMappingWithExhNameRepo;
import com.ats.exhibition.repository.EventWithOrgNameRepository;
import com.ats.exhibition.repository.ExhibitorWithOrgNameRepo;
import com.ats.exhibition.repository.GetEventSheduleDetailRepository;
import com.ats.exhibition.repository.GetEventSheduleHeaderRepository;

@RestController
public class SuperAdminRestController {
	
	
	@Autowired
	SortedExhibitorRepository sortedExhibitorRepository;
	
	@Autowired
	ExhibitorWithOrgNameRepo ExhibitorWithOrgNameRepo;
	
	@Autowired
	Package1Repository package1Repository;
	
	@Autowired
	EventWithOrgNameRepository eventWithOrgNameRepository;
	
	@Autowired
	SortedVisitorRepository sortedVisitorRepository;
	
	@Autowired
	GetEventSheduleHeaderRepository getEventSheduleHeaderRepository;
	
	@Autowired
	GetEventSheduleDetailRepository getEventSheduleDetailRepository;
	
	@Autowired
	VisitorWithOrgEventNameRepo visitorWithOrgEventNameRepo;
	
	@Autowired
	EventExhMappingWithExhNameRepo eventExhMappingWithExhNameRepo;
	
	@Autowired
	VisitorByExhiIdRepo visitorByExhiIdRepo;
	
	@Autowired
	EnquiryHeaderWithNameRepo enquiryHeaderWithNameRepo;
	
	@Autowired
	FeedbackTxnRepo feedbackTxnRepo;
	
	
	@RequestMapping(value = { "/sortedExhibitorByLocationAndCompanyType" }, method = RequestMethod.POST)
	public @ResponseBody List<SortedExhibitor> sortedExhibitorByLocationAndCompanyType(@RequestParam("eventId") List<Integer> eventId
			,@RequestParam("locationId") List<Integer> locationId, @RequestParam("companyType") List<Integer> companyType) {

		List<SortedExhibitor> sortedExhibitorByLocationAndCompanyType = new ArrayList<SortedExhibitor>();

		try { 
			
			if(locationId.get(0)==0 && companyType.get(0)==0)
			{
				sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository.sortedExhibitorByLocationAndCompanyType(eventId);
			}
			else if(locationId.get(0)==0 && companyType.get(0)!=0)
			{
				sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository.sortedExhibitorByAllLocation(eventId,companyType);
			}
			else if(locationId.get(0)!=0 && companyType.get(0)==0)
			{
				sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository.sortedExhibitorByAllCompanyType(eventId,locationId);
			}
			else
			{
				sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository.sortedExhibitorBy(eventId,locationId,companyType);
			}
			

		} catch (Exception e) {

			e.printStackTrace();

		}
		return sortedExhibitorByLocationAndCompanyType;

	}
	
	@RequestMapping(value = { "/sortedExhibitorListByLocationAndCompType" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhibitorWithOrgName> sortedExhibitorListByLocationAndCompType( @RequestParam("locationId") List<Integer> locationId, 
			@RequestParam("companyType") List<Integer> companyType) {

		List<ExhibitorWithOrgName> sortedExhibitorListByLocationAndCompType = new ArrayList<ExhibitorWithOrgName>();

		try { 
			
			if(locationId.get(0)==0 && companyType.get(0)==0)
			{
				sortedExhibitorListByLocationAndCompType = ExhibitorWithOrgNameRepo.sortedExhibitorListByLocationAndCompType();
			}
			else if(locationId.get(0)==0 && companyType.get(0)!=0)
			{
				sortedExhibitorListByLocationAndCompType = ExhibitorWithOrgNameRepo.sortedExhibitorByAllLocation(companyType);
			}
			else if(locationId.get(0)!=0 && companyType.get(0)==0)
			{
				sortedExhibitorListByLocationAndCompType = ExhibitorWithOrgNameRepo.sortedExhibitorByAllCompanyType(locationId);
			}
			 
			

		} catch (Exception e) {

			e.printStackTrace();

		}
		return sortedExhibitorListByLocationAndCompType;

	}
	
	@RequestMapping(value = { "/getAllPackagesByPkgType" }, method = RequestMethod.POST)
	public @ResponseBody List<Package1> getAllPackagesByPkgType(@RequestParam("pkgType") int pkgType) {

		List<Package1> packageList = new ArrayList<Package1>();

		try {

			packageList = package1Repository.findByPkgTypeAndIsUsed(pkgType,1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return packageList;

	}
	
	@RequestMapping(value = { "/eventListByMultipleOrgId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventWithOrgName> eventListByMultipleOrgId(@RequestParam("orgList") List<Integer> orgList) {

		List<EventWithOrgName> eventList = new ArrayList<EventWithOrgName>();

		try {

			if(orgList.get(0)==0)
				eventList = eventWithOrgNameRepository.getAllEventsByIsUsed();
			else
				eventList = eventWithOrgNameRepository.eventListByMultipleOrgId(orgList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}
	
	
	@RequestMapping(value = { "/visitorListFilterByLocationAndCompType" }, method = RequestMethod.POST)
	public @ResponseBody List<SortedVisitor> visitorListFilterByLocationAndCompType(@RequestParam("eventId") List<Integer> eventId
			,@RequestParam("locationId") List<Integer> locationId, @RequestParam("companyType") List<Integer> companyType,@RequestParam("next") int next) {

		List<SortedVisitor> visitorListFilterByLocationAndCompType = new ArrayList<SortedVisitor>();

		try { 
			
			if(locationId.get(0)==0 && companyType.get(0)!=0)
			{
				visitorListFilterByLocationAndCompType = sortedVisitorRepository.sortedVisitorByAllLocation(eventId,companyType,next);
			}
			else if(locationId.get(0)!=0 && companyType.get(0)==0)
			{
				visitorListFilterByLocationAndCompType = sortedVisitorRepository.sortedVisitorByAllCompanyType(eventId,locationId,next);
			}
			else if(locationId.get(0)!=0 && companyType.get(0)!=0)
			{
				visitorListFilterByLocationAndCompType = sortedVisitorRepository.sortedVisitorByLocationAndCompanyType(eventId,companyType,locationId,next);
			}
			else
			{
				visitorListFilterByLocationAndCompType = sortedVisitorRepository.sortedVisitorByLocationAndCompanyType(eventId,next);
			}
			

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitorListFilterByLocationAndCompType;

	}
	
	
	@RequestMapping(value = { "/getEventSheduleByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEventSheduleHeader> getEventSheduleByEventId(@RequestParam("eventId") int eventId) {

		List<GetEventSheduleHeader> getEventSheduleByEventId = new ArrayList<GetEventSheduleHeader>();

		try {

			 
				getEventSheduleByEventId = getEventSheduleHeaderRepository.findByEventIdAndIsUsed(eventId,1);
				
				for(int i=0; i<getEventSheduleByEventId.size();i++)
				{
					List<GetEventSheduleDetail> getEventSheduleDetailList = getEventSheduleDetailRepository.findByScheduleIdAndIsUsed(getEventSheduleByEventId.get(i).getScheduleId(),1);
					getEventSheduleByEventId.get(i).setGetEventSheduleDetailList(getEventSheduleDetailList);
				}
		 

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getEventSheduleByEventId;

	}
	
	@RequestMapping(value = { "/getAllVisitorsByOrgId" }, method = RequestMethod.POST)
	public @ResponseBody List<VisitorWithOrgEventName> getAllVisitorsByOrgId(@RequestParam("orgId") int orgId) {

		List<VisitorWithOrgEventName> visitorList = new ArrayList<VisitorWithOrgEventName>();

		try {

			visitorList = visitorWithOrgEventNameRepo.getAllVisitorsByOrgId(orgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitorList;

	}
	
	@RequestMapping(value = { "/eventListByExhIdBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<EventExhMappingWithExhName> eventListByExhIdBetweenDate(@RequestParam("exhId") int exhId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<EventExhMappingWithExhName> eventList = new ArrayList<EventExhMappingWithExhName>();

		try {

			eventList = eventExhMappingWithExhNameRepo.eventListByExhIdBetweenDate(exhId,fromDate,toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}
	
	@RequestMapping(value = { "/visitorListByExhibitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<VisitorByExhiId> visitorListByExhibitorId(@RequestParam("exhId") int exhId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<VisitorByExhiId> visitorList = new ArrayList<VisitorByExhiId>();

		try {

			visitorList = visitorByExhiIdRepo.visitorListByExhibitorIdBetweenDate(exhId,fromDate,toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitorList;

	}
	
	@RequestMapping(value = { "/enquiryBetweenDateByExhibitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryHeaderWithName> enquiryBetweenDateByExhibitorId(@RequestParam("exhId") int exhId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<EnquiryHeaderWithName> headerList = new ArrayList<EnquiryHeaderWithName>();

		try {

			headerList = enquiryHeaderWithNameRepo.enquiryBetweenDateByExhibitorId(exhId,fromDate,toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}
	
	@RequestMapping(value = { "/feedbackbetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<FeedbackTxn> feedbackbetweenDate(@RequestParam("exhId") int exhId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<FeedbackTxn> feedbackList = new ArrayList<FeedbackTxn>();

		try {

			feedbackList = feedbackTxnRepo.feedbackbetweenDate(exhId,fromDate,toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return feedbackList;

	}
	
	
	@RequestMapping(value = { "/enquiryNotBetweenDateWithStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryHeaderWithName> enquiryNotBetweenDateWithStatus(@RequestParam("exhId") int exhId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("status") int status) {

		List<EnquiryHeaderWithName> headerList = new ArrayList<EnquiryHeaderWithName>();

		try {

			headerList = enquiryHeaderWithNameRepo.enquiryNotBetweenDateWithStatus(exhId,fromDate,toDate,status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}
	
	@RequestMapping(value = { "/equiryListWithStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryHeaderWithName> equiryListWithStatus(@RequestParam("exhId") int exhId,@RequestParam("status") int status) {

		List<EnquiryHeaderWithName> equiryListWithStatus = new ArrayList<EnquiryHeaderWithName>();

		try {

			equiryListWithStatus = enquiryHeaderWithNameRepo.equiryListWithStatus(exhId,status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return equiryListWithStatus;

	}

}
