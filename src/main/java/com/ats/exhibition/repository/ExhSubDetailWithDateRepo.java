package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.exhibition.model.ExhSubDetailWithDate;

public interface ExhSubDetailWithDateRepo extends JpaRepository<ExhSubDetailWithDate, Integer> {

	List<ExhSubDetailWithDate> findBySubHeaderIdAndIsUsed(int subHeaderId, int i);
	
}
