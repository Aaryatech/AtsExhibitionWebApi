package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.exhibition.model.ScheduleDetail;
@Repository
public interface ScheduleDetailRepository extends JpaRepository<ScheduleDetail, Integer>{

	List<ScheduleDetail> findByScheduleIdAndIsUsed(int scheduleId, int i);

}
