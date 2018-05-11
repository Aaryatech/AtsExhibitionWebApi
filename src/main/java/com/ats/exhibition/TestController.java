package com.ats.exhibition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.exhibition.model.EventExhMapping;
import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.LoginResponse;
import com.ats.exhibition.model.Organiser;
import com.ats.exhibition.repository.EventExhMappingRepository;
import com.ats.exhibition.repository.OrganiserRepository;

@RestController
public class TestController {

	@Autowired
	OrganiserRepository organiserRepository;
	
	@Autowired
	EventExhMappingRepository eventExhMappingRepository;

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


}
