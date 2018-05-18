package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.exhibition.model.GetSponsor;
@Repository
public interface GetSponsorRepository extends JpaRepository<GetSponsor, Integer>{

	@Query(value="select s.sponsor_id,s.event_id,e.event_name,s.name,s.company,s.designation,s.photo,s.email,s.website,s.mobile,s.remark,s.is_used from m_sponsor s,m_events e where s.is_used=0",nativeQuery=true)
	List<GetSponsor> findAllSponsors();

}
