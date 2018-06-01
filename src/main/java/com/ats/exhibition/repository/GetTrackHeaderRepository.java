package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.GetTrackHeader;

public interface GetTrackHeaderRepository extends JpaRepository<GetTrackHeader, Integer>{

	@Query(value = "select th.*,e.emp_name from t_emp_tracking_header th,m_exh_employee e where th.is_used=1 "
			+ "and th.emp_id = e.emp_id and th.emp_id=:empId and th.date=:date", nativeQuery = true)
	GetTrackHeader getTrackHeaderByEmpId(@Param("empId") int empId,@Param("date") String date);
	
	

}
