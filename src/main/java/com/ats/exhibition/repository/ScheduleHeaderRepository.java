package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.ScheduleHeader;
@Repository
public interface ScheduleHeaderRepository extends JpaRepository<ScheduleHeader, Integer>
{

	@Transactional
	@Modifying
	@Query("UPDATE ScheduleHeader SET isUsed=0  WHERE scheduleId=:scheduleId")
	int deleteSchedule(@Param("scheduleId")int scheduleId);

	ScheduleHeader findByScheduleId(int scheduleId);

	List<ScheduleHeader> findByEventIdAndIsUsed(int eventId, int i);
                           
}
