package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.EventProductsInterestAllName;

public interface EventProductsInterestAllNameRepo extends JpaRepository<EventProductsInterestAllName, Integer> {

	@Query(value = "SELECT i.*, e.event_name, v.visitor_name, x.exh_name, p.prod_name FROM t_event_products_interest i,m_events e,m_visitor v ,"
			+ "m_products p ,m_exhibitor x WHERE i.tr_id=:trId AND e.event_id=i.event_id AND "
			+ "v.visitor_id=i.visitor_id AND p.prod_id=i.prod_id AND x.exh_id=i.exh_id AND i.is_used=1", nativeQuery = true)
	EventProductsInterestAllName getProductInterestByTrId(@Param("trId") int trId);

	@Query(value = "SELECT i.*, e.event_name, v.visitor_name, x.exh_name, p.prod_name FROM t_event_products_interest i,m_events e,m_visitor v ,"
			+ "m_products p ,m_exhibitor x WHERE  e.event_id=i.event_id AND "
			+ "v.visitor_id=i.visitor_id AND p.prod_id=i.prod_id AND x.exh_id=i.exh_id AND i.is_used=1", nativeQuery = true)
	List<EventProductsInterestAllName> getProductInterestByIsUsed();

}
