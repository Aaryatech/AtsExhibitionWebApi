package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.GetEventSheduleDetail;

public interface GetEventSheduleDetailRepository extends JpaRepository<GetEventSheduleDetail, Integer>{
	
	@Query(value = "SELECT * from m_exh_schedule_detail where schedule_id=:scheduleId and is_used=:isUsed", nativeQuery = true)
	List<GetEventSheduleDetail> findByScheduleIdAndIsUsed(@Param("scheduleId") int scheduleId,@Param("isUsed") int isUsed);

}
