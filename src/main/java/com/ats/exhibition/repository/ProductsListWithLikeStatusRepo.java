package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ProductsListWithLikeStatus;

public interface ProductsListWithLikeStatusRepo extends JpaRepository<ProductsListWithLikeStatus, Integer> {

/*	@Query(value = "select p.*,vp.like_status from t_visitor_product vp,m_products p where vp.visitor_id=:visitorId AND vp.exhibitor_id=:exhibitorId AND vp.product_id=p.prod_id and p.is_used=1", nativeQuery = true)
	List<ProductsListWithLikeStatus> getAllProductListWithLikeStatus(@Param("exhibitorId") int exhibitorId,
			@Param("visitorId") int visitorId);
*/
	
/*	SELECT  p.*, COALESCE((  select t_visitor_product.like_status FROM t_visitor_product
			 WHERE t_visitor_product.product_id=p.prod_id and t_visitor_product.exhibitor_id=2),0) as like_status
			  FROM m_products p  WHERE p.exh_id=2  and p.is_used=1
			        GROUP by p.prod_id*/
			        
	
	@Query(value = " SELECT  p.*, COALESCE((SELECT t_visitor_product.like_status FROM t_visitor_product " + 
			" WHERE t_visitor_product.product_id=p.prod_id AND t_visitor_product.exhibitor_id=:exhibitorId AND t_visitor_product.visitor_id=:visitorId),0) AS like_status " + 
			" FROM m_products p  WHERE p.exh_id=:exhibitorId  AND p.is_used=1 " + 
			" ", nativeQuery = true)
	List<ProductsListWithLikeStatus> getAllProductListWithLikeStatus(@Param("exhibitorId") int exhibitorId,
			@Param("visitorId") int visitorId);
}
