package com.cms.controller.SalaryMgt;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.common.data.ImsResponse;
import com.cms.controller.CustMgt.CustMgtController;
import com.cms.entity.SalaryMgt.SalaryMgtBean;
import com.cms.form.CustMgt.SalaryMgt.SalaryMgtForm;
import com.cms.service.SalaryMgt.SalaryMgtService;

@RestController
@RequestMapping("/react/salary")
public class SalaryMgtController {
	@Autowired
	private SalaryMgtService service;
	private final static Logger log = LoggerFactory.getLogger(CustMgtController.class);
	
	@PostMapping("/getSalaryRecord")
    public ImsResponse<SalaryMgtBean> getSalaryRecord(@RequestBody SalaryMgtForm form) {
		log.warn("form",form);
		List<SalaryMgtBean> ret = new ArrayList<SalaryMgtBean>();
		try {
			ret = service.getSalaryRecord(form);
		} catch (Exception e) {
			System.out.println(e);
		}
		
        return new ImsResponse<>(ret);
    }
	
	@PostMapping("/getSalaryTotal")
    public ImsResponse<Integer> getSalaryTotal(@RequestBody SalaryMgtForm form) {
		log.warn("form",form);
		Integer ret = 0;
		try {
			ret = service.getSalaryTotal(form);
		} catch (Exception e) {
			System.out.println(e);
		}
		
        return new ImsResponse<>(ret);
    }
	
	@PostMapping("/calculateSalary")
    public ImsResponse<Integer> calculateSalary(@RequestBody SalaryMgtForm form) {
		log.warn("form",form);
		Integer ret = 0;
		try {
			ret = 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		
        return new ImsResponse<>(ret);
    }
	
	
	
	
	
}
