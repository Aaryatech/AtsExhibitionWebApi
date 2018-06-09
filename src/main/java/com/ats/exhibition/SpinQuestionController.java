
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

import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.SpinQueDetail;
import com.ats.exhibition.model.SpinQueDetailWithQue;
import com.ats.exhibition.model.SpinQueHeader;
import com.ats.exhibition.model.SpinQueHeaderWithName;
import com.ats.exhibition.model.SpinQueMasterWithName;
import com.ats.exhibition.model.SpinQuestionMaster;
import com.ats.exhibition.model.SpinWithVisitorInfo;
import com.ats.exhibition.repository.SpinQueDetailRepository;
import com.ats.exhibition.repository.SpinQueDetailWithQueRepo;
import com.ats.exhibition.repository.SpinQueHeaderRepo;
import com.ats.exhibition.repository.SpinQueHeaderWithNameRepo;
import com.ats.exhibition.repository.SpinQueMasterRepo;
import com.ats.exhibition.repository.SpinQueMasterWithNameRepo;
import com.ats.exhibition.repository.SpinWithVisitorInfoRepo;

@RestController
public class SpinQuestionController {

	@Autowired
	SpinQueHeaderRepo spinQueHeaderRepo;

	@Autowired
	SpinWithVisitorInfoRepo spinWithVisitorInfoRepo;

	@Autowired
	SpinQueMasterRepo spinQueMasterRepo;

	@Autowired
	SpinQueMasterWithNameRepo spinQueMasterWithNameRepo;

	@Autowired
	SpinQueHeaderWithNameRepo spinQueHeaderWithNameRepo;

	@Autowired
	SpinQueDetailRepository spinQueDetailRepository;

	@Autowired
	SpinQueDetailWithQueRepo spinQueDetailWithQueRepo;
	// ----------Spin Question Header------------------

	@RequestMapping(value = { "/saveSpinQueMaster" }, method = RequestMethod.POST)
	public @ResponseBody SpinQuestionMaster saveSpinQueMaster(@RequestBody SpinQuestionMaster SpinQuestion) {

		SpinQuestionMaster spinQuestion = new SpinQuestionMaster();

		try {

			spinQuestion = spinQueMasterRepo.saveAndFlush(SpinQuestion);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQuestion;

	}

	@RequestMapping(value = { "/getAllSpinQueByExhId" }, method = RequestMethod.POST)
	public @ResponseBody List<SpinQueMasterWithName> getAllSpinQueByExhId(@RequestParam("exhId") int exhId) {

		List<SpinQueMasterWithName> spinQueHeaderWithNameList = new ArrayList<SpinQueMasterWithName>();

		try {

			spinQueHeaderWithNameList = spinQueMasterWithNameRepo.findByExhId(exhId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueHeaderWithNameList;

	}

	@RequestMapping(value = { "/getAllSpinQueByQueId" }, method = RequestMethod.POST)
	public @ResponseBody SpinQueMasterWithName getAllSpinQueByQueId(@RequestParam("queId") int queId) {

		SpinQueMasterWithName spinQueHeaderWithName = new SpinQueMasterWithName();

		try {

			spinQueHeaderWithName = spinQueMasterWithNameRepo.findByQueId(queId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueHeaderWithName;

	}

	@RequestMapping(value = { "/getAllSpinQueByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<SpinQueMasterWithName> getAllSpinQueByIsUsed() {

		List<SpinQueMasterWithName> spinQueHeaderWithNameList = new ArrayList<SpinQueMasterWithName>();

		try {

			spinQueHeaderWithNameList = spinQueMasterWithNameRepo.findByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueHeaderWithNameList;

	}

	@RequestMapping(value = { "/deleteSpinQueMaster" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSpinQueMaster(@RequestParam("queId") int queId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = spinQueMasterRepo.deleteSpinQueMaster(queId);

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

	@RequestMapping(value = { "/saveSpinQueHeader" }, method = RequestMethod.POST)
	public @ResponseBody SpinQueHeader saveSpinQueHeader(@RequestBody SpinQueHeader SpinQueHeader) {

		SpinQueHeader spinQueHeader = new SpinQueHeader();

		try {

			spinQueHeader = spinQueHeaderRepo.saveAndFlush(SpinQueHeader);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueHeader;

	}

	@RequestMapping(value = { "/saveSpinQueResult" }, method = RequestMethod.POST)
	public @ResponseBody SpinQueHeader saveSpinQueResult(@RequestBody SpinQueHeader spinQueHeader) {

		SpinQueHeader spinQueHeaderRes = new SpinQueHeader();

		try {

			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDateTime = simpleDateFormat.format(simpleDateFormat);
			spinQueHeader.setDate(now);
			spinQueHeader.setDateTime(strDateTime);
			spinQueHeaderRes = spinQueHeaderRepo.saveAndFlush(spinQueHeader);

			for (int i = 0; i < spinQueHeaderRes.getSpinQueDetailList().size(); i++)
				spinQueHeaderRes.getSpinQueDetailList().get(i).settQueId(spinQueHeaderRes.gettQueId());

			List<SpinQueDetail> spinQueDetailList = spinQueDetailRepository
					.saveAll(spinQueHeaderRes.getSpinQueDetailList());
			System.out.println("spinQueDetailList" + spinQueDetailList.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueHeader;

	}

	@RequestMapping(value = { "/deleteSpinQueHeader" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSpinQueHeader(@RequestParam("tQueId") int tQueId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = spinQueHeaderRepo.deleteSpinQueHeader(tQueId);

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

	@RequestMapping(value = { "/getAllSpinQueHeaderByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<SpinQueHeaderWithName> getAllSpinQueHeaderByIsUsed() {

		List<SpinQueHeaderWithName> spinQueDetailWithNameList = new ArrayList<SpinQueHeaderWithName>();

		try {

			spinQueDetailWithNameList = spinQueHeaderWithNameRepo.findByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueDetailWithNameList;

	}

	@RequestMapping(value = { "/getAllQuestionsByTQueId" }, method = RequestMethod.POST)
	public @ResponseBody List<SpinQueDetailWithQue> getAllQuestionsBetweenDates(@RequestParam("tQueId") int tQueId) {

		List<SpinQueDetailWithQue> spinQueDetailWithQueList = new ArrayList<SpinQueDetailWithQue>();

		try {

			spinQueDetailWithQueList = spinQueDetailWithQueRepo.getAllQuestionsByTQueId(tQueId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueDetailWithQueList;

	}

	@RequestMapping(value = { "/getSpinQueWithVisitorInfoBetDates" }, method = RequestMethod.POST)
	public @ResponseBody List<SpinWithVisitorInfo> getSpinQueWithVisitorInfoBetDates(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SpinWithVisitorInfo> spinQueDetailWithNameList = new ArrayList<SpinWithVisitorInfo>();

		try {

			spinQueDetailWithNameList = spinWithVisitorInfoRepo.getSpinQueWithVisitorInfoBetDates(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueDetailWithNameList;

	}

	@RequestMapping(value = { "/getVisitorInfoByTQueId" }, method = RequestMethod.POST)
	public @ResponseBody SpinWithVisitorInfo getVisitorInfoByTQueId(@RequestParam("tQueId") int tQueId) {

		SpinWithVisitorInfo spinQueDetailWithNameList = new SpinWithVisitorInfo();

		try {

			spinQueDetailWithNameList = spinWithVisitorInfoRepo.getVisitorInfoByTQueId(tQueId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueDetailWithNameList;

	}

	// ----------Spin Question Header------------------

	@RequestMapping(value = { "/saveSpinQueDetail" }, method = RequestMethod.POST)
	public @ResponseBody SpinQueDetail saveSpinQueDetail(@RequestBody SpinQueDetail SpinQueDetail) {

		SpinQueDetail spinQuestion = new SpinQueDetail();

		try {

			spinQuestion = spinQueDetailRepository.saveAndFlush(SpinQueDetail);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQuestion;

	}

	@RequestMapping(value = { "/deleteSpinQueDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSpinQueDetail(@RequestParam("tQueDetailId") int tQueDetailId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = spinQueDetailRepository.deleteSpinQueDetail(tQueDetailId);

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
	public @ResponseBody List<SpinQueDetailWithQue> getAllSpinQueDetailByIsUsed() {

		List<SpinQueDetailWithQue> spinQueDetailWithQue = new ArrayList<SpinQueDetailWithQue>();

		try {

			spinQueDetailWithQue = spinQueDetailWithQueRepo.findByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return spinQueDetailWithQue;

	}
}
