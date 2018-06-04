package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.GetTrackHeader;

public interface GetTrackHeaderRepository extends JpaRepository<GetTrackHeader, Integer>{

	@Query(value = "select th.*,e.emp_name from t_emp_tracking_header th,m_exh_employee e where th.is_used=1 "
			+ "and th.emp_id = e.emp_id and th.emp_id=:empId and th.date=:date", nativeQuery = true)
	GetTrackHeader getTrackHeaderByEmpId(@Param("empId") int empId,@Param("date") String date);

	@Query(value = "select th.track_id , th.exhi_id , th.emp_id , th.date , th.loc_lat , th.loc_long , sum(th.total_km) as total_km, "
			+ "th.is_used , th.int1, e.emp_name from t_emp_tracking_header th, m_exh_employee e  where th.is_used=1 "
			+ "and th.exhi_id =:exhiId and th.emp_id = e.emp_id and th.date between :fromDate and :toDate group by th.emp_id", nativeQuery = true)
	List<GetTrackHeader> getTotalKmOfEmpByExhiId(@Param("exhiId") int exhiId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value = "select th.*, e.emp_name from t_emp_tracking_header th, m_exh_employee e where th.is_used=1 and th.exhi_id =:exhiId "
			+ "and th.exhi_id =e.exh_id and th.emp_id = e.emp_id and th.date between :fromDate and :toDate", nativeQuery = true)
	List<GetTrackHeader> trakingHistoryBetweenDate(@Param("exhiId")int exhiId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value = "select th.*, e.emp_name from t_emp_tracking_header th, m_exh_employee e where th.is_used=1 and th.exhi_id =:exhiId "
			+ "and th.emp_id =:empId and th.emp_id = e.emp_id and th.date between :fromDate and :toDate", nativeQuery = true)
	List<GetTrackHeader> trakingHistoryBetweenDate(@Param("empId")int empId, @Param("exhiId") int exhiId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	@Query(value = " select th.*, e.emp_name from t_emp_tracking_header th, m_exh_employee e where th.is_used=1  and th.emp_id = e.emp_id  and th.track_id=:trackId ", nativeQuery = true)
	GetTrackHeader getTrackHeaderAndDetailById(@Param("trackId") int trackId);
	
	

}
