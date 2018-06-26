	package com.ats.exhibition.repository.eventhistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.eventhistory.EventsWithSubStatus;

public interface EventsWithSubStatusRepo extends JpaRepository<EventsWithSubStatus, Integer> {
	
	@Query(value = 
			"SELECT " + 
			"        m_events.* ,m_event_sup.stall_size,m_event_sup.price_for_exh,m_event_sup.disc_per,m_event_sup.discounted_price," + 
			"        coalesce((SELECT\n" + 
			"            1 \n" + 
			"        FROM\n" + 
			"            m_events e \n" + 
			"        WHERE\n" + 
			"            EXISTS(SELECT\n" + 
			"                m.event_id \n" + 
			"            FROM\n" + 
			"                t_event_exh_mapping m \n" + 
			"            WHERE\n" + 
			"                m.event_id = e.event_id \n" + 
			"                and exh_id=:exhId" + 
			"                and e.event_id=m_events.event_id)),0)as sub_status ,\n" + 
			" coalesce((SELECT\n" + 
			"            1 \n" + 
			"        FROM\n" + 
			"             m_events e \n" + 
			"        WHERE\n" + 
			"            EXISTS(SELECT\n" + 
			"                s.event_id \n" + 
			"            FROM\n" + 
			"                t_exh_event_subscription s \n" + 
			"            WHERE\n" + 
			"                s.event_id = e.event_id \n" + 
			"                and exh_id=:exhId \n" + 
			"                and e.event_id=m_events.event_id and s.is_used=1 and s.is_approved=0 )),0) as applied_status \n" + 
			"    from\n" + 
			"        m_events, m_event_sup\n" + 
			"    where\n" + 
			"        m_events.is_used=1 and m_event_sup.event_id=m_events.event_id \n" + 
			"        AND   :toDay <= m_events.event_to_date\n" + 
			"", nativeQuery = true)
	List<EventsWithSubStatus> getAllEventsWithExhId(@Param("exhId") int exhId, @Param("toDay") String toDay);
	

}
