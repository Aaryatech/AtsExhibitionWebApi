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
import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.ExhEmpWithExhName;
import com.ats.exhibition.model.ExhEmployee;
import com.ats.exhibition.model.ExhMatWithExhName;
import com.ats.exhibition.model.ExhMaterial;
import com.ats.exhibition.model.LoginResponse;
import com.ats.exhibition.model.Organiser;
import com.ats.exhibition.model.Visitor;
import com.ats.exhibition.model.VisitorWithOrgEventName;
import com.ats.exhibition.repository.EventExhMappingRepository;
import com.ats.exhibition.repository.ExhEmpWithExhNameRepo;
import com.ats.exhibition.repository.ExhEmployeeRepository;
import com.ats.exhibition.repository.ExhMatWithExhNameRepo;
import com.ats.exhibition.repository.ExhMaterialRepository;
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
	public @ResponseBody EventExhMapping saveEventExhMapping(@RequestBody EventExhMapping EventExhMapping) {

		EventExhMapping eventExhMapping = new EventExhMapping();

		try {

			eventExhMapping = eventExhMappingRepository.saveAndFlush(EventExhMapping);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventExhMapping;

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

}
