package com.ats.exhibition;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.exhibition.model.EnquiryHeaderWithName;
import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.EventExhMapping;
import com.ats.exhibition.model.EventExhMappingWithExhName;
import com.ats.exhibition.model.EventWithOrgName;
import com.ats.exhibition.model.ExhEventSubscription;
import com.ats.exhibition.model.ExhibitorWithOrgName;
import com.ats.exhibition.model.GetEventSheduleDetail;
import com.ats.exhibition.model.GetEventSheduleHeader;
import com.ats.exhibition.model.GetExhEventSubscription;
import com.ats.exhibition.model.GetTrackHeader;
import com.ats.exhibition.model.Package1;
import com.ats.exhibition.model.PostTrackDetail;
import com.ats.exhibition.model.PostTrackHeader;
import com.ats.exhibition.model.SortedExhibitor;
import com.ats.exhibition.model.SortedVisitor;
import com.ats.exhibition.model.VisitorByExhiId;
import com.ats.exhibition.model.VisitorWithOrgEventName;
import com.ats.exhibition.model.feedback.FeedbackTxn;
import com.ats.exhibition.repository.Package1Repository;
import com.ats.exhibition.repository.PostTrackDetailRepository;
import com.ats.exhibition.repository.PostTrackHeaderRepository;
import com.ats.exhibition.repository.SortedExhibitorRepository;
import com.ats.exhibition.repository.SortedVisitorRepository;
import com.ats.exhibition.repository.VisitorByExhiIdRepo;
import com.ats.exhibition.repository.VisitorWithOrgEventNameRepo;
import com.ats.exhibition.repository.feedback.FeedbackTxnRepo;
import com.ats.exhibition.repository.EnquiryHeaderWithNameRepo;
import com.ats.exhibition.repository.EventExhMappingRepository;
import com.ats.exhibition.repository.EventExhMappingWithExhNameRepo;
import com.ats.exhibition.repository.EventWithOrgNameRepository;
import com.ats.exhibition.repository.ExhEventSubscriptionRepository;
import com.ats.exhibition.repository.ExhibitorWithOrgNameRepo;
import com.ats.exhibition.repository.GetEventSheduleDetailRepository;
import com.ats.exhibition.repository.GetEventSheduleHeaderRepository;
import com.ats.exhibition.repository.GetExhEventSubRepository;
import com.ats.exhibition.repository.GetTrackHeaderRepository;

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

	@Autowired
	PostTrackHeaderRepository postTrackHeaderRepository;

	@Autowired
	PostTrackDetailRepository postTrackDetailRepository;

	@Autowired
	GetTrackHeaderRepository getTrackHeaderRepository;

	@Autowired
	GetExhEventSubRepository getExhEventSubRepository;
	
	
	
	@Autowired
	ExhEventSubscriptionRepository exhEventSubscriptionRepository;//

	@Autowired
	EventExhMappingRepository eventExhMappingRepository;
	
	
	@RequestMapping(value = { "/saveExhEventSubscription" }, method = RequestMethod.POST)
	public @ResponseBody ExhEventSubscription saveExhEventSubscription(@RequestBody ExhEventSubscription exhEventSubscription) {

		ExhEventSubscription resExhEventSubscription = null;

		try {
			
			ExhEventSubscription isExist=exhEventSubscriptionRepository.findByExhIdAndEventId(exhEventSubscription.getExhId(), exhEventSubscription.getEventId());

			if(isExist==null) {
				
				System.err.println("Call Save /saveExhEventSubscription  @SuperAdminRestController"); 
				
			resExhEventSubscription = exhEventSubscriptionRepository.save(exhEventSubscription);
			}
			else {
				System.err.println("Call Save /saveExhEventSubscription  @SuperAdminRestController failed:: Already subscribed "); 

			}

		} catch (Exception e) {

			System.err.println("Exception in /saveExhEventSubscription @ superadRestContr "+e.getMessage());
			e.printStackTrace();

		}
		
		return resExhEventSubscription;

	}
	

	@RequestMapping(value = { "/sortedExhibitorByLocationAndCompanyType" }, method = RequestMethod.POST)
	public @ResponseBody List<SortedExhibitor> sortedExhibitorByLocationAndCompanyType(
			@RequestParam("eventId") List<Integer> eventId, @RequestParam("locationId") List<Integer> locationId,
			@RequestParam("companyType") List<Integer> companyType, @RequestParam("orgId") int orgId) {

		List<SortedExhibitor> sortedExhibitorByLocationAndCompanyType = new ArrayList<SortedExhibitor>();

		try {
			
			if(eventId.get(0)==0) 
			{
				
				if (locationId.get(0) == 0 && companyType.get(0) == 0) {
					sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository
							.sortedExhibitorByLocationAndCompanyType(orgId);
				} else if (locationId.get(0) == 0 && companyType.get(0) != 0) {
					sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository
							.sortedExhibitorByAllLocation(companyType,orgId);
				} else if (locationId.get(0) != 0 && companyType.get(0) == 0) {
					sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository
							.sortedExhibitorByAllCompanyType(locationId,orgId);
				} else {
					sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository.sortedExhibitorBy(
							locationId, companyType,orgId);
				}
				
			}
			else
			{
				
				if (locationId.get(0) == 0 && companyType.get(0) == 0) {
					sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository
							.sortedExhibitorByLocationAndCompanyType(eventId);
				} else if (locationId.get(0) == 0 && companyType.get(0) != 0) {
					sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository
							.sortedExhibitorByAllLocation(eventId, companyType);
				} else if (locationId.get(0) != 0 && companyType.get(0) == 0) {
					sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository
							.sortedExhibitorByAllCompanyType(eventId, locationId);
				} else {
					sortedExhibitorByLocationAndCompanyType = sortedExhibitorRepository.sortedExhibitorBy(eventId,
							locationId, companyType);
				}
				
			}

			

		} catch (Exception e) {

			e.printStackTrace();

		}
		return sortedExhibitorByLocationAndCompanyType;

	}

	@RequestMapping(value = { "/sortedExhibitorListByLocationAndCompType" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhibitorWithOrgName> sortedExhibitorListByLocationAndCompType(
			@RequestParam("locationId") List<Integer> locationId,
			@RequestParam("companyType") List<Integer> companyType) {

		List<ExhibitorWithOrgName> sortedExhibitorListByLocationAndCompType = new ArrayList<ExhibitorWithOrgName>();

		try {

			if (locationId.get(0) == 0 && companyType.get(0) == 0) {
				sortedExhibitorListByLocationAndCompType = ExhibitorWithOrgNameRepo
						.sortedExhibitorListByLocationAndCompType();
			} else if (locationId.get(0) == 0 && companyType.get(0) != 0) {
				sortedExhibitorListByLocationAndCompType = ExhibitorWithOrgNameRepo
						.sortedExhibitorByAllLocation(companyType);
			} else if (locationId.get(0) != 0 && companyType.get(0) == 0) {
				sortedExhibitorListByLocationAndCompType = ExhibitorWithOrgNameRepo
						.sortedExhibitorByAllCompanyType(locationId);
			}
			else {
				sortedExhibitorListByLocationAndCompType = ExhibitorWithOrgNameRepo
						.sortedExhibitorBySpecificCompanyTypeAndLocation(locationId,companyType);
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

			packageList = package1Repository.findByPkgTypeAndIsUsed(pkgType, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return packageList;

	}

	@RequestMapping(value = { "/eventListByMultipleOrgId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventWithOrgName> eventListByMultipleOrgId(
			@RequestParam("orgList") List<Integer> orgList) {

		List<EventWithOrgName> eventList = new ArrayList<EventWithOrgName>();

		try {

			if (orgList.get(0) == 0)
				eventList = eventWithOrgNameRepository.getAllEventsByIsUsed();
			else
				eventList = eventWithOrgNameRepository.eventListByMultipleOrgId(orgList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

	@RequestMapping(value = { "/visitorListFilterByLocationAndCompType" }, method = RequestMethod.POST)
	public @ResponseBody List<SortedVisitor> visitorListFilterByLocationAndCompType(
			@RequestParam("eventId") List<Integer> eventId, @RequestParam("locationId") List<Integer> locationId,
			@RequestParam("companyType") List<Integer> companyType, @RequestParam("next") int next) {

		List<SortedVisitor> visitorListFilterByLocationAndCompType = new ArrayList<SortedVisitor>();

		try {

			if (locationId.get(0) == 0 && companyType.get(0) != 0) {
				visitorListFilterByLocationAndCompType = sortedVisitorRepository.sortedVisitorByAllLocation(eventId,
						companyType, next);
			} else if (locationId.get(0) != 0 && companyType.get(0) == 0) {
				visitorListFilterByLocationAndCompType = sortedVisitorRepository.sortedVisitorByAllCompanyType(eventId,
						locationId, next);
			} else if (locationId.get(0) != 0 && companyType.get(0) != 0) {
				visitorListFilterByLocationAndCompType = sortedVisitorRepository
						.sortedVisitorByLocationAndCompanyType(eventId, companyType, locationId, next);
			} else {
				visitorListFilterByLocationAndCompType = sortedVisitorRepository
						.sortedVisitorByLocationAndCompanyType(eventId, next);
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

			getEventSheduleByEventId = getEventSheduleHeaderRepository.findByEventIdAndIsUsed(eventId, 1);

			for (int i = 0; i < getEventSheduleByEventId.size(); i++) {
				List<GetEventSheduleDetail> getEventSheduleDetailList = getEventSheduleDetailRepository
						.findByScheduleIdAndIsUsed(getEventSheduleByEventId.get(i).getScheduleId(), 1);
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
	public @ResponseBody List<EventExhMappingWithExhName> eventListByExhIdBetweenDate(@RequestParam("exhId") int exhId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<EventExhMappingWithExhName> eventList = new ArrayList<EventExhMappingWithExhName>();

		try {

			eventList = eventExhMappingWithExhNameRepo.eventListByExhIdBetweenDate(exhId, fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

	@RequestMapping(value = { "/visitorListByExhibitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<VisitorByExhiId> visitorListByExhibitorId(@RequestParam("exhId") int exhId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<VisitorByExhiId> visitorList = new ArrayList<VisitorByExhiId>();

		try {

			visitorList = visitorByExhiIdRepo.visitorListByExhibitorIdBetweenDate(exhId, fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitorList;

	}

	@RequestMapping(value = { "/enquiryBetweenDateByExhibitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryHeaderWithName> enquiryBetweenDateByExhibitorId(@RequestParam("exhId") int exhId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<EnquiryHeaderWithName> headerList = new ArrayList<EnquiryHeaderWithName>();

		try {

			headerList = enquiryHeaderWithNameRepo.enquiryBetweenDateByExhibitorId(exhId, fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/feedbackbetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<FeedbackTxn> feedbackbetweenDate(@RequestParam("exhId") int exhId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<FeedbackTxn> feedbackList = new ArrayList<FeedbackTxn>();

		try {

			feedbackList = feedbackTxnRepo.feedbackbetweenDate(exhId, fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return feedbackList;

	}

	@RequestMapping(value = { "/enquiryNotBetweenDateWithStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryHeaderWithName> enquiryNotBetweenDateWithStatus(@RequestParam("exhId") int exhId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") int status) {

		List<EnquiryHeaderWithName> headerList = new ArrayList<EnquiryHeaderWithName>();

		try {

			headerList = enquiryHeaderWithNameRepo.enquiryNotBetweenDateWithStatus(exhId, fromDate, toDate, status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/equiryListWithStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryHeaderWithName> equiryListWithStatus(@RequestParam("exhId") int exhId,
			@RequestParam("status") int status) {

		List<EnquiryHeaderWithName> equiryListWithStatus = new ArrayList<EnquiryHeaderWithName>();

		try {

			equiryListWithStatus = enquiryHeaderWithNameRepo.equiryListWithStatus(exhId, status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return equiryListWithStatus;

	}

	@RequestMapping(value = { "/saveTrackHeader" }, method = RequestMethod.POST)
	public @ResponseBody PostTrackHeader saveTrackHeader(@RequestBody PostTrackHeader postTrackHeader) {

		PostTrackHeader save = new PostTrackHeader();

		try {

			save = postTrackHeaderRepository.save(postTrackHeader);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}
	
	@RequestMapping(value = { "/saveTrackHeaderFromApp" }, method = RequestMethod.POST)
	public @ResponseBody PostTrackHeader saveTrackHeaderFromApp(@RequestBody PostTrackHeader postTrackHeader) {

		PostTrackHeader save = new PostTrackHeader();

		try {
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			postTrackHeader.setDate(sf.format(date));
			
			save = postTrackHeaderRepository.save(postTrackHeader);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}

	@RequestMapping(value = { "/saveTrackDetail" }, method = RequestMethod.POST)
	public @ResponseBody PostTrackDetail saveTrackDetail(@RequestBody PostTrackDetail postTrackDetail) {

		PostTrackDetail save = new PostTrackDetail();

		try {

			save = postTrackDetailRepository.save(postTrackDetail);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}

	@RequestMapping(value = { "/getTrackHeader" }, method = RequestMethod.POST)
	public @ResponseBody GetTrackHeader getTrackHeader(@RequestParam("empId") int empId) {

		GetTrackHeader getTrackHeader = new GetTrackHeader();

		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			getTrackHeader = getTrackHeaderRepository.getTrackHeaderByEmpId(empId, sf.format(date));

			if (getTrackHeader != null) {
				ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setError(false);
				errorMessage.setMessage("success");
				List<PostTrackDetail> postTrackDetailList = postTrackDetailRepository
						.findByTrackIdAndIsUsed(getTrackHeader.getTrackId(), 1);
				getTrackHeader.setPostTrackDetailList(postTrackDetailList);
				getTrackHeader.setErrorMessage(errorMessage);
			} else {
				ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage("not found");
				getTrackHeader = new GetTrackHeader();
				getTrackHeader.setErrorMessage(errorMessage);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getTrackHeader;

	}

	@RequestMapping(value = { "/getTrackHeaderBetDateAndByEmpId" }, method = RequestMethod.POST)
	public @ResponseBody GetTrackHeader getTrackHeaderBetDateAndByEmpId(@RequestParam("empId") int empId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		GetTrackHeader getTrackHeader = new GetTrackHeader();

		try {
			
			getTrackHeader = getTrackHeaderRepository.getTrackHeaderBetDateAndByEmpId(empId, fromDate,toDate);

			if (getTrackHeader != null) {
				ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setError(false);
				errorMessage.setMessage("success");
				List<PostTrackDetail> postTrackDetailList = postTrackDetailRepository
						.findByTrackIdAndIsUsed(getTrackHeader.getTrackId(), 1);
				getTrackHeader.setPostTrackDetailList(postTrackDetailList);
				getTrackHeader.setErrorMessage(errorMessage);
			} else {
				ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage("not found");
				getTrackHeader = new GetTrackHeader();
				getTrackHeader.setErrorMessage(errorMessage);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getTrackHeader;

	}

	@RequestMapping(value = { "/getTrackDetailByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody List<PostTrackDetail> getTrackDetailByHeaderId(@RequestParam("trackId") int trackId) {

		List<PostTrackDetail> getTrackDetailByHeaderId = new ArrayList<PostTrackDetail>();

		try {

			getTrackDetailByHeaderId = postTrackDetailRepository.findByTrackIdAndIsUsed(trackId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getTrackDetailByHeaderId;

	}

	@RequestMapping(value = { "/getTotalKmOfEmpByExhiId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTrackHeader> getTotalKmOfEmpByExhiId(@RequestParam("exhiId") int exhiId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetTrackHeader> getTotalKmOfEmpByExhiId = new ArrayList<GetTrackHeader>();

		try {

			getTotalKmOfEmpByExhiId = getTrackHeaderRepository.getTotalKmOfEmpByExhiId(exhiId, fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getTotalKmOfEmpByExhiId;

	}

	@RequestMapping(value = { "/trakingHistoryBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTrackHeader> trakingHistoryBetweenDate(@RequestParam("exhiId") int exhiId,
			@RequestParam("empId") int empId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetTrackHeader> trakingHistoryBetweenDate = new ArrayList<GetTrackHeader>();

		try {

			if (empId == 0)
				trakingHistoryBetweenDate = getTrackHeaderRepository.trakingHistoryBetweenDate(exhiId, fromDate,
						toDate);
			else
				trakingHistoryBetweenDate = getTrackHeaderRepository.trakingHistoryBetweenDate(empId, exhiId, fromDate,
						toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return trakingHistoryBetweenDate;

	}

	@RequestMapping(value = { "/getTrackHeaderAndDetailById" }, method = RequestMethod.POST)
	public @ResponseBody GetTrackHeader getTrackHeaderAndDetailById(@RequestParam("trackId") int trackId) {

		GetTrackHeader getTrackHeaderAndDetailById = new GetTrackHeader();

		try {

			getTrackHeaderAndDetailById = getTrackHeaderRepository.getTrackHeaderAndDetailById(trackId);

			if (getTrackHeaderAndDetailById != null) {
				ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setError(false);
				errorMessage.setMessage("success");
				List<PostTrackDetail> postTrackDetailList = postTrackDetailRepository.findByTrackIdAndIsUsed(trackId,
						1);
				getTrackHeaderAndDetailById.setPostTrackDetailList(postTrackDetailList);
				getTrackHeaderAndDetailById.setErrorMessage(errorMessage);
			} else {
				ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage("not found");
				getTrackHeaderAndDetailById = new GetTrackHeader();
				getTrackHeaderAndDetailById.setErrorMessage(errorMessage);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getTrackHeaderAndDetailById;

	}

	@RequestMapping(value = { "/getExhEventSubscriptionList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetExhEventSubscription> getExhEventSubscriptionList(@RequestParam("orgId") int orgId) {

		List<GetExhEventSubscription> equiryListWithStatus = new ArrayList<GetExhEventSubscription>();

		try {

			equiryListWithStatus = getExhEventSubRepository.getExhEventSubscriptionList(orgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return equiryListWithStatus;

	}

	
	@RequestMapping(value = { "/approveSubscription" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage approveSubscription(@RequestParam("exhEsubId") int exhEsubId) {

		ErrorMessage errorMessage = null;
		try {

			GetExhEventSubscription sub = getExhEventSubRepository.getExhEventSub(exhEsubId);
			ExhEventSubscription eventSub = new ExhEventSubscription();
			eventSub.setEventId(sub.getEventId());
			eventSub.setExhEsubId(exhEsubId);
			eventSub.setExhId(sub.getExhId());
			eventSub.setIsUsed(1);
			eventSub.setOrgId(sub.getOrgId());
			eventSub.setPaidAmt(sub.getPaidAmt());
			eventSub.setRemAmt(sub.getRemAmt());
			eventSub.setStallNo(sub.getStallNo());
			eventSub.setSubscriptionAmt(sub.getSubscriptionAmt());
			eventSub.setIsApproved(1);
			exhEventSubscriptionRepository.saveAndFlush(eventSub);

			EventExhMapping eventExhMapping = new EventExhMapping();
			eventExhMapping.setEventId(sub.getEventId());
			eventExhMapping.setEventName(sub.getEventName());
			eventExhMapping.setExhId(sub.getExhId());
			eventExhMapping.setStallNo(sub.getStallNo());
			eventExhMapping.setIsUsed(1);
			eventExhMapping.setMapId(0);

			EventExhMapping eEventExhMappingRes = eventExhMappingRepository.saveAndFlush(eventExhMapping);
			if (eEventExhMappingRes != null) {
				errorMessage = new ErrorMessage();
				errorMessage.setError(false);
				errorMessage.setMessage("Approved Successfully");
			} else {
				errorMessage = new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage(" Failed to Approve");

			}

		} catch (Exception e) {
			errorMessage = new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage(" Failed to Approve:Exc");

			e.printStackTrace();

		}
		return errorMessage;

	}

}
