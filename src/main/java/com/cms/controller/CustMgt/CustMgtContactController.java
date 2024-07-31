package com.cms.controller.CustMgt;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.CustMgt.CustMgtContactBean;
import com.cms.service.CustMgt.CustMgtContactService;

@RestController
@RequestMapping("/CustMgt")
public class CustMgtContactController {
	
	@Autowired
	private CustMgtContactService custMgtContactService;
	
	private final static Logger log = LoggerFactory.getLogger(CustMgtContactController.class);
	
	@GetMapping("/contacts/{contactId}")
	public ResponseEntity<CustMgtContactBean> getContactById(@PathVariable Integer contactId ){
		log.debug("CustMgtContactController.getContactById({})", contactId );
		CustMgtContactBean custMgtContactBean = custMgtContactService.getContactById(contactId);
		if (custMgtContactBean  != null) {
			return ResponseEntity.status(HttpStatus.OK).body(custMgtContactBean);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/{customerId}/contacts")
	public ResponseEntity<List<CustMgtContactBean>> getContactsByCustomerId(@PathVariable Integer customerId ){
		log.debug("CustMgtContactController.getContactsByCustomerId({})", customerId );
		List<CustMgtContactBean> custMgtContactBeanList = new ArrayList<>();
		try {
			custMgtContactBeanList = custMgtContactService.getContactsByCustomerId(customerId);
			if (custMgtContactBeanList != null && !custMgtContactBeanList.isEmpty() && custMgtContactBeanList.get(0)  != null) {
				return ResponseEntity.status(HttpStatus.OK).body(custMgtContactBeanList);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}			
		} catch (Exception e) {
	        log.error("CustMgtContactController.getContactsByCustomerId({}) encountered an exception: {}", customerId, e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/contacts")
	public  ResponseEntity<CustMgtContactBean> createContact(@RequestBody CustMgtContactBean custMgtContactBean){
		custMgtContactService.createContact(custMgtContactBean);		
		Integer contactId = custMgtContactBean.getContact_id();
		log.debug("CustMgtContactController.createContact( return contact_id ={})", contactId);
//		
		CustMgtContactBean createBean = custMgtContactService.getContactById(contactId);
		return ResponseEntity.status(HttpStatus.CREATED).body(createBean);
	}
	
	@PutMapping("/contacts/{contactId}")
	public ResponseEntity<CustMgtContactBean> updateContact(@PathVariable Integer contactId, @RequestBody CustMgtContactBean custMgtContactBean){
		log.debug("CustMgtContactController.updateContact( update contact_id ={})", contactId);
		CustMgtContactBean checkBean = custMgtContactService.getContactById(contactId);	
		
		//存在チェック
		if (checkBean != null) {
			// 顧客チェック
			if(custMgtContactBean.getCustomer_id().equals(checkBean.getCustomer_id()) ) {
				log.debug("CustMgtContactController.updateContact : Both custMgtContactBean and checkBean has same customer_id ({})", checkBean.getCustomer_id());
				custMgtContactService.updateContact(contactId, custMgtContactBean);
				CustMgtContactBean updateCustMgtBean = custMgtContactService.getContactById(contactId);
				return ResponseEntity.status(HttpStatus.OK).body(updateCustMgtBean);
			}
			else {				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
	}
	
	@DeleteMapping("/contacts/{contactId}")
	public ResponseEntity<?> deleteContact(@PathVariable Integer contactId){
		log.debug("CustMgtContactController.deleteContact( delete contact_id ={})", contactId);
		custMgtContactService.deleteContact(contactId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
