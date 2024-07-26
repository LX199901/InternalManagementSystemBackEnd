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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.CustMgt.CustMgtBean;
import com.cms.entity.CustMgt.CustMgtQueryBean;
import com.cms.service.CustMgt.CustMgtService;

@RestController
@RequestMapping("/CustMgt")
public class CustMgtController {

	@Autowired
	private CustMgtService custMgtService;
	
	private final static Logger log = LoggerFactory.getLogger(CustMgtController.class);
	
	//詳細情報用
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
	
	//新規顧客	//TODO: must, range, format
	@PostMapping("/customers")
	public ResponseEntity<CustMgtBean> createCustomer(@RequestBody CustMgtBean custMgtBean){
		custMgtService.createCustomer(custMgtBean);		
		Integer customerId = custMgtBean.getCustomer_id();
		log.debug("CustMgtController.createCustomer( return customer_id ={})", customerId);
		
		CustMgtBean createCustMgtBean = custMgtService.getCustomerById(customerId);
		return ResponseEntity.status(HttpStatus.CREATED).body(createCustMgtBean);
	}
	
	//顧客変更 //TODO: must, range, format
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<CustMgtBean> updateCustomer(@PathVariable Integer customerId, @RequestBody CustMgtBean custMgtBean){
		
		log.debug("CustMgtController.updateCustomer( customer_id ={} )", customerId);
		
		CustMgtBean checkBean = custMgtService.getCustomerById(customerId);
		
		if (checkBean != null) {
//			log.debug("customer owner employee_id ={} ", checkBean.getRegister_employee_id());
//			log.debug("request employee_id ={} ", custMgtBean.getRegister_employee_id());
			
			// 権限チェック
			if(custMgtBean.getRegister_employee_id().equals(checkBean.getRegister_employee_id()) ) {
				custMgtService.updateCustomer(customerId, custMgtBean);
				CustMgtBean updateCustMgtBean = custMgtService.getCustomerById(customerId);
				return ResponseEntity.status(HttpStatus.OK).body(updateCustMgtBean);
			}
			else {				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	

	}
}
