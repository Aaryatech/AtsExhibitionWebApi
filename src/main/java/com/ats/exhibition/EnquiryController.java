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

import com.ats.exhibition.model.EnquiryDetail;
import com.ats.exhibition.model.EnquiryHeader;
import com.ats.exhibition.model.EnquiryHeaderWithName;
import com.ats.exhibition.model.ErrorMessage;

import com.ats.exhibition.model.GetEnqList;
import com.ats.exhibition.model.Task;
import com.ats.exhibition.repository.EnquiryDetailRepository;
import com.ats.exhibition.repository.EnquiryHeaderRepository;
import com.ats.exhibition.repository.EnquiryHeaderWithNameRepo;
import com.ats.exhibition.repository.GetEnqListRepository;
import com.ats.exhibition.repository.TaskRepository;

@RestController
public class EnquiryController {

	@Autowired
	EnquiryHeaderRepository enquiryHeaderRepository;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	EnquiryDetailRepository enquiryDetailRepository;

	@Autowired
	EnquiryHeaderWithNameRepo enquiryHeaderWithNameRepo;

	@Autowired
	GetEnqListRepository getEnqListRepository;

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

	@RequestMapping(value = { "/getEnquiryByEnqId" }, method = RequestMethod.POST)
	public @ResponseBody EnquiryHeaderWithName getEnquiryByEnqId(@RequestParam("enqId") int enqId) {

		EnquiryHeaderWithName enquiryHeaderWithName = new EnquiryHeaderWithName();

		try {

			enquiryHeaderWithName = enquiryHeaderWithNameRepo.getEnquiryByEnqId(enqId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryHeaderWithName;

	}

	@RequestMapping(value = { "/getEnquiryList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEnqList> getEnquiryList(@RequestParam("empId") int empId,
			@RequestParam("exhId") int exhId, @RequestParam("date") String date) {

		List<GetEnqList> getEnqList = new ArrayList<GetEnqList>();

		try {

			getEnqList = getEnqListRepository.getEnquiryList(empId, exhId, date);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getEnqList;

	}

	@RequestMapping(value = { "/getAllEnquiryBetweenDates" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryHeaderWithName> getAllEnquiryBetweenDates(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<EnquiryHeaderWithName> enquiryHeaderWithNameList = new ArrayList<EnquiryHeaderWithName>();

		try {

			enquiryHeaderWithNameList = enquiryHeaderWithNameRepo.getAllEnquiryBetweenDates(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryHeaderWithNameList;

	}

	@RequestMapping(value = { "/getAllEnquiryByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<EnquiryHeaderWithName> getAllEnquiryByIsUsed() {

		List<EnquiryHeaderWithName> enquiryHeaderWithNameList = new ArrayList<EnquiryHeaderWithName>();

		try {

			enquiryHeaderWithNameList = enquiryHeaderWithNameRepo.getAllEnquiryByIsUsed();

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

	@RequestMapping(value = { "/deleteEnquiryDetail" }, method = RequestMethod.POST)
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

	@RequestMapping(value = { "/getEnquiryDetailByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<EnquiryDetail> getEnquiryDetailByIsUsed() {

		List<EnquiryDetail> enquiryDetailList = new ArrayList<EnquiryDetail>();

		try {

			enquiryDetailList = enquiryDetailRepository.getAllEnquiryDetailByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryDetailList;

	}

	@RequestMapping(value = { "/getAllEnquiryDetailByEnqId" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryDetail> getAllEnquiryDetailByEnqId(@RequestParam("enqId") int enqId) {

		List<EnquiryDetail> enquiryDetailList = new ArrayList<EnquiryDetail>();

		try {

			enquiryDetailList = enquiryDetailRepository.findByEnqId(enqId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryDetailList;

	}

	// ------------- exhibitor App --------------------------------

	@RequestMapping(value = { "/saveEnqHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody EnquiryHeader saveEnqHeaderAndDetail(@RequestBody EnquiryHeader EnquiryHeader) {

		EnquiryHeader enquiryHeader = new EnquiryHeader();
		EnquiryDetail enquiryDetail = new EnquiryDetail();

		try {

			enquiryHeader = enquiryHeaderRepository.saveAndFlush(EnquiryHeader);
			int enqId = enquiryHeader.getEnqId();
			enquiryDetail.setEnqId(enqId);

			for (int i = 0; i < EnquiryHeader.getEnquiryDetailList().size(); i++) {

				EnquiryHeader.getEnquiryDetailList().get(i).setEnqId(enqId);
				enquiryDetail = enquiryDetailRepository.saveAndFlush(EnquiryHeader.getEnquiryDetailList().get(i));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryHeader;

	}

	@RequestMapping(value = { "/getAllEnquiryDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<EnquiryDetail> getAllEnquiryDetailList(@RequestParam("enqId") int enqId,
			@RequestParam("empId") int empId) {

		List<EnquiryDetail> enquiryDetailList = new ArrayList<EnquiryDetail>();

		try {

			enquiryDetailList = enquiryDetailRepository.findByEnqIdAndEmpId(enqId, empId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryDetailList;

	}

	@RequestMapping(value = { "/addEnqFollowUp" }, method = RequestMethod.POST)
	public @ResponseBody EnquiryDetail addEnqFollowUp(@RequestBody EnquiryDetail enquiryDetail) {

		EnquiryDetail enquiryDetailRes = new EnquiryDetail();

		try {

			enquiryDetailRes = enquiryDetailRepository.saveAndFlush(enquiryDetail);

			EnquiryHeader enquiryHeader = enquiryHeaderRepository.findByEnqId(enquiryDetail.getEnqId());

			enquiryHeader.setNextMeetDate(enquiryDetailRes.getDate());
			enquiryHeader.setStatus(enquiryDetailRes.getStatus());

			enquiryHeader = enquiryHeaderRepository.saveAndFlush(enquiryHeader);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryDetail;

	}

	@RequestMapping(value = { "/getTaskListById" }, method = RequestMethod.POST)
	public @ResponseBody List<Task> getTaskListById(@RequestParam("empId") int empId, @RequestParam("exhId") int exhId,
			@RequestParam("date") String date) {

		List<Task> taskList = new ArrayList<Task>();

		try {

			taskList = taskRepository.findByEmpIdAndExhIdAndDate(empId, exhId, date);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taskList;

	}

	@RequestMapping(value = { "/currentDate" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage currentDate() {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date now = new Date();
			String strDate = originalFormat.format(now);
			errorMessage.setError(false);
			errorMessage.setMessage(strDate);

		} catch (Exception e) {
			errorMessage.setError(true);
			errorMessage.setMessage("Error");
			e.printStackTrace();

		}
		return errorMessage;
	}

}
