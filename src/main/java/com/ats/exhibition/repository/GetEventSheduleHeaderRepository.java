package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.GetEventSheduleHeader;

public interface GetEventSheduleHeaderRepository extends JpaRepository<GetEventSheduleHeader, Integer>{

	@Query(value = "SELECT * from m_exh_schedule where event_id=:eventId and is_used=:isUsed", nativeQuery = true)
	List<GetEventSheduleHeader> findByEventIdAndIsUsed(@Param("eventId") int eventId,@Param("isUsed") int isUsed);

}
