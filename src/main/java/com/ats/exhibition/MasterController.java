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

	@RequestMapping(value = { "/getAllCommitteeMembers" }, method = RequestMethod.POST)
	public @ResponseBody List<ComMemWithOrgName> getAllCommitteeMembers(@RequestParam("orgId") int orgId) {

		List<ComMemWithOrgName> committeeMembersList = new ArrayList<ComMemWithOrgName>();

		try {

			committeeMembersList = comMemWithOrgNameRepo.getAllCommitteeMembersByOrgId(orgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return committeeMembersList;

	}

	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public @ResponseBody List<CommitteeMembers> test() {

		List<CommitteeMembers> committeeMembersList = new ArrayList<CommitteeMembers>();

		try {

			committeeMembersList = committeeMemRepository.findCommitteeMembers();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return committeeMembersList;

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

	// ------------Subscription-------------------

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
	public @ResponseBody List<EventWithOrgName> getAllEventsByEventId(@RequestParam("eventId") int eventId) {

		List<EventWithOrgName> eventList = new ArrayList<EventWithOrgName>();

		try {

			eventList = eventWithOrgNameRepository.getAllEventsByEventId(eventId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return eventList;

	}
	
	@RequestMapping(value = { "/deleteEvent" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteEvent(@RequestParam("pkgId") int pkgId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = eventsRepository.deleteEvent(pkgId);

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
	
	
	//--------------------Exhibitor-----------------------
	
	
	
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

	@RequestMapping(value = { "/getExhibitorsByIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<Exhibitor> getExhibitorsByIsUsed(@RequestParam("isUsed") int isUsed) {

		List<Exhibitor> exhibitorList = new ArrayList<Exhibitor>();

		try {

			exhibitorList = exhibitorRepository.findByIsUsed(isUsed);

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

	@RequestMapping(value = { "/getAllProductsByProdId" }, method = RequestMethod.POST)
	public @ResponseBody List<ProductWithExhName> getAllProductsByProdId(@RequestParam("prodId") int prodId) {

		List<ProductWithExhName> productList = new ArrayList<ProductWithExhName>();

		try {

			productList = productWithExhNameRepository.getAllProductsByProdId(prodId);

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
