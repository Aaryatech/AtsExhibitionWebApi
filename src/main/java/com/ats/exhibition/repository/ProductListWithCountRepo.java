package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ProductListWithCount;

public interface ProductListWithCountRepo extends JpaRepository<ProductListWithCount, Integer>{

	@Query(value="select p.*, COALESCE((select count(*) from t_visitor_product vp where vp.exhibitor_id=p.exh_id "
			+ "and vp.product_id = p.prod_id and vp.like_status=1 and vp.event_id=:eventId ),0) as visit_count "
			+ "from m_products p where p.exh_id=:exhiId and p.is_used=1",nativeQuery=true)
	 List<ProductListWithCount> productListByExhibitorId(@Param("exhiId")int exhiId,@Param("eventId") int eventId);

}
