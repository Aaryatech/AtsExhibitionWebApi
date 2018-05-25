package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ProductsListWithLikeStatus;

public interface ProductsListWithLikeStatusRepo extends JpaRepository<ProductsListWithLikeStatus, Integer> {

	@Query(value = "select p.*,vp.like_status from t_visitor_product vp,m_products p where vp.visitor_id=:visitorId AND vp.exhibitor_id=:exhibitorId AND vp.product_id=p.prod_id and p.is_used=1", nativeQuery = true)
	List<ProductsListWithLikeStatus> getAllProductListWithLikeStatus(@Param("exhibitorId") int exhibitorId,
			@Param("visitorId") int visitorId);

}
