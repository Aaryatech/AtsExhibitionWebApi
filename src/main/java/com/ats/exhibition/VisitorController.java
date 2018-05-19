package com.ats.exhibition;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.exhibition.model.CompanyType;
import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.EventInfoWithAllName;
import com.ats.exhibition.model.EventListByVisId;
import com.ats.exhibition.model.EventVisitorMapping;
import com.ats.exhibition.model.EventWithOrgName;
import com.ats.exhibition.model.GetEventsList;
import com.ats.exhibition.model.Location;
import com.ats.exhibition.model.LoginResponseVisitor;
import com.ats.exhibition.model.Visitor;
import com.ats.exhibition.repository.CompanyTypeRepository;
import com.ats.exhibition.repository.EventExhMappingRepository;
import com.ats.exhibition.repository.EventInfoWithAllNameRepo;
import com.ats.exhibition.repository.EventListByVisIdRepo;
import com.ats.exhibition.repository.EventVisitorMappingRepository;
import com.ats.exhibition.repository.GetEventsListRepository;
import com.ats.exhibition.repository.LocationRepository;
import com.ats.exhibition.repository.VisitorRepository;

@RestController
public class VisitorController {

	@Autowired
	VisitorRepository visitorRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	CompanyTypeRepository companyTypeRepository;

	@Autowired
	EventVisitorMappingRepository eventVisitorMappingRepository;

	@Autowired
	GetEventsListRepository getEventsListRepository;

	@Autowired
	EventListByVisIdRepo eventListByVisIdRepo;

	@Autowired
	EventInfoWithAllNameRepo eventInfoWithAllNameRepo;

	@Autowired
	EventExhMappingRepository eventExhMappingRepository;

	@RequestMapping(value = { "/visitorLogin" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseVisitor findByVisitorMobile(@RequestParam("visitorMobile") String visitorMobile) {

		Visitor visitor = visitorRepository.findByVisitorMobile(visitorMobile);

		LoginResponseVisitor loginResponse = new LoginResponseVisitor();

		if (visitor == null) {
			visitor = new Visitor();
			loginResponse.setVisitor(visitor);

			loginResponse.setError(true);
			loginResponse.setMsg("Invalid Login Details ");

		} else {

			loginResponse.setVisitor(visitor);
			loginResponse.setError(false);
			loginResponse.setMsg("Login Successfully");

		}

		return loginResponse;
	}

	@RequestMapping(value = { "/updateVisitorToken" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseVisitor updateVisitorToken(@RequestParam("visitorId") int visitorId,
			@RequestParam("token") String token) {

		Visitor visitor = visitorRepository.findByVisitorId(visitorId);

		LoginResponseVisitor loginResponse = new LoginResponseVisitor();

		if (visitor == null) {
			visitor = new Visitor();
			loginResponse.setVisitor(visitor);

			loginResponse.setError(true);
			loginResponse.setMsg("Invalid ID ");

		} else {

			loginResponse.setVisitor(visitor);
			loginResponse.setError(false);
			loginResponse.setMsg("Update Token Successfully");

			int isUpdated = visitorRepository.updateToken(visitor.getVisitorId(), token);

		}

		return loginResponse;
	}

	// ------------ ----------------Location---------

	@RequestMapping(value = { "/saveLocation" }, method = RequestMethod.POST)
	public @ResponseBody Location saveLocation(@RequestBody Location Location) {

		Location location = new Location();

		try {

			location = locationRepository.saveAndFlush(Location);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return location;

	}

	@RequestMapping(value = { "/getAllLocationByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Location> getAllLocation() {

		List<Location> locationList = new ArrayList<Location>();

		try {

			locationList = locationRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return locationList;

	}

	@RequestMapping(value = { "/getLocationByLocIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody Location getLocationByLocIdAndIsUsed(@RequestParam("locationId") int locationId) {

		Location location = new Location();

		try {

			location = locationRepository.findByLocationIdAndIsUsed(locationId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return location;

	}

	@RequestMapping(value = { "/deleteLocation" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteLocation(@RequestParam("locationId") int locationId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = locationRepository.deleteLocation(locationId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;
	}

	// ------------ ---------------CompanyType --------

	@RequestMapping(value = { "/saveCompanyType" }, method = RequestMethod.POST)
	public @ResponseBody CompanyType saveCompanyType(@RequestBody CompanyType CompanyType) {

		CompanyType companyType = new CompanyType();

		try {

			companyType = companyTypeRepository.saveAndFlush(CompanyType);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return companyType;

	}

	@RequestMapping(value = { "/deleteCompanyType" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteCompanyType(@RequestParam("companyTypeId") int companyTypeId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = companyTypeRepository.deleteCompanyType(companyTypeId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getAllCompaniesByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<CompanyType> getAllCompaniesByIsUsed() {

		List<CompanyType> companyTypeList = new ArrayList<CompanyType>();

		try {

			companyTypeList = companyTypeRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return companyTypeList;

	}

	@RequestMapping(value = { "/getCompanyTypeByCompanyTypeIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody CompanyType getCompanyTypeByCompanyTypeIdAndIsUsed(
			@RequestParam("companyTypeId") int companyTypeId) {

		CompanyType companyType = new CompanyType();

		try {

			companyType = companyTypeRepository.findByCompanyTypeIdAndIsUsed(companyTypeId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return companyType;

	}

	@RequestMapping(value = { "/updateEventSubStatus" }, method = RequestMethod.POST)
	public @ResponseBody EventVisitorMapping updateEventSubStatus(@RequestParam("visitorId") int visitorId,
			@RequestParam("eventId") int eventId, @RequestParam("subscribeStatus") int subscribeStatus) {

		EventVisitorMapping eventVisitorMapping = eventVisitorMappingRepository.findByVisitorIdAndEventId(visitorId,
				eventId);

		int isUpdated = eventVisitorMappingRepository.updateStatus(eventVisitorMapping.getVisitorId(),
				eventVisitorMapping.getEventId(), subscribeStatus);

		return eventVisitorMapping;
	}

	@RequestMapping(value = { "/getEventsList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEventsList> getEventsList(
			@RequestParam("companyTypeIdList") List<Integer> companyTypeIdList,
			@RequestParam("locationIdList") List<Integer> locationIdList, @RequestParam("visitorId") int visitorId) {

		List<GetEventsList> getEventsList = new ArrayList<GetEventsList>();

		try {

			getEventsList = getEventsListRepository.getEventList(companyTypeIdList, locationIdList, visitorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getEventsList;

	}

	@RequestMapping(value = { "/getEventsListByVisitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventListByVisId> getEventsListByVisitorId(@RequestParam("visitorId") int visitorId) {

		List<EventListByVisId> getEventsList = new ArrayList<EventListByVisId>();

		try {

			getEventsList = eventListByVisIdRepo.getEventListByVisitorId(visitorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getEventsList;

	}

	// ---------------EventInfoBy EventId------------------------

	@RequestMapping(value = { "/getAllEventsInfoByEventId" }, method = RequestMethod.POST)
	public @ResponseBody EventInfoWithAllName getAllEventsInfoByEventId(@RequestParam("eventId") int eventId) {

		EventInfoWithAllName eventInfoWithAllName = new EventInfoWithAllName();

		try {

			eventInfoWithAllName = eventInfoWithAllNameRepo.getAllEventsInfoByEventId(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventInfoWithAllName;

	}

	@RequestMapping(value = { "/getExhCountByEventId" }, method = RequestMethod.POST)
	public @ResponseBody int getExhCountByEventId(@RequestParam("eventId") int eventId) {

		int totalExhibitorCount = 0;
		try {

			totalExhibitorCount = eventExhMappingRepository.totalCountOfExhId(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return totalExhibitorCount;

	}

}
