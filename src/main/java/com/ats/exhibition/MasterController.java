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
import com.ats.exhibition.model.Exhibitor;
import com.ats.exhibition.model.ExhibitorWithOrgName;
import com.ats.exhibition.model.OrgSubscription;
import com.ats.exhibition.model.Organiser;
import com.ats.exhibition.model.Package1;
import com.ats.exhibition.model.ProductWithExhName;
import com.ats.exhibition.model.Products;
import com.ats.exhibition.repository.ComMemWithOrgNameRepo;
import com.ats.exhibition.repository.CommitteeMemRepository;
import com.ats.exhibition.repository.EventWithOrgNameRepository;
import com.ats.exhibition.repository.EventsRepository;
import com.ats.exhibition.repository.ExhibitorRepository;
import com.ats.exhibition.repository.ExhibitorWithOrgNameRepo;
import com.ats.exhibition.repository.OrgSubscriptionRepository;
import com.ats.exhibition.repository.OrganiserRepository;
import com.ats.exhibition.repository.Package1Repository;
import com.ats.exhibition.repository.ProductWithExhNameRepository;
import com.ats.exhibition.repository.ProductsRepository;

@RestController
public class MasterController {

	@Autowired
	CommitteeMemRepository committeeMemRepository;

	@Autowired
	ComMemWithOrgNameRepo comMemWithOrgNameRepo;

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

	// ------------Committee Member--------------------

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

	@RequestMapping(value = { "/getAllCommitteeMembersByOrgIdAndIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<ComMemWithOrgName> getAllCommitteeMembersByOrgIdAndIsUsed(@RequestParam("orgId") int orgId) {

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

	@RequestMapping(value = { "/getOrganisersByIsUsed" }, method = RequestMethod.GET)
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

			eventList = eventWithOrgNameRepository.getEventssBetweenDates(fromDate,toDate);

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

	/*@RequestMapping(value = { "/getExhibitorBetweenDates" }, method = RequestMethod.POST)
	public @ResponseBody List<ExhibitorWithOrgName> getExhibitorBetweenDates(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<ExhibitorWithOrgName> exhibitorList = new ArrayList<ExhibitorWithOrgName>();

		try {

			exhibitorList = exhibitorWithOrgNameRepo.getAllExhibitorsBetweenDates(fromDate,toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return exhibitorList;

	}
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

}
