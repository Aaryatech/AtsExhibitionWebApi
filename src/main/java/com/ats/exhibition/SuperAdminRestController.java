package com.ats.exhibition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.exhibition.model.EventExhMapping;
import com.ats.exhibition.model.EventWithOrgName;
import com.ats.exhibition.model.ExhibitorWithOrgName;
import com.ats.exhibition.model.GetEventSheduleDetail;
import com.ats.exhibition.model.GetEventSheduleHeader;
import com.ats.exhibition.model.Package1;
import com.ats.exhibition.model.SortedExhibitor;
import com.ats.exhibition.model.SortedVisitor;
import com.ats.exhibition.repository.OrganiserRepository;
import com.ats.exhibition.repository.Package1Repository;
import com.ats.exhibition.repository.SortedExhibitorRepository;
import com.ats.exhibition.repository.SortedVisitorRepository;
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
	
	/*@RequestMapping(value = { "/getPackageById" }, method = RequestMethod.POST)
	public @ResponseBody Package1 getPackageById(@RequestParam("pkgId") int pkgId) {

		 Package1  package1 = new  Package1();

		try {

			package1 = package1Repository.findByPkgId(pkgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return package1;

	}*/

}
