package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.CompanyType;

public interface CompanyTypeRepository extends JpaRepository<CompanyType, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE CompanyType SET isUsed=0  WHERE company_type_id=:companyTypeId")
	int deleteCompanyType(@Param("companyTypeId") int companyTypeId);

	List<CompanyType> findAllByIsUsed(int i);

	CompanyType findByCompanyTypeIdAndIsUsed(int companyTypeId, int i);
	

}
