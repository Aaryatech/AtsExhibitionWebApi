package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.VisitorByExhiId;

public interface VisitorByExhiIdRepo extends JpaRepository<VisitorByExhiId, Integer>{

	@Query(value = " select \r\n" + 
			"    ve.*,\r\n" + 
			"    v.visitor_name,\r\n" + 
			"    e.event_name,\r\n" + 
			"    ex.exh_name\r\n" + 
			"    from\r\n" + 
			"    t_visitor_exhibitor ve,\r\n" + 
			"    m_events e,\r\n" + 
			"    m_visitor v,\r\n" + 
			"    m_exhibitor ex\r\n" + 
			"    where \r\n" + 
			"    ve.exhibitor_id=:exhId \r\n" + 
			"    and e.event_id = ve.event_id\r\n" + 
			"    and e.is_used = 1\r\n" + 
			"    and e.event_from_date between :fromDate and :toDate\r\n" + 
			"    and v.visitor_id = ve.visitor_id\r\n" + 
			"    and ex.exh_id = ve.exhibitor_id", nativeQuery = true)
	List<VisitorByExhiId> visitorListByExhibitorIdBetweenDate(@Param("exhId")int exhId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
