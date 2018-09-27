package com.ats.exhibition.repository;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.GetEventsList;

public interface GetEventsListRepository extends JpaRepository<GetEventsList, Integer> {

	@Query(value = "SELECT e.event_id,e.org_id,o.org_name,c.company_type_name,e.event_name,e.event_from_date,e.event_to_date,"
			+ "e.from_time,e.to_time,e.event_location,e.event_loc_lat,e.event_loc_long,e.about_event,  e.event_logo,"
			+ "e.contact_person_name1,e.contact_person_name2,e.person1_mob,e.person2_mob,e.person1_email_id,e.person2_email_id,"
			+ "e.is_used,e.location_id,l.location_name,e.company_type_id,coalesce((select subscribe_status from t_visitor_event"
			+ " where t_visitor_event.visitor_id=:visitorId and e.event_id=t_visitor_event.event_id),0)as subscribe_status from m_events e, m_event_sup sup,"
			+ "t_visitor_event ,m_location l,m_organiser o,m_company c where e.is_used=1 AND e.event_to_date>=:curDate and l.location_id=e.location_id and c.company_type_id=e.company_type_id "
			+ "and o.org_id=e.org_id AND e.event_id=sup.event_id group by e.event_id", nativeQuery = true)
	List<GetEventsList> getEventList(@Param("visitorId") int visitorId,@Param("curDate") String curDate);

	@Query(value = "SELECT e.event_id,e.org_id,o.org_name,c.company_type_name,e.event_name,e.event_from_date,"
			+ "e.event_to_date,e.from_time,e.to_time,e.event_location,e.event_loc_lat,e.event_loc_long,e.about_event,"
			+ " e.event_logo,e.contact_person_name1,e.contact_person_name2,e.person1_mob,e.person2_mob,e.person1_email_id,"
			+ "e.person2_email_id,e.is_used,e.location_id,l.location_name,e.company_type_id,coalesce((select subscribe_status "
			+ "from t_visitor_event where t_visitor_event.visitor_id=:visitorId and e.event_id=t_visitor_event.event_id),0)as subscribe_status "
			+ " from m_events e,m_event_sup sup,t_visitor_event ,m_location l,m_organiser o,m_company c where e.is_used=1 AND e.event_to_date>=:curDate "
			+ " and "
			+ "l.location_id=e.location_id and c.company_type_id=e.company_type_id and o.org_id=e.org_id and e.company_type_id"
			+ " In(:companyTypeIdList) AND e.event_id=sup.event_id  group by e.event_id", nativeQuery = true)
	List<GetEventsList> getEventListWithAllLocationList(@Param("companyTypeIdList") List<Integer> companyTypeIdList,
			@Param("visitorId") int visitorId,@Param("curDate") String curDate);

	@Query(value = "SELECT e.event_id,e.org_id,o.org_name,c.company_type_name,e.event_name,e.event_from_date,"
			+ "e.event_to_date,e.from_time,e.to_time,e.event_location,e.event_loc_lat,e.event_loc_long,e.about_event,"
			+ " e.event_logo,e.contact_person_name1,e.contact_person_name2,e.person1_mob,e.person2_mob,e.person1_email_id,"
			+ "e.person2_email_id,e.is_used,e.location_id,l.location_name,e.company_type_id,coalesce((select subscribe_status"
			+ "from t_visitor_event where t_visitor_event.visitor_id=:visitorId and e.event_id=t_visitor_event.event_id),0)as subscribe_status"
			+ " from m_events e,m_event_sup sup,t_visitor_event ,m_location l,m_organiser o,m_company c where e.is_used=1 AND e.event_to_date>=:curDate and "
			+ "l.location_id=e.location_id and c.company_type_id=e.company_type_id and o.org_id=e.org_id and e.location_id IN(:locationIdList)"
			+ " AND e.event_id=sup.event_id group by e.event_id", nativeQuery = true)
	List<GetEventsList> getEventListWithAllCompanyList(@Param("locationIdList") List<Integer> locationIdList,
			@Param("visitorId") int visitorId,@Param("curDate") String curDate);

	@Query(value = "SELECT e.event_id,e.org_id,o.org_name,c.company_type_name,e.event_name,e.event_from_date,"
			+ "e.event_to_date,e.from_time,e.to_time,e.event_location,e.event_loc_lat,e.event_loc_long,e.about_event,"
			+ " e.event_logo,e.contact_person_name1,e.contact_person_name2,e.person1_mob,e.person2_mob,e.person1_email_id,"
			+ "e.person2_email_id,e.is_used,e.location_id,l.location_name,e.company_type_id,coalesce((select subscribe_status "
			+ "from t_visitor_event where t_visitor_event.visitor_id=:visitorId and e.event_id=t_visitor_event.event_id),0)as subscribe_status "
			+ " from m_events e,m_event_sup sup,t_visitor_event ,m_location l,m_organiser o,m_company c where e.is_used=1 AND e.event_to_date>=:curDate and "
			+ "l.location_id=e.location_id and c.company_type_id=e.company_type_id and o.org_id=e.org_id and e.company_type_id"
			+ " In(:companyTypeIdList) and e.location_id IN(:locationIdList) AND e.event_id=sup.event_id group by e.event_id", nativeQuery = true)
	List<GetEventsList> getEventListithAllLocationListAndCompanyList(
			@Param("companyTypeIdList") List<Integer> companyTypeIdList,
			@Param("locationIdList") List<Integer> locationIdList, @Param("visitorId") int visitorId,@Param("curDate") String curDate);

	@Query(value = "SELECT   e.event_id,e.org_id,o.org_name,c.company_type_name,e.event_name,e.event_from_date,e.event_to_date,e.from_time,"
			+ "e.to_time,e.event_location,e.event_loc_lat,e.event_loc_long,e.about_event,  e.event_logo,e.contact_person_name1,e.contact_person_name2,"
			+ "e.person1_mob,e.person2_mob,e.person1_email_id,e.person2_email_id,e.is_used,e.location_id,l.location_name,e.company_type_id,"
			+ "coalesce((select 1 from  t_event_exh_mapping where  t_event_exh_mapping.exh_id = :exhibitorId and e.event_id=t_event_exh_mapping.event_id "
			+ "and t_event_exh_mapping.is_used=1),0) as subscribe_status  from   m_events e ,t_visitor_exhibitor ,m_location l,m_organiser o,m_company c "
			+ "where l.location_id=e.location_id and c.company_type_id=e.company_type_id and o.org_id=e.org_id group by e.event_id ", nativeQuery = true)
	List<GetEventsList> getEventListWithSub(@Param("exhibitorId") int exhibitorId);

	@Query(value = "SELECT   e.event_id,e.org_id,o.org_name,c.company_type_name,e.event_name,e.event_from_date,e.event_to_date,e.from_time,e.to_time,e.event_location,e.event_loc_lat,"
			+ "e.event_loc_long,e.about_event,  e.event_logo,e.contact_person_name1,e.contact_person_name2,e.person1_mob,e.person2_mob,e.person1_email_id,e.person2_email_id,e.is_used,"
			+ "e.location_id,l.location_name,e.company_type_id,coalesce((select 1 from  t_event_exh_mapping where  t_event_exh_mapping.exh_id =:exhibitorId  and "
			+ "e.event_id=t_event_exh_mapping.event_id and t_event_exh_mapping.is_used=1),0) as subscribe_status  from   m_events e ,t_visitor_exhibitor "
			+ ",m_location l,m_organiser o,m_company c where l.location_id=e.location_id and c.company_type_id=e.company_type_id and o.org_id=e.org_id and e.company_type_id In(:companyTypeIdList)  group by e.event_id", nativeQuery = true)
	List<GetEventsList> getEventListWithAllLocationListWithSub(
			@Param("companyTypeIdList") List<Integer> companyTypeIdList, @Param("exhibitorId") int exhibitorId);

	@Query(value = "SELECT   e.event_id,e.org_id,o.org_name,c.company_type_name,e.event_name,e.event_from_date,e.event_to_date,e.from_time,e.to_time,"
			+ "e.event_location,e.event_loc_lat,e.event_loc_long,e.about_event,  e.event_logo,e.contact_person_name1,e.contact_person_name2,e.person1_mob,e.person2_mob,"
			+ "e.person1_email_id,e.person2_email_id,e.is_used,e.location_id,l.location_name,e.company_type_id,coalesce((select 1 from  t_event_exh_mapping where"
			+ "  t_event_exh_mapping.exh_id = :exhibitorId and e.event_id=t_event_exh_mapping.event_id and t_event_exh_mapping.is_used=1),0) as subscribe_status  from  "
			+ " m_events e ,t_visitor_exhibitor ,m_location l,m_organiser o,m_company c where l.location_id=e.location_id and c.company_type_id=e.company_type_id"
			+ " and o.org_id=e.org_id and e.location_id IN(:locationIdList) group by e.event_id", nativeQuery = true)
	List<GetEventsList> getEventListWithAllCompanyListWithSub(@Param("locationIdList") List<Integer> locationIdList,
			@Param("exhibitorId") int exhibitorId);

	@Query(value = "SELECT   e.event_id,e.org_id,o.org_name,c.company_type_name,e.event_name,e.event_from_date,e.event_to_date,e.from_time,e.to_time,e.event_location,"
			+ "e.event_loc_lat,e.event_loc_long,e.about_event,  e.event_logo,e.contact_person_name1,e.contact_person_name2,e.person1_mob,e.person2_mob,e.person1_email_id,"
			+ "e.person2_email_id,e.is_used,e.location_id,l.location_name,e.company_type_id,coalesce((select 1 from  t_event_exh_mapping where "
			+ " t_event_exh_mapping.exh_id = :exhibitorId and e.event_id=t_event_exh_mapping.event_id and t_event_exh_mapping.is_used=1),0) as subscribe_status  from  "
			+ " m_events e ,t_visitor_exhibitor ,m_location l,m_organiser o,m_company c where l.location_id=e.location_id and c.company_type_id=e.company_type_id and "
			+ "o.org_id=e.org_id and e.location_id IN(:locationIdList) and e.company_type_id  In(:companyTypeIdList) group by e.event_id", nativeQuery = true)
	List<GetEventsList> getEventListithAllLocationListAndCompanyListWithSub(
			@Param("companyTypeIdList") List<Integer> companyTypeIdList,
			@Param("locationIdList") List<Integer> locationIdList, @Param("exhibitorId") int exhibitorId);
}
