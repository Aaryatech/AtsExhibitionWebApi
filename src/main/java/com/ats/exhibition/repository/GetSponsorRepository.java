package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.exhibition.model.GetSponsor;
@Repository
public interface GetSponsorRepository extends JpaRepository<GetSponsor, Integer>{

	@Query(value="select s.sponsor_id,s.org_id,s.event_id,e.event_name,s.name,s.company_id,c.company_type_name as company,s.designation,s.photo,s.email,s.website,s.mobile,s.remark,s.is_used from m_sponsor s,m_events e,m_company c where s.is_used=1 and s.company_id=c.company_type_id and e.event_id=s.event_id and s.org_id=:orgId",nativeQuery=true)
	List<GetSponsor> findAllSponsors(@Param("orgId")int orgId);

}
