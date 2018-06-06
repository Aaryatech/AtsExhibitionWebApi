package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.exhibition.model.GetExhEventSubscription;

public interface GetExhEventSubRepository extends JpaRepository<GetExhEventSubscription, Integer>{

	@Query(value="select s.exh_esub_id,s.org_id,o.org_name,s.event_id,e.event_name,s.exh_id,ex.exh_name,s.subscription_amt,s.paid_amt,s.rem_amt,s.stall_no,s.is_approved,s.is_used from t_exh_event_subscription s ,m_organiser o,m_events e,m_exhibitor ex where o.org_id=s.org_id and e.event_id=s.event_id and ex.exh_id=s.exh_id and s.is_used=1 and s.is_approved=0 and s.org_id=:orgId",nativeQuery=true)
	List<GetExhEventSubscription> getExhEventSubscriptionList(@Param("orgId")int orgId);

	@Query(value="select s.exh_esub_id,s.org_id,o.org_name,s.event_id,e.event_name,s.exh_id,ex.exh_name,s.subscription_amt,s.paid_amt,s.rem_amt,s.stall_no,s.is_approved,s.is_used from t_exh_event_subscription s ,m_organiser o,m_events e,m_exhibitor ex where o.org_id=s.org_id and e.event_id=s.event_id and ex.exh_id=s.exh_id   and s.exh_esub_id=:exhEsubId",nativeQuery=true)
	GetExhEventSubscription getExhEventSub(@Param("exhEsubId")int exhEsubId);

	
}
