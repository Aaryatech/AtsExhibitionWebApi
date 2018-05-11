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
import com.ats.exhibition.model.LoginResponse;
import com.ats.exhibition.model.Organiser;
import com.ats.exhibition.repository.EventExhMappingRepository;
import com.ats.exhibition.repository.ExhEmpWithExhNameRepo;
import com.ats.exhibition.repository.ExhEmployeeRepository;
import com.ats.exhibition.repository.OrganiserRepository;

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
	public @ResponseBody List<ExhEmpWithExhName> getAllEmployeeByEmpIdAndIsUsed(@RequestParam("empId") int empId) {

		List<ExhEmpWithExhName> empList = new ArrayList<ExhEmpWithExhName>();

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

}
