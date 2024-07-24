package com.cms.controller.CustMgt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.CustMgt.CustMgtBean;
import com.cms.service.CustMgt.CustMgtService;

@RestController
@RequestMapping("/CustMgt")
public class CustMgtController {

	@Autowired
	private CustMgtService custMgtService;
	
	private final static Logger log = LoggerFactory.getLogger(CustMgtController.class);
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustMgtBean> getCustomerById(@PathVariable Integer customerId){
		log.debug("CustMgtController.getCustomerById({})", customerId);
		
		CustMgtBean custMgtBean = custMgtService.getCustomerById(customerId);
		
		if (custMgtBean != null) {
			return ResponseEntity.status(HttpStatus.OK).body(custMgtBean);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@PostMapping("/customers")
	public ResponseEntity<CustMgtBean> createCustomer(@RequestBody CustMgtBean custMgtBean){
		
		Integer customerId = custMgtService.createCustomer(custMgtBean);
		log.debug("CustMgtController.createCustomer( return customer_id ={})", customerId);
		
		CustMgtBean createCustMgtBean = custMgtService.getCustomerById(customerId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createCustMgtBean);
	}
}
