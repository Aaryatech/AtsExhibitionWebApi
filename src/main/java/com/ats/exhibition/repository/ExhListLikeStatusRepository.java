package com.ats.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.ExhListLikeStatus;

public interface ExhListLikeStatusRepository extends JpaRepository<ExhListLikeStatus, Integer> {

	@Query(value = "SELECT e.*, o.org_name,l.location_name,c.company_type_name,coalesce((SELECT ve.like_status FROM  t_visitor_exhibitor ve WHERE ve.visitor_id=:visitorId AND ve.event_id=:eventId AND ve.exhibitor_id=:exhId),0) as like_status FROM m_exhibitor e,m_organiser o,m_location l,m_company c  WHERE e.exh_id=:exhId and o.org_id=e.org_id and l.location_id=e.location_id and c.company_type_id = e.company_type_id", nativeQuery = true)
	ExhListLikeStatus getAllExhByIdAndLikeStatus(@Param("exhId") int exhId, @Param("eventId") int eventId,
			@Param("visitorId") int visitorId);

}
