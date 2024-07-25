package com.cms.controller.CustMgt;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.CustBankMgt.CustBankMgtBean;
import com.cms.entity.CustMgt.CustMgtQueryBean;
import com.cms.service.CustBankMgt.CustBankMgtService;
import com.cms.service.CustMgt.CustMgtService;

@RestController
@RequestMapping("/CustBankMgt")
public class CustBankMgtController {
	@Autowired
	private CustBankMgtService custBankMgtService;
	
	@Autowired
	private CustMgtService custMgtService;
	
	@Autowired
	
	private final static Logger log = LoggerFactory.getLogger(CustBankMgtController.class);
	
	//詳細情報用
	@GetMapping("/accounts/{bankAccountId}")
	public ResponseEntity<CustBankMgtBean> getAccountById(@PathVariable Integer bankAccountId){
		log.debug("CustMgtController.getAccountById({})", bankAccountId);
		
		CustBankMgtBean custBankMgtBean = custBankMgtService.getAccountById(bankAccountId);
		
		if (custBankMgtBean != null) {
			return ResponseEntity.status(HttpStatus.OK).body(custBankMgtBean);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	
	
	//顧客検索用
	@GetMapping("/searchCustomers/{employeeId}")
	public ResponseEntity<List<CustMgtQueryBean>> getCustomersByEmployeeId(@PathVariable Integer employeeId, 
				//Search condition
				@RequestParam(required = false) Integer customerId, 		@RequestParam(required = false) String customerSerial,
				@RequestParam(required = false) String customerName ,	@RequestParam(required = false) String customerDepName){
	    List<CustMgtQueryBean> custMgtQueryBeanList = new ArrayList<>();

	    try {
	        custMgtQueryBeanList = custMgtService.getCustomersByEmployeeId(employeeId, customerId, customerSerial, customerName, customerDepName);
	        
	        if (custMgtQueryBeanList != null && !custMgtQueryBeanList.isEmpty() && custMgtQueryBeanList.get(0) != null) {
	            return ResponseEntity.status(HttpStatus.OK).body(custMgtQueryBeanList);
	        } else {
	            log.debug("CustMgtController.getCustomersByEmployeeId({}) got nothing.", employeeId);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    } catch (Exception e) {
	        log.error("CustMgtController.getCustomersByEmployeeId({}) encountered an exception: {}", employeeId, e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}
