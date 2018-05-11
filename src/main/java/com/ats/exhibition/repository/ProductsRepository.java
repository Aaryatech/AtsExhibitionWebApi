package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

	List<Products> findByIsUsed(int isUsed);
	
	@Transactional
	@Modifying
	@Query("UPDATE Products SET isUsed=0  WHERE prod_id=:prodId")
	int deleteProducts(@Param("prodId") int prodId);

}
