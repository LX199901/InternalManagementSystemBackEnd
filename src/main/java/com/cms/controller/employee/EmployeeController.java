package com.cms.controller.employee;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.common.data.ImsResponse;
import com.cms.entity.CmsEmployeeBean;
import com.cms.service.EmployeeListService;

@RestController
@RequestMapping("/react")
public class EmployeeController {

	@Autowired
	private EmployeeListService service;
	private final static Logger log = LoggerFactory.getLogger(EmployeeController.class);
//	
//	@GetMapping("/customers")
//	public ResponseEntity<CustMgtBean> getCustomerById(@RequestParam (defaultValue = "5") Integer customerId){
//		log.warn("CustMgtController.getCustomerById({})", customerId);
//		System.out.println("CustMgtController.getCustomerById");
//
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//	}
		
	@GetMapping("/EmployeeList")
    public ImsResponse<CmsEmployeeBean> selectEmployees(@RequestParam(required = false)String name,@RequestParam(required = false)String birthday) {
		log.warn("name={}, birthday={}",name , birthday);

		List<CmsEmployeeBean> ret = new ArrayList<CmsEmployeeBean>();
		try {
			ret = service.findAll(name, birthday);
		} catch (Exception e) {
			System.out.println(e);
		}
		
        return new ImsResponse<>(ret);
    }
}