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

import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.ExhSubHeader;

import com.ats.exhibition.model.ExhibitorWithOrgName;
import com.ats.exhibition.model.GetEventsList;
import com.ats.exhibition.model.GetExhibitorsList;

import com.ats.exhibition.model.Location;

import com.ats.exhibition.model.LoginResponseVisitor;
import com.ats.exhibition.model.ProductWithExhName;
import com.ats.exhibition.model.ProductsListWithLikeStatus;
import com.ats.exhibition.model.SponsorWithEventName;
import com.ats.exhibition.model.Visitor;
import com.ats.exhibition.model.VisitorExhibitorMapping;
import com.ats.exhibition.model.VisitorProductMapping;
import com.ats.exhibition.model.eventhistory.EventsWithSubStatus;
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
import com.ats.exhibition.repository.ProductsListWithLikeStatusRepo;
import com.ats.exhibition.repository.SponsorWithEventNameRepo;
import com.ats.exhibition.repository.VisitorExhibitorMappingRepository;
import com.ats.exhibition.repository.VisitorProductMappingRepo;
import com.ats.exhibition.repository.VisitorRepository;
import com.ats.exhibition.repository.eventhistory.EventsWithSubStatusRepo;

@RestController
public class VisitorController {

	@Autowired
	VisitorRepository visitorRepository;

	@Autowired
	ExhSubHeaderRepository exhSubHeaderRepository;

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

	@Autowired
	ProductsListWithLikeStatusRepo productsListWithLikeStatusRepo;

	@Autowired
	EventsWithSubStatusRepo getEventsWithSubStatusRepo;
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

		if (eventVisitorMapping != null) {
			int isUpdated = eventVisitorMappingRepository.updateStatus(eventVisitorMapping.getVisitorId(),
					eventVisitorMapping.getEventId(), subscribeStatus);
		} else {
			EventVisitorMapping eventVisitorMap = new EventVisitorMapping();
			eventVisitorMap.setEventId(eventId);
			eventVisitorMap.setVisitorId(visitorId);
			eventVisitorMap.setSubscribeStatus(subscribeStatus);

			eventVisitorMapping = eventVisitorMappingRepository.saveAndFlush(eventVisitorMap);
		}

		return eventVisitorMapping;
	}

	@RequestMapping(value = { "/getEventsList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEventsList> getEventsList(
			@RequestParam("companyTypeIdList") List<Integer> companyTypeIdList,
			@RequestParam("locationIdList") List<Integer> locationIdList, @RequestParam("visitorId") int visitorId,
			@RequestParam("isCompany") int isCompany, @RequestParam("isLocation") int isLocation) {

		List<GetEventsList> getEventsList = new ArrayList<GetEventsList>();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		try {
			String curDate=sf.format(date);

			if (isLocation == 0 && isCompany == 0) {

				getEventsList = getEventsListRepository.getEventList(visitorId,curDate);
			} else if (isLocation == 0 && isCompany == 1) {

				getEventsList = getEventsListRepository.getEventListWithAllLocationList(companyTypeIdList, visitorId,curDate);

			} else if (isLocation == 1 && isCompany == 0) {
				getEventsList = getEventsListRepository.getEventListWithAllCompanyList(locationIdList, visitorId,curDate);

			}

			else {
				getEventsList = getEventsListRepository.getEventListithAllLocationListAndCompanyList(companyTypeIdList,
						locationIdList, visitorId,curDate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getEventsList;

	}

	@RequestMapping(value = { "/getEventsListWithSub" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEventsList> getEventsListWithSub(
			@RequestParam("companyTypeIdList") List<Integer> companyTypeIdList,
			@RequestParam("locationIdList") List<Integer> locationIdList, @RequestParam("exhibitorId") int exhibitorId,
			@RequestParam("isCompany") int isCompany, @RequestParam("isLocation") int isLocation) {

		List<GetEventsList> getEventsList = new ArrayList<GetEventsList>();

		try {

			if (isLocation == 0 && isCompany == 0) {

				getEventsList = getEventsListRepository.getEventListWithSub(exhibitorId);
			} else if (isLocation == 0 && isCompany == 1) {

				getEventsList = getEventsListRepository.getEventListWithAllLocationListWithSub(companyTypeIdList,
						exhibitorId);

			} else if (isLocation == 1 && isCompany == 0) {
				getEventsList = getEventsListRepository.getEventListWithAllCompanyListWithSub(locationIdList,
						exhibitorId);

			}

			else {
				getEventsList = getEventsListRepository.getEventListithAllLocationListAndCompanyListWithSub(
						companyTypeIdList, locationIdList, exhibitorId);
			}

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
			@RequestParam("exhibitorId") int exhibitorId, @RequestParam("eventId") int eventId,
			@RequestParam("likeStatus") int likeStatus) {

		VisitorExhibitorMapping visitorExhibitorMapping = visitorExhibitorMappingRepository
				.findByVisitorIdAndExhibitorIdAndEventId(visitorId, exhibitorId, eventId);
		if (visitorExhibitorMapping != null) {
			int isUpdated = visitorExhibitorMappingRepository.updateStatus(visitorExhibitorMapping.getVisitorId(),
					visitorExhibitorMapping.getExhibitorId(), visitorExhibitorMapping.getEventId(), likeStatus);
		} else {
			VisitorExhibitorMapping ve = new VisitorExhibitorMapping();
			ve.setEventId(eventId);
			ve.setExhibitorId(exhibitorId);
			ve.setLikeStatus(likeStatus);
			ve.setVisitorId(visitorId);

			visitorExhibitorMapping = visitorExhibitorMappingRepository.saveAndFlush(ve);
		}

		return visitorExhibitorMapping;
	}

	// ---------------------------update Visitor Product like Status-----

	@RequestMapping(value = { "/updateProductLikeStatus" }, method = RequestMethod.POST)
	public @ResponseBody VisitorProductMapping updateProductLikeStatus(@RequestParam("visitorId") int visitorId,
			@RequestParam("exhibitorId") int exhibitorId,

			@RequestParam("productId") int productId, @RequestParam("eventId") int eventId,

			@RequestParam("likeStatus") int likeStatus) {
		VisitorProductMapping visitorProductMapping = new VisitorProductMapping();
		try {

			boolean isPrev = false;
			List<VisitorProductMapping> visitorProductMappingList = visitorProductMappingRepo
					.findByVisitorIdAndProductIdAndExhibitorId(visitorId, productId, exhibitorId);
			System.err.println("Visitor Prod List " + visitorProductMappingList.toString());

			if (!visitorProductMappingList.isEmpty()) {
				System.err.println("Visitor Prod List " + visitorProductMappingList.toString());

				visitorProductMapping = visitorProductMappingList.get(0);
				isPrev = true;

			}
			if (likeStatus == 1) {

				if (isPrev) {
					visitorProductMapping.setEventId(eventId);
					visitorProductMapping.setLikeStatus(1);

					visitorProductMapping = visitorProductMappingRepo.saveAndFlush(visitorProductMapping);

				} else {
					VisitorProductMapping visitorProduct = new VisitorProductMapping();
					visitorProduct.setExhibitorId(exhibitorId);
					visitorProduct.setEventId(eventId);
					visitorProduct.setProductId(productId);
					visitorProduct.setVisitorId(visitorId);
					visitorProduct.setLikeStatus(1);
					visitorProductMapping = visitorProductMappingRepo.saveAndFlush(visitorProduct);
				}
			} else {

				visitorProductMapping.setLikeStatus(0);

				visitorProductMapping = visitorProductMappingRepo.saveAndFlush(visitorProductMapping);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public @ResponseBody List<ExhSubHeader> getAllSubHeaderBetweenDates(@RequestParam("exhId") int exhId) {

		List<ExhSubHeader> exhSubHeaderList = new ArrayList<ExhSubHeader>();

		try {
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			exhSubHeaderList = exhSubHeaderRepository.getAllSubHeaderBetweenDates(exhId, sf.format(date));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhSubHeaderList;

	}
//Front End Home Page Event List web Service
	@RequestMapping(value = { "/getAllEventsWithExhId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventsWithSubStatus> getAllEventsWithExhId(@RequestParam("exhId") int exhId) {

		List<EventsWithSubStatus> eventsList = new ArrayList<EventsWithSubStatus>();

		try {
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			eventsList = getEventsWithSubStatusRepo.getAllEventsWithExhId(exhId, sf.format(date));

		} catch (Exception e) {

			System.err.println("Exception in getAllEventsWithExhId @Visitor controller" + e.getMessage());
			e.printStackTrace();

		}
		return eventsList;

	}

	@RequestMapping(value = { "/getAllProductListByVisIdAndExhId" }, method = RequestMethod.POST)
	public @ResponseBody List<ProductsListWithLikeStatus> getAllProductListByVisIdAndExhId(
			@RequestParam("exhibitorId") int exhibitorId, @RequestParam("visitorId") int visitorId) {

		List<ProductsListWithLikeStatus> productList = new ArrayList<ProductsListWithLikeStatus>();

		try {

			productList = productsListWithLikeStatusRepo.getAllProductListWithLikeStatus(exhibitorId, visitorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productList;

	}

	@RequestMapping(value = { "/getAllEventsWithVisitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<Events> getAllEventsWithVisitorId(@RequestParam("visitorId") int visitorId) {

		List<Events> eventList = new ArrayList<Events>();

		try {

			eventList = eventsRepository.getAllEventsWithVisitorId(visitorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

}
