package com.ats.exhibition;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.exhibition.model.ComMemWithOrgName;
import com.ats.exhibition.model.CommitteeMembers;

import com.ats.exhibition.model.ErrorMessage;
import com.ats.exhibition.model.EventWithOrgName;
import com.ats.exhibition.model.Events;
import com.ats.exhibition.model.ExhListLikeStatus;
import com.ats.exhibition.model.Exhibitor;
import com.ats.exhibition.model.ExhibitorWithOrgName;
import com.ats.exhibition.model.FloarMap;
import com.ats.exhibition.model.GetFloarMap;
import com.ats.exhibition.model.GetSchedule;
import com.ats.exhibition.model.GetSponsor;
import com.ats.exhibition.model.OrgSubscription;
import com.ats.exhibition.model.Organiser;
import com.ats.exhibition.model.Package1;
import com.ats.exhibition.model.ProductWithExhName;
import com.ats.exhibition.model.Products;
import com.ats.exhibition.model.ScheduleDetail;
import com.ats.exhibition.model.ScheduleHeader;
import com.ats.exhibition.model.Sponsor;
import com.ats.exhibition.repository.ComMemWithOrgNameRepo;
import com.ats.exhibition.repository.CommitteeMemRepository;

import com.ats.exhibition.repository.EventPhotoRepository;
import com.ats.exhibition.repository.EventWithOrgNameRepository;
import com.ats.exhibition.repository.EventsRepository;
import com.ats.exhibition.repository.ExhListLikeStatusRepository;
import com.ats.exhibition.repository.ExhibitorRepository;
import com.ats.exhibition.repository.ExhibitorWithOrgNameRepo;
import com.ats.exhibition.repository.FloarMapRepository;
import com.ats.exhibition.repository.GetFloarMapRepository;
import com.ats.exhibition.repository.GetScheduleHeaderRepository;
import com.ats.exhibition.repository.GetSponsorRepository;
import com.ats.exhibition.repository.OrgSubscriptionRepository;
import com.ats.exhibition.repository.OrganiserRepository;
import com.ats.exhibition.repository.Package1Repository;
import com.ats.exhibition.repository.ProductWithExhNameRepository;
import com.ats.exhibition.repository.ProductsRepository;
import com.ats.exhibition.repository.ScheduleDetailRepository;
import com.ats.exhibition.repository.ScheduleHeaderRepository;
import com.ats.exhibition.repository.SponsorRepository;

@RestController
public class MasterController {

	@Autowired
	CommitteeMemRepository committeeMemRepository;

	@Autowired
	ComMemWithOrgNameRepo comMemWithOrgNameRepo;

	@Autowired
	ExhListLikeStatusRepository exhListLikeStatusRepository;

	@Autowired
	EventsRepository eventsRepository;

	@Autowired
	OrganiserRepository organiserRepository;

	@Autowired
	OrgSubscriptionRepository orgSubscriptionRepository;

	@Autowired
	Package1Repository package1Repository;

	@Autowired
	ExhibitorRepository exhibitorRepository;

	@Autowired
	ProductsRepository productsRepository;

	@Autowired
	ProductWithExhNameRepository productWithExhNameRepository;

	@Autowired
	EventWithOrgNameRepository eventWithOrgNameRepository;

	@Autowired
	ExhibitorWithOrgNameRepo exhibitorWithOrgNameRepo;

	@Autowired
	SponsorRepository sponsorRepository;

	@Autowired
	GetSponsorRepository getSponsorRepository;

	@Autowired
	ScheduleHeaderRepository scheduleHeaderRepository;

	@Autowired
	ScheduleDetailRepository scheduleDetailRepository;

	@Autowired
	FloarMapRepository floarMapRepository;

	@Autowired
	GetFloarMapRepository getFloarMapRepository;

	@Autowired
	GetScheduleHeaderRepository getScheduleHeaderRepository;

	@Autowired
	EventPhotoRepository eventPhotoRepository;

	// ------------Committee Member--------------------
	// sac 30-05-2018
	@RequestMapping(value = { "/getSponsorByEvent" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSponsor> getSponsorByEvent(@RequestParam("eventId") int eventId) {

		List<GetSponsor> sponsorList = null;

		try {

			sponsorList = getSponsorRepository.getSponsorsByEvnId(eventId);

		} catch (Exception e) {

			System.err.println("Exce in getting sponsor by EVent Id " + e.getMessage());
			e.printStackTrace();
		}
		return sponsorList;

	}

	@RequestMapping(value = { "/saveCommitteeMember" }, method = RequestMethod.POST)
	public @ResponseBody CommitteeMembers saveCommitteeMember(@RequestBody CommitteeMembers committeeMembers) {

		CommitteeMembers comMem = new CommitteeMembers();

		try {

			comMem = committeeMemRepository.saveAndFlush(committeeMembers);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comMem;

	}

	@RequestMapping(value = { "/saveFloarMap" }, method = RequestMethod.POST)
	public @ResponseBody FloarMap saveFloarMap(@RequestBody FloarMap floarMap) {

		FloarMap floarMapRes = null;
		try {
			floarMapRes = floarMapRepository.saveAndFlush(floarMap);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return floarMapRes;
	}

	@RequestMapping(value = { "/getFloarMapById" }, method = RequestMethod.POST)
	public @ResponseBody GetFloarMap getFloarMapById(@RequestParam("floarMapId") int floarMapId) {

		GetFloarMap flourMapRes = null;
		try {
			flourMapRes = getFloarMapRepository.findFloarMapById(floarMapId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return flourMapRes;

	}

	@RequestMapping(value = { "/getFloarMapByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFloarMap> getFloarMapByEventId(@RequestParam("eventId") int eventId) {

		List<GetFloarMap> flourMapRes = null;
		try {
			flourMapRes = getFloarMapRepository.findFloarMapByEventId(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return flourMapRes;

	}

	// sachin get Event
	@RequestMapping(value = { "/getEventByEId" }, method = RequestMethod.POST)
	public @ResponseBody Events getEventByEId(@RequestParam("eventId") int eventId) {

		Events eventResponse = null;
		try {
			eventResponse = eventsRepository.findByEventId(eventId);

		} catch (Exception e) {
			System.err.println("Exception in getting /getEventByEId @MasterController " + e.getMessage());
			e.printStackTrace();

		}
		return eventResponse;

	}

	@RequestMapping(value = { "/getAllFloarMapByOrgId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFloarMap> getAllFloarMapByOrgId(@RequestParam("orgId") int orgId) {

		List<GetFloarMap> flourMapRes = null;
		try {
			flourMapRes = getFloarMapRepository.findAllOrgId(orgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return flourMapRes;

	}

	@RequestMapping(value = { "/deleteFloarMap" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteFloarMap(@RequestParam("floarMapId") int floarMapId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = floarMapRepository.deleteFloarMap(floarMapId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("FloarMap Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("FloarMap Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("FloarMap Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/saveSchedule" }, method = RequestMethod.POST)
	public @ResponseBody ScheduleHeader saveSchedule(@RequestBody ScheduleHeader scheduleHeader) {

		ScheduleHeader scheduleHeaderRes = null;
		try {
			scheduleHeaderRes = scheduleHeaderRepository.saveAndFlush(scheduleHeader);

			if (!scheduleHeader.getScheduleDetailList().isEmpty()) {
				for (ScheduleDetail schDetail : scheduleHeader.getScheduleDetailList()) {
					schDetail.setScheduleId(scheduleHeaderRes.getScheduleId());
					scheduleDetailRepository.saveAndFlush(schDetail);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return scheduleHeaderRes;
	}

	@RequestMapping(value = { "/saveSponsor" }, method = RequestMethod.POST)
	public @ResponseBody Sponsor saveSponsor(@RequestBody Sponsor sponsor) {

		Sponsor sponsorRes = null;
		try {
			sponsorRes = sponsorRepository.saveAndFlush(sponsor);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return sponsorRes;
	}

	@RequestMapping(value = { "/deleteSchedule" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSchedule(@RequestParam("scheduleId") int scheduleId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = scheduleHeaderRepository.deleteSchedule(scheduleId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Schedule Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Schedule Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Schedule Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getScheduleByEventId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSchedule> getScheduleById(@RequestParam("eventId") int eventId) {

		List<GetSchedule> scheduleHeaderRes = null;
		try {
			scheduleHeaderRes = getScheduleHeaderRepository.findByEventIdAndIsUsed(eventId, 1);

			for (int i = 0; i < scheduleHeaderRes.size(); i++) {
				List<ScheduleDetail> scheduleDetails = scheduleDetailRepository
						.findByScheduleIdAndIsUsed(scheduleHeaderRes.get(i).getScheduleId(), 1);

				scheduleHeaderRes.get(i).setScheduleDetailList(scheduleDetails);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return scheduleHeaderRes;

	}

	@RequestMapping(value = { "/getScheduleHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody GetSchedule getScheduleHeaderById(@RequestParam("scheduleId") int scheduleId) {

		GetSchedule scheduleHeaderRes = null;
		try {
			scheduleHeaderRes = getScheduleHeaderRepository.findByScheduleId(scheduleId);

			List<ScheduleDetail> scheduleDetails = scheduleDetailRepository.findByScheduleIdAndIsUsed(scheduleId, 1);

			scheduleHeaderRes.setScheduleDetailList(scheduleDetails);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return scheduleHeaderRes;

	}

	@RequestMapping(value = { "/getSchedules" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSchedule> getSchedules(@RequestParam("orgId") int orgId) {

		List<GetSchedule> scheduleHeaderRes = null;
		try {
			scheduleHeaderRes = getScheduleHeaderRepository.findByOrgId(orgId, 1);

			for (int i = 0; i < scheduleHeaderRes.size(); i++) {
				List<ScheduleDetail> scheduleDetails = scheduleDetailRepository
						.findByScheduleIdAndIsUsed(scheduleHeaderRes.get(i).getScheduleId(), 1);
				scheduleHeaderRes.get(i).setScheduleDetailList(scheduleDetails);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return scheduleHeaderRes;
	}

	@RequestMapping(value = { "/getSponsorById" }, method = RequestMethod.POST)
	public @ResponseBody Sponsor getSponsorById(@RequestParam("sponsorId") int sponsorId) {

		Sponsor sponsorRes = null;
		try {
			sponsorRes = sponsorRepository.findBySponsorId(sponsorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return sponsorRes;

	}

	@RequestMapping(value = { "/deleteSponsor" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSponsor(@RequestParam("sponsorId") int sponsorId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = sponsorRepository.deleteSponsor(sponsorId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Sponsor Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getAllCommitteeMembersByOrgIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<ComMemWithOrgName> getAllCommitteeMembersByOrgIdAndIsUsed(
			@RequestParam("orgId") int orgId) {

		List<ComMemWithOrgName> committeeMembersList = new ArrayList<ComMemWithOrgName>();

		try {

			committeeMembersList = comMemWithOrgNameRepo.getAllCommitteeMembersByOrgId(orgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return committeeMembersList;

	}

	@RequestMapping(value = { "/getAllCommitteeMembersByMemId" }, method = RequestMethod.POST)
	public @ResponseBody ComMemWithOrgName getAllCommitteeMembersByMemId(@RequestParam("memId") int memId) {

		ComMemWithOrgName committeeMembersList = new ComMemWithOrgName();

		try {

			committeeMembersList = comMemWithOrgNameRepo.getAllCommitteeMembersByMemId(memId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return committeeMembersList;

	}

	@RequestMapping(value = { "/findAllSponsors" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSponsor> findAllSponsors(@RequestParam("orgId") int orgId) {

		List<GetSponsor> sponsorList = null;
		try {
			sponsorList = getSponsorRepository.findAllSponsors(orgId);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return sponsorList;

	}

	@RequestMapping(value = { "/getCommitteeMemByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<ComMemWithOrgName> getCommitteeMemByIsUsed() {

		List<ComMemWithOrgName> comMemWithOrgNameList = new ArrayList<ComMemWithOrgName>();

		try {

			comMemWithOrgNameList = comMemWithOrgNameRepo.findByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comMemWithOrgNameList;

	}

	@RequestMapping(value = { "/deleteCommitteeMembers" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteCommitteeMembers(@RequestParam("memId") int memId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = committeeMemRepository.deleteCommitteeMember(memId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	// ------------Organiser-------------------

	@RequestMapping(value = { "/saveOrganiser" }, method = RequestMethod.POST)
	public @ResponseBody Organiser saveOrganiser(@RequestBody Organiser Organiser) {

		Organiser org = new Organiser();

		try {

			org = organiserRepository.saveAndFlush(Organiser);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return org;

	}

	@RequestMapping(value = { "/organiserMobileNoAndIsUSed" }, method = RequestMethod.POST)
	public @ResponseBody Organiser organiserMobileNoAndIsUSed(@RequestParam("userMob") String userMob) {

		Organiser org = new Organiser();

		try {

			org = organiserRepository.findByUserMobAndIsUsed(userMob, 1);

			if (org == null) {
				org = new Organiser();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return org;

	}

	@RequestMapping(value = { "/getOrganiserByOrgId" }, method = RequestMethod.POST)
	public @ResponseBody Organiser getAllOrganiser(@RequestParam("orgId") int orgId) {

		Organiser organiser = new Organiser();

		try {

			organiser = organiserRepository.findByOrgId(orgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return organiser;

	}

	@RequestMapping(value = { "/getAllOrganisersByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Organiser> getOrganiserByIsUsed() {

		List<Organiser> organiserList = new ArrayList<Organiser>();

		try {

			organiserList = organiserRepository.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return organiserList;

	}

	@RequestMapping(value = { "/deleteOrganiser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteOrganiser(@RequestParam("orgId") int orgId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = organiserRepository.deleteOrganiser(orgId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getAllOrganisersByIsUsedAndIsActive" }, method = RequestMethod.GET)
	public @ResponseBody List<Organiser> getAllOrganisersByIsUsedAndIsActive() {

		List<Organiser> organiserList = new ArrayList<Organiser>();

		try {

			organiserList = organiserRepository.findByIsUsedAndIsActive(1, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return organiserList;

	}

	// ------------ Package 1------------------------------

	@RequestMapping(value = { "/savePackage" }, method = RequestMethod.POST)
	public @ResponseBody Package1 savePackage(@RequestBody Package1 Package1) {

		Package1 pack = new Package1();

		try {

			pack = package1Repository.saveAndFlush(Package1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return pack;

	}

	@RequestMapping(value = { "/getAllPackages" }, method = RequestMethod.GET)
	public @ResponseBody List<Package1> getAllPackages() {

		List<Package1> packageList = new ArrayList<Package1>();

		try {

			packageList = package1Repository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return packageList;

	}

	@RequestMapping(value = { "/getAllPackagesByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Package1> getAllPackagesByIsUsed() {

		List<Package1> packageList = new ArrayList<Package1>();

		try {

			packageList = package1Repository.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return packageList;

	}

	@RequestMapping(value = { "/deletePackage" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deletePackage(@RequestParam("pkgId") int pkgId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = package1Repository.deletePackage(pkgId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	// ------------Events------------------

	@RequestMapping(value = { "/saveEvents" }, method = RequestMethod.POST)
	public @ResponseBody Events saveEvents(@RequestBody Events Events) {

		Events event = new Events();

		try {

			event = eventsRepository.saveAndFlush(Events);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return event;

	}

	@RequestMapping(value = { "/getAllEvents" }, method = RequestMethod.GET)
	public @ResponseBody List<Events> getAllEvents() {

		List<Events> eventList = new ArrayList<Events>();

		try {

			eventList = eventsRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

	@RequestMapping(value = { "/getAllEventsByEventId" }, method = RequestMethod.POST)
	public @ResponseBody EventWithOrgName getAllEventsByEventId(@RequestParam("eventId") int eventId) {

		EventWithOrgName eventList = new EventWithOrgName();

		try {

			eventList = eventWithOrgNameRepository.getAllEventsByEventId(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

	@RequestMapping(value = { "/getAllEventsByorgIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<EventWithOrgName> getAllEventsByorgIdAndIsUsed(@RequestParam("orgId") int orgId) {

		List<EventWithOrgName> eventList = new ArrayList<EventWithOrgName>();

		try {

			eventList = eventWithOrgNameRepository.getAllEventsByOrgIdAndIsUsed(orgId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

	@RequestMapping(value = { "/getEventsBetweenDates" }, method = RequestMethod.POST)
	public @ResponseBody List<EventWithOrgName> getEventsBetweenDates(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<EventWithOrgName> eventList = new ArrayList<EventWithOrgName>();

		try {

			eventList = eventWithOrgNameRepository.getEventssBetweenDates(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

	@RequestMapping(value = { "/getAllEventsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<EventWithOrgName> getAllEventsByIsUsed() {

		List<EventWithOrgName> eventList = new ArrayList<EventWithOrgName>();

		try {

			eventList = eventWithOrgNameRepository.getAllEventsByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}

	@RequestMapping(value = { "/deleteEvent" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteEvent(@RequestParam("eventId") int eventId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = eventsRepository.deleteEvent(eventId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	// -----------Org-Subscription-------------------

	@RequestMapping(value = { "/saveOrgSubscription" }, method = RequestMethod.POST)
	public @ResponseBody OrgSubscription saveOrgSubscription(@RequestBody OrgSubscription OrgSubscription) {

		OrgSubscription org = new OrgSubscription();

		try {

			org = orgSubscriptionRepository.saveAndFlush(OrgSubscription);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return org;

	}

	@RequestMapping(value = { "/getSubDetailsByOrgIdAndstatus" }, method = RequestMethod.POST)
	public @ResponseBody OrgSubscription getSubDetailsByOrgIdAndstatus(@RequestParam("orgId") int orgId,
			@RequestParam("status") int status) {

		OrgSubscription organiser = new OrgSubscription();

		try {

			organiser = orgSubscriptionRepository.findByOrgIdAndStatus(orgId, status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return organiser;

	}

	@RequestMapping(value = { "/getSubHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody OrgSubscription getSubHeaderById(@RequestParam("subId") int subId) {

		OrgSubscription organiser = new OrgSubscription();

		try {

			organiser = orgSubscriptionRepository.findBySubId(subId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return organiser;

	}

	@RequestMapping(value = { "/insertNewSubscription" }, method = RequestMethod.POST)
	public @ResponseBody OrgSubscription insertNewSubscription(@RequestBody OrgSubscription orgSubscription) {

		OrgSubscription organiser = new OrgSubscription();

		try {
			organiser = orgSubscriptionRepository.findByOrgIdAndStatus(orgSubscription.getOrgId(), 0);

			organiser.setStatus(1);

			orgSubscriptionRepository.saveAndFlush(organiser);
			orgSubscription = orgSubscriptionRepository.saveAndFlush(orgSubscription);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orgSubscription;

	}

	@RequestMapping(value = { "/deleteOrgSubscription" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteOrgSubscription(@RequestParam("subId") int subId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = orgSubscriptionRepository.deleteOrgSubscription(subId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	// --------------------Exhibitor-----------------------

	@RequestMapping(value = { "/saveExhibitor" }, method = RequestMethod.POST)
	public @ResponseBody Exhibitor saveExhibitor(@RequestBody Exhibitor Exhibitor) {

		Exhibitor exhibitor = new Exhibitor();

		try {

			exhibitor = exhibitorRepository.saveAndFlush(Exhibitor);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhibitor;

	}

	@RequestMapping(value = { "/exhibitorMobileNoAndIsUSed" }, method = RequestMethod.POST)
	public @ResponseBody Exhibitor exhibitorMobileNoAndIsUSed(@RequestParam("userMob") String userMob) {

		Exhibitor exhibitor = new Exhibitor();

		try {

			exhibitor = exhibitorRepository.findByUserMobAndIsUsed(userMob, 1);

			if (exhibitor == null) {
				exhibitor = new Exhibitor();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhibitor;

	}

	@RequestMapping(value = { "/getExhibitorByExhId" }, method = RequestMethod.POST)
	public @ResponseBody ExhibitorWithOrgName getExhibitorByExhId(@RequestParam("exhId") int exhId) {

		ExhibitorWithOrgName exhibitorList = new ExhibitorWithOrgName();

		try {

			exhibitorList = exhibitorWithOrgNameRepo.getAllExhibitorsByExhId(exhId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhibitorList;

	}

	@RequestMapping(value = { "/getAllExhByIdAndLikeStatus" }, method = RequestMethod.POST)
	public @ResponseBody ExhListLikeStatus getAllExhByIdAndLikeStatus(@RequestParam("exhId") int exhId,
			@RequestParam("eventId") int eventId, @RequestParam("visitorId") int visitorId) {

		ExhListLikeStatus exhibitorList = new ExhListLikeStatus();

		try {

			exhibitorList = exhListLikeStatusRepository.getAllExhByIdAndLikeStatus(exhId, eventId, visitorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhibitorList;

	}

	@RequestMapping(value = { "/getAllExhibitorsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<ExhibitorWithOrgName> getAllExhibitorsByIsUsed() {

		List<ExhibitorWithOrgName> exhibitorList = new ArrayList<ExhibitorWithOrgName>();

		try {

			exhibitorList = exhibitorWithOrgNameRepo.findByIsUsed();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhibitorList;

	}

	@RequestMapping(value = { "/deleteExhibitor" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteExhibitor(@RequestParam("exhId") int exhId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = exhibitorRepository.deleteExhibitors(exhId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getGallaryCount" }, method = RequestMethod.POST)
	public @ResponseBody int getGallaryCount(@RequestParam("eventId") int eventId) {

		int count = 0;
		try {

			count = eventPhotoRepository.getGallaryCount(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return count;

	}

	@RequestMapping(value = { "/getAllExhibotorsByorgIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhibitorWithOrgName> getAllExhibotorsByorgIdAndIsUsed(@RequestParam("orgId") int orgId) {

		List<ExhibitorWithOrgName> exhList = new ArrayList<ExhibitorWithOrgName>();

		try {

			exhList = exhibitorWithOrgNameRepo.getAllExhibotorsByorgIdAndIsUsed(orgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhList;

	}

	/*
	 * @RequestMapping(value = { "/getExhibitorBetweenDates" }, method =
	 * RequestMethod.POST) public @ResponseBody List<ExhibitorWithOrgName>
	 * getExhibitorBetweenDates(@RequestParam("fromDate") String fromDate,
	 * 
	 * @RequestParam("toDate") String toDate) {
	 * 
	 * List<ExhibitorWithOrgName> exhibitorList = new
	 * ArrayList<ExhibitorWithOrgName>();
	 * 
	 * try {
	 * 
	 * exhibitorList =
	 * exhibitorWithOrgNameRepo.getAllExhibitorsBetweenDates(fromDate,toDate);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } return exhibitorList;
	 * 
	 * }
	 */
	// ------------Products------------------------------------------

	@RequestMapping(value = { "/saveProducts" }, method = RequestMethod.POST)
	public @ResponseBody Products saveProducts(@RequestBody Products Products) {

		Products products = new Products();

		try {

			products = productsRepository.saveAndFlush(Products);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return products;

	}

	@RequestMapping(value = { "/getAllProducts" }, method = RequestMethod.GET)
	public @ResponseBody List<Products> getAllProducts() {

		List<Products> productList = new ArrayList<Products>();

		try {

			productList = productsRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productList;

	}

	@RequestMapping(value = { "/getProductByProdId" }, method = RequestMethod.POST)
	public @ResponseBody ProductWithExhName getProductByProdId(@RequestParam("prodId") int prodId) {

		ProductWithExhName productList = new ProductWithExhName();

		try {

			productList = productWithExhNameRepository.getAllProductsByProdId(prodId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productList;

	}

	@RequestMapping(value = { "/getAllProductsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<ProductWithExhName> getAllProductsByIsUsed() {

		List<ProductWithExhName> productList = new ArrayList<ProductWithExhName>();

		try {

			productList = productWithExhNameRepository.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productList;

	}

	@RequestMapping(value = { "/getAllProductsByExId" }, method = RequestMethod.POST)
	public @ResponseBody List<ProductWithExhName> getAllProductsByExId(@RequestParam("exhId") int exhId) {

		List<ProductWithExhName> productList = new ArrayList<ProductWithExhName>();

		try {

			productList = productWithExhNameRepository.findByExhId(exhId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productList;

	}

	@RequestMapping(value = { "/deleteProduct" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteProduct(@RequestParam("prodId") int prodId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = productsRepository.deleteProducts(prodId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getExhibitorsByParam" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhibitorWithOrgName> getExhibitorsByParam(@RequestParam("parameter") String parameter,
			@RequestParam("status") int status) {

		List<ExhibitorWithOrgName> exhibitorList = null;

		try {

			if (status == 1) {
				exhibitorList = exhibitorWithOrgNameRepo.getExhibitorsByParam1(parameter);
			} else if (status == 2) {
				exhibitorList = exhibitorWithOrgNameRepo.getExhibitorsByParam2(parameter);

			} else if (status == 3) {
				exhibitorList = exhibitorWithOrgNameRepo.getExhibitorsByParam3(parameter);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhibitorList;

	}

}
