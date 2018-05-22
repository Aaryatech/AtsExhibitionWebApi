package com.ats.exhibition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.exhibition.model.ComMemWithOrgName;
import com.ats.exhibition.model.CompanyType;
import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.EventExhMapping;
import com.ats.exhibition.model.EventExhMappingWithExhName;
import com.ats.exhibition.model.EventPhoto;
import com.ats.exhibition.model.EventPhotoWithEventName;
import com.ats.exhibition.model.EventProductsInterest;
import com.ats.exhibition.model.EventProductsInterestAllName;
import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.ExhEmpWithExhName;
import com.ats.exhibition.model.ExhEmployee;
import com.ats.exhibition.model.ExhMatWithExhName;
import com.ats.exhibition.model.ExhMaterial;
import com.ats.exhibition.model.ExhSubDetail;
import com.ats.exhibition.model.ExhSubDetailWithDate;
import com.ats.exhibition.model.ExhSubHeader;
import com.ats.exhibition.model.ExhSubHeaderWithExhName;
import com.ats.exhibition.model.Exhibitor;
import com.ats.exhibition.model.Location;
import com.ats.exhibition.model.LoginResponse;
import com.ats.exhibition.model.LoginResponseExh;
import com.ats.exhibition.model.MapEventEmp;
import com.ats.exhibition.model.MktMaterial;
import com.ats.exhibition.model.OrgSubscription;
import com.ats.exhibition.model.OrgSubscriptionDetail;
import com.ats.exhibition.model.OrgSubscriptionWithName;
import com.ats.exhibition.model.Organiser;
import com.ats.exhibition.model.Package1;
import com.ats.exhibition.model.Visitor;
import com.ats.exhibition.model.VisitorWithOrgEventName;
import com.ats.exhibition.repository.CompanyTypeRepository;
import com.ats.exhibition.repository.EventExhMappingRepository;
import com.ats.exhibition.repository.EventExhMappingWithExhNameRepo;
import com.ats.exhibition.repository.EventPhotoRepository;
import com.ats.exhibition.repository.EventPhotoWithEventNameRepo;
import com.ats.exhibition.repository.EventProductsInterestAllNameRepo;
import com.ats.exhibition.repository.EventProductsInterestRepository;
import com.ats.exhibition.repository.ExhEmpWithExhNameRepo;
import com.ats.exhibition.repository.ExhEmployeeRepository;
import com.ats.exhibition.repository.ExhMatWithExhNameRepo;
import com.ats.exhibition.repository.ExhMaterialRepository;
import com.ats.exhibition.repository.ExhSubDetailRepository;
import com.ats.exhibition.repository.ExhSubDetailWithDateRepo;
import com.ats.exhibition.repository.ExhSubHeaderRepository;
import com.ats.exhibition.repository.ExhSubHeaderWithExhNameRepo;
import com.ats.exhibition.repository.ExhibitorRepository;
import com.ats.exhibition.repository.LocationRepository;
import com.ats.exhibition.repository.MapEventEmpRepository;
import com.ats.exhibition.repository.MktMaterialRepository;
import com.ats.exhibition.repository.OrgSubscriptionDetailRepo;
import com.ats.exhibition.repository.OrgSubscriptionRepository;
import com.ats.exhibition.repository.OrgSubscriptionWithNameRepo;
import com.ats.exhibition.repository.OrganiserRepository;
import com.ats.exhibition.repository.Package1Repository;
import com.ats.exhibition.repository.VisitorRepository;
import com.ats.exhibition.repository.VisitorWithOrgEventNameRepo;

@RestController
public class TestController {

	@Autowired
	OrganiserRepository organiserRepository;

	@Autowired
	EventExhMappingRepository eventExhMappingRepository;

	@Autowired
	ExhEmployeeRepository exhEmployeeRepository;

	@Autowired
	ExhEmpWithExhNameRepo exhEmpWithExhNameRepo;

	@Autowired
	ExhMaterialRepository exhMaterialRepository;

	@Autowired
	ExhMatWithExhNameRepo exhMatWithExhNameRepo;

	@Autowired
	VisitorRepository visitorRepository;

	@Autowired
	VisitorWithOrgEventNameRepo visitorWithOrgEventNameRepo;

	@Autowired
	EventPhotoRepository eventPhotoRepository;

	@Autowired
	EventProductsInterestRepository eventProductsInterestRepository;

	@Autowired
	ExhSubHeaderWithExhNameRepo exhSubHeaderWithExhNameRepo;

	@Autowired
	ExhSubHeaderRepository exhSubHeaderRepository;

	@Autowired
	MapEventEmpRepository mapEventEmpRepository;

	@Autowired
	OrgSubscriptionDetailRepo orgSubscriptionDetailRepo;

	@Autowired
	ExhSubDetailRepository exhSubDetailRepository;

	@Autowired
	ExhSubDetailWithDateRepo exhSubDetailWithDateRepo;
	
	@Autowired
	EventPhotoWithEventNameRepo eventPhotoWithEventNameRepo;

	@Autowired
	EventProductsInterestAllNameRepo eventProductsInterestAllNameRepo;

	@Autowired
	ExhibitorRepository exhibitorRepository;

	@Autowired
	MktMaterialRepository mktMaterialRepository;

	@Autowired
	EventExhMappingWithExhNameRepo eventExhMappingWithExhNameRepo;
	
	@Autowired
	Package1Repository package1Repository;
	
	@Autowired
	OrgSubscriptionRepository orgSubscriptionRepository;
	

	@Autowired
	OrgSubscriptionWithNameRepo orgSubscriptionWithNameRepo;

	
	
	
	
	// ---------------------------OrganiserLogin---------------------------------------------
	@RequestMapping(value = { "/loginResponse" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponse loginResponse(@RequestParam("userMob") String userMob,
			@RequestParam("userPassword") String userPassword) {

		LoginResponse loginResponse = new LoginResponse();
		try {

			Organiser organiser = organiserRepository.findByUserMobAndUserPasswordAndIsUsed(userMob, userPassword, 1);
			if (organiser == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setOrganiser(organiser);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	// ---------------------------Exhibitor Login-----------------------------
	@RequestMapping(value = { "/loginExhibitor" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseExh loginExhibitor(@RequestParam("userMob") String userMob,
			@RequestParam("password") String password) {

		LoginResponseExh loginResponse = new LoginResponseExh();
		try {

			Exhibitor exhibitor = exhibitorRepository.findByUserMobAndPasswordAndIsUsed(userMob, password, 1);
			if (exhibitor == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setExhibitor(exhibitor);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	// ------------ -----------------Event Exh Mapping---------

	@RequestMapping(value = { "/saveEventExhMapping" }, method = RequestMethod.POST)
	public @ResponseBody List<EventExhMapping> saveEventExhMapping(@RequestBody List<EventExhMapping> EventExhMapping) {

		List<EventExhMapping> eventExhMapping = new ArrayList<EventExhMapping>();

		try {

	
			
			
			eventExhMapping = eventExhMappingRepository.saveAll(EventExhMapping);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventExhMapping;

	}

	@RequestMapping(value = { "/eventMappingListByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventExhMapping> eventMappingListByEventId(@RequestParam("eventId") int eventId) {

		List<EventExhMapping> eventMappingListByEventId = new ArrayList<EventExhMapping>();

		try {

			eventMappingListByEventId = eventExhMappingRepository.findByEventIdAndIsUsed(eventId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventMappingListByEventId;

	}

	@RequestMapping(value = { "/getAllExhMappingByMapIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody EventExhMappingWithExhName getAllExhMappingByMapIdAndIsUsed(@RequestParam("mapId") int mapId) {

		EventExhMappingWithExhName mapExh = new EventExhMappingWithExhName();

		try {

			mapExh = eventExhMappingWithExhNameRepo.getExhMappingEmpByMapId(mapId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mapExh;

	}

	@RequestMapping(value = { "/getAllExhMappingEmpByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<EventExhMappingWithExhName> getAllExhMappingEmpByIsUsed() {

		List<EventExhMappingWithExhName> eventList = new ArrayList<EventExhMappingWithExhName>();

		try {

			eventList = eventExhMappingWithExhNameRepo.getAllExhMappingEmpByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

	@RequestMapping(value = { "/deleteExhMapping" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteExhMapping(@RequestParam("mapId") int mapId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = eventExhMappingRepository.deleteExhMapping(mapId);

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
	// ------------ Exh Employee -----------------

	@RequestMapping(value = { "/saveExhEmployee" }, method = RequestMethod.POST)
	public @ResponseBody ExhEmployee saveExhEmployee(@RequestBody ExhEmployee ExhEmployee) {

		ExhEmployee exhEmployeeMapping = new ExhEmployee();

		try {

			exhEmployeeMapping = exhEmployeeRepository.saveAndFlush(ExhEmployee);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhEmployeeMapping;

	}

	@RequestMapping(value = { "/getAllEmployeeByEmpIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody ExhEmpWithExhName getAllEmployeeByEmpIdAndIsUsed(@RequestParam("empId") int empId) {

		ExhEmpWithExhName empList = new ExhEmpWithExhName();

		try {

			empList = exhEmpWithExhNameRepo.getAllEmployeeByEmpId(empId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return empList;

	}

	@RequestMapping(value = { "/getAllEmployeeIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhEmpWithExhName> getAllEmployeeIsUsed(@RequestParam("exhId") int exhId) {

		List<ExhEmpWithExhName> empList = new ArrayList<ExhEmpWithExhName>();

		try {

			empList = exhEmpWithExhNameRepo.getAllEmployeeByIsUsed(exhId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return empList;

	}

	@RequestMapping(value = { "/deleteExhEmployee" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteExhEmployee(@RequestParam("empId") int empId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = exhEmployeeRepository.deleteEmployee(empId);

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

	// ------------ Exh Material-----------------

	@RequestMapping(value = { "/saveExhMaterial" }, method = RequestMethod.POST)
	public @ResponseBody ExhMaterial saveExhMaterial(@RequestBody ExhMaterial ExhMaterial) {

		ExhMaterial exhMaterial = new ExhMaterial();

		try {

			exhMaterial = exhMaterialRepository.saveAndFlush(ExhMaterial);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhMaterial;

	}

	@RequestMapping(value = { "/getAllMatByTrIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody ExhMatWithExhName getAllMatByTrIdAndIsUsed(@RequestParam("trId") int trId) {

		ExhMatWithExhName materialList = new ExhMatWithExhName();

		try {

			materialList = exhMatWithExhNameRepo.getAllMaterialByTrId(trId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return materialList;

	}

	@RequestMapping(value = { "/getAllMaterialIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<ExhMatWithExhName> getAllMaterialIsUsed() {

		List<ExhMatWithExhName> materialList = new ArrayList<ExhMatWithExhName>();

		try {

			materialList = exhMatWithExhNameRepo.getAllMaterialByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return materialList;

	}
	
	//-----------------Portfolio-------------------------------------------------

	@RequestMapping(value = { "/getAllMaterialByExhIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhMatWithExhName> getAllMaterialByExhIdAndIsUsed(@RequestParam("exhId") int exhId) {

		List<ExhMatWithExhName> materialList = new ArrayList<ExhMatWithExhName>();

		try {

			materialList = exhMatWithExhNameRepo.getAllMaterialByExhIdAndIsUsed(exhId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return materialList;

	}

	@RequestMapping(value = { "/deleteExhMaterial" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteExhMaterial(@RequestParam("trId") int trId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = exhMaterialRepository.deleteMaterial(trId);

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

	// ------------ --------------------Visitor---------------

	@RequestMapping(value = { "/saveVisitor" }, method = RequestMethod.POST)
	public @ResponseBody Visitor saveVisitor(@RequestBody Visitor Visitor) {

		Visitor visitor = new Visitor();

		try {

			visitor = visitorRepository.saveAndFlush(Visitor);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitor;

	}

	@RequestMapping(value = { "/getVisitorByVisIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody VisitorWithOrgEventName getVisitorByVisIdAndIsUsed(@RequestParam("visitorId") int visitorId) {

		VisitorWithOrgEventName visitor = new VisitorWithOrgEventName();

		try {

			visitor = visitorWithOrgEventNameRepo.getVisitorByVisitorId(visitorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitor;

	}

	@RequestMapping(value = { "/getAllVisitorsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<VisitorWithOrgEventName> getAllVisitorsByIsUsed() {

		List<VisitorWithOrgEventName> visitorList = new ArrayList<VisitorWithOrgEventName>();

		try {

			visitorList = visitorWithOrgEventNameRepo.getAllVisitorsByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitorList;

	}

	@RequestMapping(value = { "/deleteVisitor" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteVisitor(@RequestParam("visitorId") int visitorId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = visitorRepository.deleteVisitor(visitorId);

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

	// ------------ -------------------Event Photo--------------

	@RequestMapping(value = { "/saveEventPhoto" }, method = RequestMethod.POST)
	public @ResponseBody EventPhoto saveEventPhoto(@RequestBody EventPhoto EventPhoto) {

		EventPhoto eventPhoto = new EventPhoto();

		try {

			eventPhoto = eventPhotoRepository.saveAndFlush(EventPhoto);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventPhoto;

	}

	@RequestMapping(value = { "/getAllEvnetsByPhotoId" }, method = RequestMethod.POST)
	public @ResponseBody EventPhotoWithEventName getAllEvnetsByPhotoId(@RequestParam("photoId") int photoId) {

		EventPhotoWithEventName eventPhoto = new EventPhotoWithEventName();

		try {

			eventPhoto = eventPhotoWithEventNameRepo.getAllEvnetsByPhotoId(photoId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventPhoto;

	}
	
	
	@RequestMapping(value = { "/getAllPhotoByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventPhotoWithEventName> getAllPhotoByEventId(@RequestParam("eventId") int eventId) {

		List<EventPhotoWithEventName> photoList = new ArrayList<EventPhotoWithEventName>();

		try {

			photoList = eventPhotoWithEventNameRepo.getAllPhotoByEventId(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return photoList;

	}

	@RequestMapping(value = { "/getAllPhotoByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<EventPhotoWithEventName> getAllPhotoByIsUsed() {

		List<EventPhotoWithEventName> photoList = new ArrayList<EventPhotoWithEventName>();

		try {

			photoList = eventPhotoWithEventNameRepo.getAllPhotoAndEventByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return photoList;

	}
	@RequestMapping(value = { "/getAllPhotoByOrgId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventPhotoWithEventName> getAllPhotoByOrgId(@Param("orgId") int orgId) {

		List<EventPhotoWithEventName> photoList = new ArrayList<EventPhotoWithEventName>();

		try {

			photoList = eventPhotoWithEventNameRepo.getAllPhotoByOrgId(orgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return photoList;

	}


	@RequestMapping(value = { "/deleteEventPhoto" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteEventPhoto(@RequestParam("photoId") int photoId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = eventPhotoRepository.deleteEventPhoto(photoId);

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

	// ------------ -------------------Event product Interest--------------

	@RequestMapping(value = { "/saveEventProductInterest" }, method = RequestMethod.POST)
	public @ResponseBody EventProductsInterest saveEventProductInterest(
			@RequestBody EventProductsInterest EventProductsInterest) {

		EventProductsInterest eventProductsInterest = new EventProductsInterest();

		try {

			eventProductsInterest = eventProductsInterestRepository.saveAndFlush(EventProductsInterest);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventProductsInterest;

	}

	@RequestMapping(value = { "/getAllProductInterestByTrId" }, method = RequestMethod.POST)
	public @ResponseBody EventProductsInterestAllName getAllProductInterestByTrId(@RequestParam("trId") int trId) {

		EventProductsInterestAllName eventProductInterest = new EventProductsInterestAllName();

		try {

			eventProductInterest = eventProductsInterestAllNameRepo.getProductInterestByTrId(trId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventProductInterest;

	}

	@RequestMapping(value = { "/getAllPrpductInterestByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<EventProductsInterestAllName> getAllPrpductInterestByIsUsed() {

		List<EventProductsInterestAllName> EventProductInterestList = new ArrayList<EventProductsInterestAllName>();

		try {

			EventProductInterestList = eventProductsInterestAllNameRepo.getProductInterestByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return EventProductInterestList;

	}

	@RequestMapping(value = { "/deleteEventProductsInterest" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteEventProductsInterest(@RequestParam("trId") int trId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = eventProductsInterestRepository.deleteEventProductsInterest(trId);

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

	// ------------Exhibitor Sub header ----------------

	@RequestMapping(value = { "/saveExhSubHeader" }, method = RequestMethod.POST)
	public @ResponseBody ExhSubHeader saveExhSubHeader(@RequestBody ExhSubHeader ExhSubHeader) {

		ExhSubHeader exhSubHeader = new ExhSubHeader();

		try {

			exhSubHeader = exhSubHeaderRepository.saveAndFlush(ExhSubHeader);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhSubHeader;

	}

	@RequestMapping(value = { "/getSubHeaderBySubIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody ExhSubHeaderWithExhName getSubHeaderBySubIdAndIsUsed(@RequestParam("subId") int subId) {

		ExhSubHeaderWithExhName exhSubHeaderWithExhName = new ExhSubHeaderWithExhName();

		try {

			exhSubHeaderWithExhName = exhSubHeaderWithExhNameRepo.getSubHeaderBySubIdAndIsUsed(subId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhSubHeaderWithExhName;

	}

	@RequestMapping(value = { "/getAllSubHeaderByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<ExhSubHeaderWithExhName> getAllSubHeaderByIsUsed() {

		List<ExhSubHeaderWithExhName> exhSubHeaderWithExhNameList = new ArrayList<ExhSubHeaderWithExhName>();

		try {

			exhSubHeaderWithExhNameList = exhSubHeaderWithExhNameRepo.getAllSubHeaderByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhSubHeaderWithExhNameList;

	}

	@RequestMapping(value = { "/deleteExhSubHeader" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteExhSubHeader(@RequestParam("subId") int subId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = exhSubHeaderRepository.deleteExhSubHeader(subId);

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

	// ------------Exhibitor Sub Details----------------

	@RequestMapping(value = { "/saveExhSubDetail" }, method = RequestMethod.POST)
	public @ResponseBody ExhSubDetail saveExhSubDetail(@RequestBody ExhSubDetail ExhSubDetail) {

		ExhSubDetail exhSubDetail = new ExhSubDetail();

		try {

			exhSubDetail = exhSubDetailRepository.saveAndFlush(ExhSubDetail);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhSubDetail;

	}

	@RequestMapping(value = { "/deleteExhSubDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteExhSubDetail(@RequestParam("subDetailId") int subDetailId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = exhSubDetailRepository.deleteExhSubDetail(subDetailId);

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

	// ------------ -------------------Map Event Emp ------------

	@RequestMapping(value = { "/saveMapEventEmp" }, method = RequestMethod.POST)
	public @ResponseBody MapEventEmp saveMapEventEmp(@RequestBody MapEventEmp MapEventEmp) {

		MapEventEmp mapEventEmp = new MapEventEmp();

		try {

			mapEventEmp = mapEventEmpRepository.saveAndFlush(MapEventEmp);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mapEventEmp;

	}

	@RequestMapping(value = { "/deleteMapEventEmp" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteMapEventEmp(@RequestParam("mapId") int mapId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = mapEventEmpRepository.deleteMapEventEmp(mapId);

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

	// ------------ -------------------Mkt Material-----------

	@RequestMapping(value = { "/saveMktMaterial" }, method = RequestMethod.POST)
	public @ResponseBody MktMaterial saveMktMaterial(@RequestBody MktMaterial MktMaterial) {

		MktMaterial mktMaterial = new MktMaterial();

		try {

			mktMaterial = mktMaterialRepository.saveAndFlush(MktMaterial);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mktMaterial;

	}

	@RequestMapping(value = { "/deleteMktMaterial" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteMktMaterial(@RequestParam("matId") int matId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = mktMaterialRepository.deleteMktMaterial(matId);

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

	// ------------ ------------------Org Subscription Details-----------

	@RequestMapping(value = { "/saveOrgSubscrptionDetails" }, method = RequestMethod.POST)
	public @ResponseBody OrgSubscriptionDetail saveOrgSubscrptionDetails(
			@RequestBody OrgSubscriptionDetail OrgSubscriptionDetail) {

		OrgSubscriptionDetail orgSubscriptionDetail = new OrgSubscriptionDetail();

		try {

			orgSubscriptionDetail = orgSubscriptionDetailRepo.saveAndFlush(OrgSubscriptionDetail);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orgSubscriptionDetail;

	}
	
	@RequestMapping(value = { "/getDetailsBySubIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<OrgSubscriptionDetail> getDetailsBySubIdAndIsUsed(@RequestParam("subId") int subId) {

		List<OrgSubscriptionDetail> orgSubscriptionDetail = new ArrayList<OrgSubscriptionDetail>();

		try {

			orgSubscriptionDetail = orgSubscriptionDetailRepo.findAllBySubIdAndIsUsed(subId,1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orgSubscriptionDetail;

	}


	@RequestMapping(value = { "/deleteOrgSubscriptionDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteOrgSubscriptionDetail(@RequestParam("orgSubDetailId") int orgSubDetailId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = orgSubscriptionDetailRepo.deleteOrgSubscriptionDetail(orgSubDetailId);

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
	
	
	
	// ------------ Package 1------------------------------



		@RequestMapping(value = { "/getPackageByPkgId" }, method = RequestMethod.POST)
		public @ResponseBody Package1 getPackageByPkgId(@RequestParam("pkgId") int pkgId) {

			Package1 package1 = new Package1();

			try {

				package1 = package1Repository.findByPkgId(pkgId);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return package1;

		}

		@RequestMapping(value = { "/getAllSubscriptions" }, method = RequestMethod.GET)
		public @ResponseBody List<OrgSubscriptionWithName> getAllSubscriptions() {

			List<OrgSubscriptionWithName> subscriptionList = new ArrayList<OrgSubscriptionWithName>();

			try {

				subscriptionList = orgSubscriptionWithNameRepo.getAllSubscriptions();

			} catch (Exception e) {

				e.printStackTrace();

			}
			return subscriptionList;

		}

		
		@RequestMapping(value = { "/getSubDetailsBySubIdAndIsUSed" }, method = RequestMethod.POST)
		public @ResponseBody OrgSubscriptionWithName getSubDetailsByOrgIdAndstatus(@RequestParam("subId") int subId) {

			OrgSubscriptionWithName orgSubscriptionWithName = new OrgSubscriptionWithName();

			try {

				orgSubscriptionWithName  = orgSubscriptionWithNameRepo.getSubscriptionById(subId);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return orgSubscriptionWithName;

		}
		
		//sachin
		@RequestMapping(value = { "/getEventsByExhbId" }, method = RequestMethod.POST)
		public @ResponseBody List<EventExhMapping> getEventsByExhbId(@RequestParam("exhbId") int exhbId) {

			List<EventExhMapping> eventListByExhbId = new ArrayList<EventExhMapping>();

			try {

				eventListByExhbId = eventExhMappingRepository.getAllEventByExhbId(exhbId);

			} catch (Exception e) {
				
				System.err.println("Exception in /getEventsByExhbId  @TestController" +e.getMessage());

				e.printStackTrace();

			}
			return eventListByExhbId;

		}
		@RequestMapping(value = { "/exhSubDetailBySubHeaderIdAndIsUsed" }, method = RequestMethod.POST)
		public @ResponseBody List<ExhSubDetailWithDate> exhSubDetailBySubHeaderIdAndIsUsed(@RequestParam("subHeaderId") int subHeaderId) {

			List<ExhSubDetailWithDate> exhSubDetailWithDateList = new ArrayList<ExhSubDetailWithDate>();

			try {

				exhSubDetailWithDateList = exhSubDetailWithDateRepo.findBySubHeaderIdAndIsUsed(subHeaderId, 1);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return exhSubDetailWithDateList;

		}

}
