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

import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.SpinQueDetail;
import com.ats.exhibition.model.SpinQueDetailWithName;
import com.ats.exhibition.model.SpinQueHeaderWithName;
import com.ats.exhibition.model.SpinQuestionHeader;
import com.ats.exhibition.repository.SpinQueDetailRepo;
import com.ats.exhibition.repository.SpinQueDetailWithNameRepo;
import com.ats.exhibition.repository.SpinQueHeaderRepo;
import com.ats.exhibition.repository.SpinQueHeaderWithNameRepo;

@RestController
public class SpinQuestionController {

	@Autowired
	SpinQueDetailRepo spinQueDetailRepo;

	@Autowired
	SpinQueHeaderRepo spinQueHeaderRepo;

	@Autowired
	SpinQueHeaderWithNameRepo spinQueHeaderWithNameRepo;
	
	@Autowired
	SpinQueDetailWithNameRepo spinQueDetailWithNameRepo;

	// ----------Spin Question Header------------------

	@RequestMapping(value = { "/saveSpinQueHeader" }, method = RequestMethod.POST)
	public @ResponseBody SpinQuestionHeader saveSpinQueHeader(@RequestBody SpinQuestionHeader SpinQuestionHeader) {

		SpinQuestionHeader spinQuestionHeader = new SpinQuestionHeader();

		try {

			spinQuestionHeader = spinQueHeaderRepo.saveAndFlush(SpinQuestionHeader);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQuestionHeader;

	}
	
	
	@RequestMapping(value = { "/getAllSpinQueHeaderByExhId" }, method = RequestMethod.POST)
	public @ResponseBody List<SpinQueHeaderWithName> getAllSpinQueHeaderByExhId(@RequestParam("exhId") int exhId) {

		List<SpinQueHeaderWithName> spinQueHeaderWithNameList = new ArrayList<SpinQueHeaderWithName>();

		try {

			spinQueHeaderWithNameList = spinQueHeaderWithNameRepo.findByExhId(exhId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueHeaderWithNameList;

	}
	

	@RequestMapping(value = { "/getAllSpinQueHeaderByQueId" }, method = RequestMethod.POST)
	public @ResponseBody SpinQueHeaderWithName getAllSpinQueHeaderByQueId(@RequestParam("queId") int queId) {

		SpinQueHeaderWithName spinQueHeaderWithName = new SpinQueHeaderWithName();

		try {

			spinQueHeaderWithName = spinQueHeaderWithNameRepo.findByQueId(queId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueHeaderWithName;

	}

	@RequestMapping(value = { "/getAllSpinQueHeaderByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<SpinQueHeaderWithName> getAllSpinQueHeaderByIsUsed() {

		List<SpinQueHeaderWithName> spinQueHeaderWithNameList = new ArrayList<SpinQueHeaderWithName>();

		try {

			spinQueHeaderWithNameList = spinQueHeaderWithNameRepo.findByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueHeaderWithNameList;

	}

	@RequestMapping(value = { "/deleteSpinQueHeader" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSpinQueHeader(@RequestParam("queId") int queId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = spinQueHeaderRepo.deleteSpinQueHeader(queId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Enquiry Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Enquiry Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Enquiry Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// ----------Spin Question Header------------------

	@RequestMapping(value = { "/saveSpinQueDetail" }, method = RequestMethod.POST)
	public @ResponseBody SpinQueDetail saveSpinQueDetail(@RequestBody SpinQueDetail SpinQueDetail) {

		SpinQueDetail spinQueDetail = new SpinQueDetail();

		try {

			spinQueDetail = spinQueDetailRepo.saveAndFlush(SpinQueDetail);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueDetail;

	}

	@RequestMapping(value = { "/deleteSpinQueDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSpinQueDetail(@RequestParam("tQueId") int tQueId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = spinQueDetailRepo.deleteSpinQueDetail(tQueId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Enquiry Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Enquiry Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Enquiry Deletion Failed :EXC");

		}
		return errorMessage;
	}
	
	@RequestMapping(value = { "/getAllSpinQueDetailByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<SpinQueDetailWithName> getAllSpinQueDetailByIsUsed() {

		List<SpinQueDetailWithName> spinQueDetailWithNameList = new ArrayList<SpinQueDetailWithName>();

		try {

			spinQueDetailWithNameList = spinQueDetailWithNameRepo.findByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueDetailWithNameList;

	}


}
