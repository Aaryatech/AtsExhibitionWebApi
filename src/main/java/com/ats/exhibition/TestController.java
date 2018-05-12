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

import com.ats.exhibition.model.ComMemWithOrgName;
import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.EventExhMapping;
import com.ats.exhibition.model.EventPhoto;
import com.ats.exhibition.model.EventProductsInterest;
import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.ExhEmpWithExhName;
import com.ats.exhibition.model.ExhEmployee;
import com.ats.exhibition.model.ExhMatWithExhName;
import com.ats.exhibition.model.ExhMaterial;
import com.ats.exhibition.model.ExhSubHeader;
import com.ats.exhibition.model.ExhSubHeaderWithExhName;
import com.ats.exhibition.model.LoginResponse;
import com.ats.exhibition.model.Organiser;
import com.ats.exhibition.model.Visitor;
import com.ats.exhibition.model.VisitorWithOrgEventName;
import com.ats.exhibition.repository.EventExhMappingRepository;
import com.ats.exhibition.repository.EventPhotoRepository;
import com.ats.exhibition.repository.EventProductsInterestRepository;
import com.ats.exhibition.repository.ExhEmpWithExhNameRepo;
import com.ats.exhibition.repository.ExhEmployeeRepository;
import com.ats.exhibition.repository.ExhMatWithExhNameRepo;
import com.ats.exhibition.repository.ExhMaterialRepository;
import com.ats.exhibition.repository.ExhSubHeaderRepository;
import com.ats.exhibition.repository.ExhSubHeaderWithExhNameRepo;
import com.ats.exhibition.repository.OrganiserRepository;
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
	ExhSubHeaderRepository  exhSubHeaderRepository;
	

	// ------------------------------------------------------------------------
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

	// ------------Event Exh Mapping------------------

	@RequestMapping(value = { "/saveEventExhMapping" }, method = RequestMethod.POST)
	public @ResponseBody List<EventExhMapping> saveEventExhMapping(@RequestBody List<EventExhMapping> EventExhMapping) {

		List<EventExhMapping> eventExhMappingList = new ArrayList<EventExhMapping>();

		try {

			eventExhMappingList = eventExhMappingRepository.saveAll(EventExhMapping);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventExhMappingList;

	}
	
	@RequestMapping(value = { "/eventMappingListByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventExhMapping> eventMappingListByEventId(@RequestParam("eventId") int eventId) {

		List<EventExhMapping> eventMappingListByEventId = new ArrayList<EventExhMapping>();

		try {

			eventMappingListByEventId = eventExhMappingRepository.findByEventIdAndIsUsed(eventId,1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventMappingListByEventId;

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
	
	
	@RequestMapping(value = { "/getAllEmployeeIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<ExhEmpWithExhName> getAllEmployeeIsUsed() {


		List<ExhEmpWithExhName> empList = new ArrayList<ExhEmpWithExhName>();

		try {

			empList = exhEmpWithExhNameRepo.getAllEmployeeByIsUsed();

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
	
	
	/*@RequestMapping(value = { "/getEventPhotoByPhotoIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody VisitorWithOrgEventName getVisitorByVisIdAndIsUsed(@RequestParam("photoId") int photoId) {

		VisitorWithOrgEventName visitor = new VisitorWithOrgEventName();

		try {

			visitor = visitorWithOrgEventNameRepo.getVisitorByVisitorId(photoId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return visitor;

	}*/
	
	
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
		public @ResponseBody EventProductsInterest saveEventProductInterest(@RequestBody EventProductsInterest EventProductsInterest) {

			EventProductsInterest eventProductsInterest = new EventProductsInterest();

			try {

				eventProductsInterest = eventProductsInterestRepository.saveAndFlush(EventProductsInterest);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return eventProductsInterest;

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
		
		
		@RequestMapping(value = { "/getAllSubHeaderByIsUsed" }, method = RequestMethod.POST)
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
		
		


}
