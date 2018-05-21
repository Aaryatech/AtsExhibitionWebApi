package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.exhibition.model.GetSchedule;
@Repository
public interface GetScheduleHeaderRepository extends JpaRepository<GetSchedule, Integer>{

	@Query(value="select s.schedule_id,s.event_id,e.event_name,s.date,s.day_name,s.is_used from m_exh_schedule s,m_events e where e.event_id=s.event_id and s.is_used=1 and s.schedule_id=:scheduleId",nativeQuery=true)
	GetSchedule findByScheduleId(@Param("scheduleId")int scheduleId);

	@Query(value="select s.schedule_id,s.event_id,e.event_name,s.date,s.day_name,s.is_used from m_exh_schedule s,m_events e where e.event_id=s.event_id and s.is_used=1 and s.event_id In(select event_id from m_events where org_id=:orgId) and s.is_used=:isUsed",nativeQuery=true)
	List<GetSchedule> findByOrgId(@Param("orgId")int orgId,@Param("isUsed") int isUsed);

}
