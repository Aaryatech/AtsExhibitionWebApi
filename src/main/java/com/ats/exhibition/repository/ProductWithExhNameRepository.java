package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ComMemWithOrgName;
import com.ats.exhibition.model.ProductWithExhName;

public interface ProductWithExhNameRepository extends JpaRepository<ProductWithExhName, Integer>{

	
	@Query(value = "SELECT p.*, e.exh_name FROM t_products p,t_exhibitor e WHERE p.prod_id=1 AND e.exh_id=p.exh_id", nativeQuery = true)
	List<ProductWithExhName> getAllProductsByProdId(@Param("prodId") int prodId);
}
