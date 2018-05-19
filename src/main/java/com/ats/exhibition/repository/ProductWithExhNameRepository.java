package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ComMemWithOrgName;
import com.ats.exhibition.model.ProductWithExhName;

public interface ProductWithExhNameRepository extends JpaRepository<ProductWithExhName, Integer> {

	@Query(value = "SELECT p.*, e.exh_name FROM m_products p,m_exhibitor e WHERE p.prod_id=:prodId AND e.exh_id=p.exh_id", nativeQuery = true)
	ProductWithExhName getAllProductsByProdId(@Param("prodId") int prodId);

	@Query(value = "SELECT p.*, e.exh_name FROM m_products p,m_exhibitor e WHERE p.is_used=1 AND e.exh_id=p.exh_id", nativeQuery = true)
	List<ProductWithExhName> findByIsUsed(int isUsed);

	@Query(value = "SELECT p.*, e.exh_name FROM m_products p,m_exhibitor e WHERE p.is_used=1 AND e.exh_id=p.exh_id and e.exh_id=:exhId", nativeQuery = true)
	List<ProductWithExhName> findByExhId(@Param("exhId") int exhId);

	@Query(value = "SELECT p.prod_id,p.exh_id,p.prod_name,p.prod_desc,p.prod_specification,p.prod_experty,p.prod_image1,"
			+ "p.prod_image2,p.prod_image3 ,x.exh_name,p.is_used FROM m_products p ,m_exhibitor x   WHERE p.exh_id=x.exh_id AND "
			+ "p.is_used=1 AND p.prod_id IN(SELECT t_visitor_product.product_id FROM t_visitor_product WHERE"
			+ " t_visitor_product.visitor_id=:visitorId AND  t_visitor_product.like_status=1)", nativeQuery = true)
	List<ProductWithExhName> getAllProductListByVisId(@Param("visitorId") int visitorId);
}
