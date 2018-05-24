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

import com.ats.exhibition.model.EnquiryDetail;
import com.ats.exhibition.model.EnquiryHeader;
import com.ats.exhibition.model.EnquiryHeaderWithName;
import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.EventWithOrgName;
import com.ats.exhibition.repository.EnquiryDetailRepository;
import com.ats.exhibition.repository.EnquiryHeaderRepository;
import com.ats.exhibition.repository.EnquiryHeaderWithNameRepo;

@RestController
public class EnquiryController {
	
	@Autowired
	EnquiryHeaderRepository enquiryHeaderRepository;
	
	@Autowired
	EnquiryDetailRepository enquiryDetailRepository;
	
	@Autowired
	EnquiryHeaderWithNameRepo enquiryHeaderWithNameRepo;
	
	

	// ----------Enquiry Header------------------

	@RequestMapping(value = { "/saveEnqHeader" }, method = RequestMethod.POST)
	public @ResponseBody EnquiryHeader saveEnqHeader(@RequestBody EnquiryHeader EnquiryHeader) {

		EnquiryHeader enquiryHeader = new EnquiryHeader();

		try {

			enquiryHeader = enquiryHeaderRepository.saveAndFlush(EnquiryHeader);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryHeader;

	}
	
	@RequestMapping(value = { "/getAllEnquiryByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryHeaderWithName> getAllEnquiryByEventId(@RequestParam("eventId") int eventId) {

		List<EnquiryHeaderWithName> enquiryHeaderWithNameList = new ArrayList<EnquiryHeaderWithName>();

		try {

			enquiryHeaderWithNameList = enquiryHeaderWithNameRepo.getAllEnquiryByEventId(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryHeaderWithNameList;

	}
	
	@RequestMapping(value = { "/getAllEnquiryByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<EnquiryHeaderWithName> getAllEnquiryByIsUsed() {

		List<EnquiryHeaderWithName> enquiryHeaderWithNameList = new ArrayList<EnquiryHeaderWithName>();

		try {

			enquiryHeaderWithNameList = enquiryHeaderWithNameRepo.getAllEnquiryByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryHeaderWithNameList;

	}

	
	
	@RequestMapping(value = { "/deleteEnquiryHeader" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteEnquiryHeader(@RequestParam("enqId") int enqId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = enquiryHeaderRepository.deleteEnquiryHeader(enqId);

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
	
	
	
	
	
	

	
	// ----------Enquiry Header------------------

		@RequestMapping(value = { "/saveEnqDetail" }, method = RequestMethod.POST)
		public @ResponseBody EnquiryDetail saveEnqDetail(@RequestBody EnquiryDetail EnquiryDetail) {

			EnquiryDetail enquiryDetail = new EnquiryDetail();

			try {

				enquiryDetail = enquiryDetailRepository.saveAndFlush(EnquiryDetail);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return enquiryDetail;

		}
		
		
		
		@RequestMapping(value = { "/deleteEnquiryDetail"}, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteEnquiryDetail(@RequestParam("enqDetailId") int enqDetailId) {

			ErrorMessage errorMessage = new ErrorMessage();

			try {
				int delete = enquiryDetailRepository.deleteEnquiryDetail(enqDetailId);

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

		
		
		@RequestMapping(value = { "/getAllEnquiryDetailByIsUsed" }, method = RequestMethod.GET)
		public @ResponseBody List<EnquiryDetail> getAllEnquiryDetailByIsUsed() {

			List<EnquiryDetail> enquiryDetailList = new ArrayList<EnquiryDetail>();

			try {

				enquiryDetailList = enquiryDetailRepository.getAllEnquiryDetailByIsUsed(1);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return enquiryDetailList;

		}



}
