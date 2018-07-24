package com.ats.exhibition;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.ats.exhibition.model.LoginResponseExhEmp;
import com.ats.exhibition.model.LoginResponseVisitor;
import com.ats.exhibition.model.MapEventEmp;
import com.ats.exhibition.model.MktMaterial;
import com.ats.exhibition.model.OrgSubscription;
import com.ats.exhibition.model.OrgSubscriptionDetail;
import com.ats.exhibition.model.OrgSubscriptionWithName;
import com.ats.exhibition.model.Organiser;
import com.ats.exhibition.model.Package1;
import com.ats.exhibition.model.ProductListWithCount;
import com.ats.exhibition.model.Visitor;
import com.ats.exhibition.model.VisitorExcelResponse;
import com.ats.exhibition.model.VisitorExhibitorMapping;
import com.ats.exhibition.model.VisitorMobileResponse;
import com.ats.exhibition.model.VisitorWithOrgEventName;
import com.ats.exhibition.model.eventhistory.EventsWithSubStatus;
import com.ats.exhibition.model.eventhistory.GetAllEventForExhb;
import com.ats.exhibition.model.eventhistory.ProductLikeByEvent;
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
import com.ats.exhibition.repository.ProductListWithCountRepo;
import com.ats.exhibition.repository.VisitorExhibitorMappingRepository;
import com.ats.exhibition.repository.VisitorRepository;
import com.ats.exhibition.repository.VisitorWithOrgEventNameRepo;
import com.ats.exhibition.repository.eventhistory.GetAllEventForExhbRepo;
import com.ats.exhibition.repository.eventhistory.ProductLikeByEventRepo;

import ch.qos.logback.core.net.SyslogOutputStream;

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
	
	@Autowired
	ProductListWithCountRepo productListWithCountRepo;
	
	@Autowired
	ProductLikeByEventRepo productLikeByEventRepo;

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

				List<ExhSubHeader> exhSubHeaderList = new ArrayList<ExhSubHeader>();

				try {
					Date date = new Date();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					exhSubHeaderList = exhSubHeaderRepository.getAllSubHeaderBetweenDates(exhibitor.getExhId(),
							sf.format(date));
					System.err.println("Ex Sub HEader List  " + exhSubHeaderList.toString());

					if (exhSubHeaderList.size() > 0) {

						loginResponse.setIsSubscribed(1);

						int empCount = exhSubHeaderList.get(0).getStatus();
						loginResponse.setNoOfEmpCanAdd(empCount);
						loginResponse.setExhSubHeader(exhSubHeaderList.get(0));

					} else {

						loginResponse.setIsSubscribed(0);
						loginResponse.setNoOfEmpCanAdd(0);

					}

					System.out.println("Login Exhb Web Service " + loginResponse.toString());
				}

				catch (Exception e) {

					System.err.println("Exception in /loginExhibitor @ TestController exb web api");
					e.printStackTrace();

				}
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
	public @ResponseBody List<EventExhMapping> saveEventExhMapping(
			@RequestBody List<EventExhMapping> eventExhMappingList) {

		List<EventExhMapping> eventExhMapping = new ArrayList<EventExhMapping>();

		try {
			for (int i = 0; i < eventExhMappingList.size(); i++) {
				EventExhMapping eventExhMappingRes = eventExhMappingRepository.findByEventIdAndExhIdAndIsUsed(
						eventExhMappingList.get(i).getEventId(), eventExhMappingList.get(i).getExhId(), 1);
				if (eventExhMappingRes == null) {
					EventExhMapping eventExhMappingBean = eventExhMappingRepository
							.saveAndFlush(eventExhMappingList.get(i));
					eventExhMapping.add(eventExhMappingBean);
				}
			}

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

	@RequestMapping(value = { "/eventMappingListByExhibitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventExhMapping> eventMappingListByExhibitorId(@RequestParam("exhiId") int exhiId) {

		List<EventExhMapping> eventMappingListByEventId = new ArrayList<EventExhMapping>();

		try {

			eventMappingListByEventId = eventExhMappingRepository.eventMappingListByExhibitorId(exhiId);

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

			// ExhSubHeader
			// header=exhSubHeaderRepository.findByExhId(ExhEmployee.getExhId());

			// List<ExhEmployee>
			// empList=exhEmployeeRepository.findByExhIdAndIsUsed(ExhEmployee.getExhId(),1);

			// if(header.getStatus()<empList.size()) {

			exhEmployeeMapping = exhEmployeeRepository.saveAndFlush(ExhEmployee);
			// }
			// else {

			// System.err.println("Can not save Employee Your Limit Exceed");

			// }

		} catch (Exception e) {

			e.printStackTrace();

		}

		return exhEmployeeMapping;

	}

	@RequestMapping(value = { "/isMobileNoExist" }, method = RequestMethod.POST)
	public @ResponseBody Integer isMobileNoExist(@RequestParam("mobileNo") String mobileNo,
			@RequestParam("callService") int callService) {
		Integer response = 0;
		try {

			if (callService == 1) {

				// Employee Mob No checking Service

				ExhEmployee aexhEmployeeMapping = new ExhEmployee();

				aexhEmployeeMapping = exhEmployeeRepository.findByEmpMobile(mobileNo);
				if (aexhEmployeeMapping == null) {
					System.err.println(" ExhEmployee Null Records So it is New Mobile u can Register");
					response = 1;
				} else {
					System.err.println(" ExhEmployee Records For this Mobile found  u can not  Register");
				}

			}

			if (callService == 2) {

				// Visitor Mob No checking Service
				Visitor vis = visitorRepository.findByVisitorMobile(mobileNo);

				if (vis == null) {
					System.err.println(" Visitor Null Records So it is New Mobile u can Register");
					response = 1;
				} else {
					System.err.println(" Visitor Records For this Mobile found  u can not  Register");
				}

			}

			if (callService == 3) {

				// Exhibitor Mob No checking Service
				// exhibitorRepository

				Exhibitor exhi = exhibitorRepository.findByUserMob(mobileNo);
				if (exhi == null) {
					System.err.println("Exhibitor Null Records So it is New Mobile u can Register");
					response = 1;
				} else {
					System.err.println("Exhibitor Records For this Mobile found  u can not  Register");
				}

			}

		} catch (Exception e) {

			System.err.println("Exception in /isMobileNoExist @TestController  " + e.getMessage());

			e.printStackTrace();

		}
		System.err.println("/isMobileNoExist web Service called.");

		return response;

	}

	// ------------------------Exhibitor Login------------------------------
	@RequestMapping(value = { "/loginEmpExhibitor" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseExhEmp loginEmpExhibitor(@RequestParam("empMobile") String empMobile,
			@RequestParam("password") String password) {

		LoginResponseExhEmp loginResponse = new LoginResponseExhEmp();
		try {

			ExhEmployee exhEmployee = exhEmployeeRepository.findByEmpMobileAndPasswordAndIsUsed(empMobile, password, 1);
			if (exhEmployee == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setExhEmployee(exhEmployee);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	@RequestMapping(value = { "/updateEmpExhToken" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseExhEmp updateEmpExhToken(@RequestParam("empId") int empId,
			@RequestParam("token") String token) {

		ExhEmployee exhEmployee = exhEmployeeRepository.findByEmpId(empId);

		LoginResponseExhEmp loginResponse = new LoginResponseExhEmp();

		if (exhEmployee == null) {
			exhEmployee = new ExhEmployee();
			loginResponse.setExhEmployee(exhEmployee);

			loginResponse.setError(true);
			loginResponse.setMsg("Invalid ID ");

		} else {

			loginResponse.setExhEmployee(exhEmployee);
			loginResponse.setError(false);
			loginResponse.setMsg("Update Token Successfully");

			int isUpdated = exhEmployeeRepository.updateToken(exhEmployee.getEmpId(), token);

		}

		return loginResponse;
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

	// -----------------Portfolio-------------------------------------------------

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
	@Autowired
	VisitorExhibitorMappingRepository visitorExhibitorMappingRepository;

	
	@RequestMapping(value = { "/saveVisitorList" }, method = RequestMethod.POST)
	public @ResponseBody VisitorExcelResponse saveVisitorList(@RequestBody List<Visitor> visList) {
		
		ErrorMessage erMsg=new ErrorMessage();
		VisitorExcelResponse visExcelRes=new VisitorExcelResponse();
		
		Visitor visitor = new Visitor();
		
		List<Visitor> addedVis=new ArrayList<Visitor>();
		
		List<Visitor> dupMobNoVis=new ArrayList<Visitor>();;
		try {

			for(int i=0;i<visList.size();i++) {

				Visitor vis = visitorRepository.findByVisitorMobile(visList.get(i).getVisitorMobile());

				if (vis == null) {
					
					System.err.println(" Visitor Null Records So it is New Mobile u can Register");
					visitor = visitorRepository.saveAndFlush(visList.get(i));
					addedVis.add(visitor);
					
					
				} else {
					
					System.err.println(" Visitor Records For this Mobile found  u can not  Register");
					
					dupMobNoVis.add(visList.get(i));
					
				}
				
				System.err.println("Visitor/ saveVisitorList Response " +visitor.toString());
			}

			visExcelRes.setAddedVis(addedVis);
			visExcelRes.setDupMobNoVis(dupMobNoVis);
			
			System.err.println("Visitor Excel Response " +visExcelRes.toString());
			
		} catch (Exception e) {
			
			System.err.println("Exception in /saveVisitorList @TestCont web api");

			e.printStackTrace();

		}
		return visExcelRes;

	}
	
	
	

	@RequestMapping(value = { "/getEmpByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<Visitor> getEmpByEventId(@RequestParam("eventId") int eventId) {

		List<Visitor> visitor = new ArrayList<Visitor>();

		try {

			visitor = visitorRepository.findByEventIdAndIsUsed(eventId, 1);

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

	@RequestMapping(value = { "/addNewVisitor" }, method = RequestMethod.POST)
	public @ResponseBody VisitorMobileResponse addNewVisitor(@RequestParam("visitorName") String visitorName,
			@RequestParam("visitorMobile") String visitorMobile, @RequestParam("visitorEmail") String visitorEmail,
			@RequestParam("eventId") int eventId, @RequestParam("orgId") int orgId,
			@RequestParam("locationId") int locationId, @RequestParam("companyTypeId") int companyTypeId,
			@RequestParam("token") String token, @RequestParam("visitorRepresent") String visitorRepresent) {

		VisitorMobileResponse loginResponseVisitor = new VisitorMobileResponse();
		VisitorWithOrgEventName visitorWithOrgEventName = new VisitorWithOrgEventName();

		try {

			visitorWithOrgEventName = visitorWithOrgEventNameRepo.getVisitorByVisitorMobile(visitorMobile);

			if (visitorWithOrgEventName != null) {
				loginResponseVisitor.setError(true);
				loginResponseVisitor.setMsg("Mobile Number Already Exist");
			} else {
				loginResponseVisitor.setError(false);
				loginResponseVisitor.setMsg("Add Visitor  successfully");

				loginResponseVisitor.setVisitorWithOrgEventName(visitorWithOrgEventName);

				Visitor visitor = new Visitor();
				visitor.setCompanyTypeId(companyTypeId);
				visitor.setEventId(eventId);
				visitor.setIsActive(1);
				visitor.setIsUsed(1);
				visitor.setLocationId(locationId);
				visitor.setOrgId(orgId);
				visitor.setToken(token);
				visitor.setVisitorEmail(visitorEmail);
				visitor.setVisitorMobile(visitorMobile);
				visitor.setVisitorName(visitorName);
				visitor.setVisitorRepresent(visitorRepresent);

				Visitor visitorRes = visitorRepository.saveAndFlush(visitor);

				System.out.println("visitorRes" + visitorRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return loginResponseVisitor;

	}

	@RequestMapping(value = { "/getVisitorByVisNameAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody VisitorWithOrgEventName getVisitorByVisNameAndIsUsed(
			@RequestParam("visitorName") String visitorName) {

		VisitorWithOrgEventName visitor = new VisitorWithOrgEventName();

		try {

			visitor = visitorWithOrgEventNameRepo.getVisitorByVisitorName(visitorName);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitor;

	}

	@RequestMapping(value = { "/getVisitorByVisMobileAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody VisitorWithOrgEventName getVisitorByVisMobileAndIsUsed(
			@RequestParam("visitorMobile") String visitorMobile) {

		VisitorWithOrgEventName visitor = new VisitorWithOrgEventName();

		try {

			visitor = visitorWithOrgEventNameRepo.getVisitorByVisitorMobile(visitorMobile);

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

			orgSubscriptionDetail = orgSubscriptionDetailRepo.findAllBySubIdAndIsUsed(subId, 1);

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

			orgSubscriptionWithName = orgSubscriptionWithNameRepo.getSubscriptionById(subId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orgSubscriptionWithName;

	}

	// sachin
	@Autowired
	GetAllEventForExhbRepo getAllEventForExhbRepo;

	@RequestMapping(value = { "/getEventsByExhbId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAllEventForExhb> getEventsByExhbId(@RequestParam("exhbId") int exhbId) {

		List<GetAllEventForExhb> eventListByExhbId = new ArrayList<GetAllEventForExhb>();

		try {

			eventListByExhbId = getAllEventForExhbRepo.getAllEventsbyExhb(exhbId);

		} catch (Exception e) {

			System.err.println("Exception in /getEventsByExhbId  @TestController" + e.getMessage());

			e.printStackTrace();

		}
		return eventListByExhbId;

	}

	@RequestMapping(value = { "/exhSubDetailBySubHeaderIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhSubDetailWithDate> exhSubDetailBySubHeaderIdAndIsUsed(
			@RequestParam("subHeaderId") int subHeaderId) {

		List<ExhSubDetailWithDate> exhSubDetailWithDateList = new ArrayList<ExhSubDetailWithDate>();

		try {

			exhSubDetailWithDateList = exhSubDetailWithDateRepo.findBySubHeaderIdAndIsUsed(subHeaderId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhSubDetailWithDateList;

	}
	
	@RequestMapping(value = { "/productListByExhibitorId" }, method = RequestMethod.POST)
	public @ResponseBody List<ProductListWithCount> productListByExhibitorId(@RequestParam("exhiId") int exhiId, @RequestParam("eventId") int eventId) {

		List<ProductListWithCount> productListByExhibitorId = new ArrayList<ProductListWithCount>();

		try {

			productListByExhibitorId = productListWithCountRepo.productListByExhibitorId(exhiId, eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productListByExhibitorId;

	}
	
	@RequestMapping(value = { "/visitorLikesListByProductId" }, method = RequestMethod.POST)
	public @ResponseBody List<ProductLikeByEvent> visitorLikesListByProductId(@RequestParam("eventId") int eventId,@RequestParam("prodId") int prodId) {

		List<ProductLikeByEvent> prodVisitorNames = new ArrayList<>();
		
		try {
			
			 
			prodVisitorNames = productLikeByEventRepo.visitorLikesListByProductId(eventId, prodId);
			 
		} catch (Exception e) {
			 
			e.printStackTrace();

		}
		
		return prodVisitorNames;

	}

}
