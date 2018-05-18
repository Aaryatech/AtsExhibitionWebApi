package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.exhibition.model.GetFloarMap;

@Repository
public interface GetFloarMapRepository extends JpaRepository<GetFloarMap, Integer>{

	@Query(value="select f.floar_map_id,f.event_id,e.event_name,f.floar_map1,f.floar_map2,f.floar_map3,f.floar_map4,f.is_used from m_event_floar_map f,m_events e where f.event_id=e.event_id and f.floar_map_id=:floarMapId",nativeQuery=true)
	GetFloarMap findFloarMapById(@Param("floarMapId")int floarMapId);

	@Query(value="select f.floar_map_id,f.event_id,e.event_name,f.floar_map1,f.floar_map2,f.floar_map3,f.floar_map4,f.is_used from m_event_floar_map f,m_events e where f.event_id=e.event_id and f.is_used=1 and f.event_id=:eventId",nativeQuery=true)
	List<GetFloarMap> findAllFloarMap(@Param("eventId")int eventId);

}
