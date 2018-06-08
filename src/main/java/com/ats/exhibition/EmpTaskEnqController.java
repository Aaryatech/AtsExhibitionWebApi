package com.ats.exhibition;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ats.exhibition.model.emptaskenq.GetEmpEnquiry;
import com.ats.exhibition.model.emptaskenq.GetEmpTask;
import com.ats.exhibition.repository.emptaskenq.GetEmpEnquiryRepo;
import com.ats.exhibition.repository.emptaskenq.GetEmpTaskRepo;

@RestController
public class EmpTaskEnqController {

	@Autowired
	GetEmpEnquiryRepo getEmpEnquiryRepo;

	@Autowired
	GetEmpTaskRepo getEmpTaskRepo;

	@RequestMapping(value = { "/getEmpEnquiry" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmpEnquiry> geetEmpEnquiry(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("empId") int empId,@RequestParam("exhbId") int exhbId) {

		List<GetEmpEnquiry> empEnqList = new ArrayList<GetEmpEnquiry>();

		try {

			if (empId == 0) {

				empEnqList = getEmpEnquiryRepo.getEmpEnquiryAllEmp(exhbId, fromDate, toDate);

				
			} else {
				empEnqList = getEmpEnquiryRepo.getEmpEnquiry(empId, fromDate, toDate);
			}

			System.err.println("empEnqList " + empEnqList.toString());

		} catch (Exception e) {

			System.err.println("Exception in /getEmpEnquiry @EmpTaskEnqController " + e.getMessage());
			e.printStackTrace();
		}

		return empEnqList;

	}

	@RequestMapping(value = { "/getEmpTask" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmpTask> getEmpTask(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("empId") int empId,@RequestParam("exhbId") int exhbId) {

		List<GetEmpTask> empTaskList = new ArrayList<GetEmpTask>();

		try {

			if (empId == 0) {
				
				empTaskList = getEmpTaskRepo.getEmpTaskAllEmp(exhbId, fromDate, toDate);
				
			} else {

				empTaskList = getEmpTaskRepo.getEmpTask(empId, fromDate, toDate);
			}
			
			System.err.println("empTaskList " + empTaskList.toString());

		} catch (Exception e) {

			System.err.println("Exception in /getEmpTask @EmpTaskEnqController " + e.getMessage());
			
			e.printStackTrace();
		}

		return empTaskList;

	}

}
