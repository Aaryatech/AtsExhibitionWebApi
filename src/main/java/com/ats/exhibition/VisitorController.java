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

import com.ats.exhibition.model.CompanyType;
import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.EventInfoWithAllName;
import com.ats.exhibition.model.EventListByVisId;
import com.ats.exhibition.model.EventVisitorMapping;
import com.ats.exhibition.model.EventWithOrgName;
import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.ExhSubHeader;
import com.ats.exhibition.model.ExhSubHeaderWithExhName;
import com.ats.exhibition.model.Exhibitor;
import com.ats.exhibition.model.ExhibitorWithOrgName;
import com.ats.exhibition.model.GetEventsList;
import com.ats.exhibition.model.GetExhibitorsList;
import com.ats.exhibition.model.GetFloarMap;
import com.ats.exhibition.model.Location;
import com.ats.exhibition.model.LoginResponseExh;
import com.ats.exhibition.model.LoginResponseVisitor;
import com.ats.exhibition.model.ProductWithExhName;
import com.ats.exhibition.model.SponsorWithEventName;
import com.ats.exhibition.model.Visitor;
import com.ats.exhibition.model.VisitorExhibitorMapping;
import com.ats.exhibition.model.VisitorProductMapping;
import com.ats.exhibition.repository.CompanyTypeRepository;
import com.ats.exhibition.repository.EventExhMappingRepository;
import com.ats.exhibition.repository.EventInfoWithAllNameRepo;
import com.ats.exhibition.repository.EventListByVisIdRepo;
import com.ats.exhibition.repository.EventVisitorMappingRepository;
import com.ats.exhibition.repository.EventsRepository;
import com.ats.exhibition.repository.ExhSubHeaderRepository;
import com.ats.exhibition.repository.ExhSubHeaderWithExhNameRepo;
import com.ats.exhibition.repository.ExhibitorRepository;
import com.ats.exhibition.repository.ExhibitorWithOrgNameRepo;
import com.ats.exhibition.repository.GetEventsListRepository;
import com.ats.exhibition.repository.GetExhListRepository;
import com.ats.exhibition.repository.LocationRepository;
import com.ats.exhibition.repository.ProductWithExhNameRepository;
import com.ats.exhibition.repository.SponsorWithEventNameRepo;
import com.ats.exhibition.repository.VisitorExhibitorMappingRepository;
import com.ats.exhibition.repository.VisitorProductMappingRepo;
import com.ats.exhibition.repository.VisitorRepository;

@RestController
public class VisitorController {

	@Autowired
	VisitorRepository visitorRepository;

	@Autowired 
	ExhSubHeaderRepository  exhSubHeaderRepository;
	
	@Autowired
	GetExhListRepository getExhListRepository;
	
	@Autowired
	EventsRepository eventsRepository;
	
	
	@Autowired
	LocationRepository locationRepository;

	@Autowired
	ExhibitorRepository exhibitorRepository;

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

	@Autowired
	SponsorWithEventNameRepo sponsorWithEventNameRepo;

	@Autowired
	VisitorExhibitorMappingRepository visitorExhibitorMappingRepository;

	@Autowired
	VisitorProductMappingRepo visitorProductMappingRepo;

	@Autowired
	ExhibitorWithOrgNameRepo exhibitorWithOrgNameRepo;

	@Autowired
	ProductWithExhNameRepository productWithExhNameRepository;

	@Autowired
	ExhSubHeaderWithExhNameRepo exhSubHeaderWithExhNameRepo;

	// ---------------------Visitor Login----------------------

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

	@RequestMapping(value = { "/getAllSponsorByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<SponsorWithEventName> getAllSponsorByEventId(@RequestParam("eventId") int eventId) {

		List<SponsorWithEventName> sponsorWithEventName = null;
		try {
			sponsorWithEventName = sponsorWithEventNameRepo.getAllSponsorByEventId(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return sponsorWithEventName;

	}

	// ---------------------------update Exhibitor like Status----------------------
	@RequestMapping(value = { "/updateExhibitorLikeStatus" }, method = RequestMethod.POST)
	public @ResponseBody VisitorExhibitorMapping updateExhibitorLikeStatus(@RequestParam("visitorId") int visitorId,
			@RequestParam("exhibitorId") int exhibitorId, @RequestParam("likeStatus") int likeStatus) {

		VisitorExhibitorMapping visitorExhibitorMapping = visitorExhibitorMappingRepository
				.findByVisitorIdAndExhibitorId(visitorId, exhibitorId);

		int isUpdated = visitorExhibitorMappingRepository.updateStatus(visitorExhibitorMapping.getVisitorId(),
				visitorExhibitorMapping.getExhibitorId(), likeStatus);

		return visitorExhibitorMapping;
	}

	// ---------------------------update Visitor Product like
	// Status----------------------
	@RequestMapping(value = { "/updateProductLikeStatus" }, method = RequestMethod.POST)
	public @ResponseBody VisitorProductMapping updateProductLikeStatus(@RequestParam("visitorId") int visitorId,
			@RequestParam("productId") int productId, @RequestParam("likeStatus") int likeStatus) {

		VisitorProductMapping visitorProductMapping = visitorProductMappingRepo.findByVisitorIdAndProductId(visitorId,
				productId);

		int isUpdated = visitorProductMappingRepo.updateStatus(visitorProductMapping.getVisitorId(),
				visitorProductMapping.getProductId(), likeStatus);

		return visitorProductMapping;
	}

	// -----------------------------All Exhibitor list by Visitor Id--------------

	@RequestMapping(value = { "/getAllExhibitorsByVisitorIdAndLikeStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhibitorWithOrgName> getAllExhibitorsByVisitorIdAndLikeStatus(
			@RequestParam("visitorId") int visitorId) {

		List<ExhibitorWithOrgName> exhibitorList = new ArrayList<ExhibitorWithOrgName>();

		try {

			exhibitorList = exhibitorWithOrgNameRepo.getAllExhibitorsByVisitorIdAndLikeStatus(visitorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhibitorList;

	}

	@RequestMapping(value = { "/getAllProductListByVisId" }, method = RequestMethod.POST)
	public @ResponseBody List<ProductWithExhName> getAllProductListByVisId(@RequestParam("visitorId") int visitorId) {

		List<ProductWithExhName> productList = new ArrayList<ProductWithExhName>();

		try {

			productList = productWithExhNameRepository.getAllProductListByVisId(visitorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productList;

	}

	@RequestMapping(value = { "/getAllExhListByEventIdAndVisitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetExhibitorsList> getAllExhListByEventIdAndVisitorId(
			@RequestParam("visitorId") int visitorId, @RequestParam("eventId") int eventId,
			@RequestParam("companyTypeId") List<Integer> companyTypeId, @RequestParam("status") int status) {

		List<GetExhibitorsList> getExhibitorsList = new ArrayList<GetExhibitorsList>();

		try {
			if (status == 0) {

				getExhibitorsList = getExhListRepository.getAllExhListByEventIdAndVisitorId(eventId, visitorId);
			} else {
				getExhibitorsList = getExhListRepository.getExhListByEventIdAndVisIdAndcompanyTypeId(eventId, visitorId,
						companyTypeId);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getExhibitorsList;

	}

	@RequestMapping(value = { "/getAllSubHeaderBetweenDates" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhSubHeader> getAllSubHeaderBetweenDates(
			@RequestParam("exhId") int exhId) {

		List<ExhSubHeader> exhSubHeaderList = new ArrayList<ExhSubHeader>();

		try {
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			exhSubHeaderList = exhSubHeaderRepository.getAllSubHeaderBetweenDates(exhId,sf.format(date));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhSubHeaderList;

	}
	
	@RequestMapping(value = { "/getAllEventsWithExhId" }, method = RequestMethod.POST)
	public @ResponseBody List<Events> getAllEventsWithExhId(
			@RequestParam("exhId") int exhId) {

		List<Events> eventsList = new ArrayList<Events>();

		try {
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			eventsList = eventsRepository.getAllEventsWithExhId(exhId,sf.format(date));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventsList;

	}

}
