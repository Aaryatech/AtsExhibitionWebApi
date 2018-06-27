package com.ats.exhibition.repository.eventhistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.eventhistory.ProductLikeByEvent;

public interface ProductLikeByEventRepo extends JpaRepository<ProductLikeByEvent, Integer> {
	
	@Query(value=" SELECT t_visitor_product.visitor_product_id,t_visitor_product.visitor_id, COUNT(t_visitor_product.like_status) AS like_status,"
			+ " m_visitor.visitor_name,m_visitor.visitor_email,m_visitor.visitor_mobile, m_location.location_name "
			+ "FROM m_visitor,t_visitor_product,m_location WHERE t_visitor_product.event_id=:eventId AND t_visitor_product.exhibitor_id=:exhbId "
			+ "AND t_visitor_product.visitor_id=m_visitor.visitor_id AND m_location.location_id=m_visitor.location_id AND t_visitor_product.like_status=1 " + 
			" GROUP BY t_visitor_product.visitor_id ORDER BY  t_visitor_product.visitor_product_id" + 
			" ",nativeQuery=true)
	List<ProductLikeByEvent> getProductLikeByEvent(@Param("eventId") int eventId, @Param("exhbId") int exhbId);
	
}
