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
import com.cms.entity.CmsEmployeeBean;
import com.cms.form.CustMgt.SalaryMgt.SalaryMgtForm;
import com.cms.service.EmployeeListService;

@RestController
@RequestMapping("/react/salary")
public class SalaryMgtController {
	@Autowired
	private EmployeeListService service;
	private final static Logger log = LoggerFactory.getLogger(CustMgtController.class);
	
	@PostMapping("/select")
    public ImsResponse<CmsEmployeeBean> selectSalary(@RequestBody SalaryMgtForm form) {
		log.warn("form",form);
		List<CmsEmployeeBean> ret = new ArrayList<CmsEmployeeBean>();
		try {
			ret = service.findAll(form.getParam_name(), form.getSalary_date());
		} catch (Exception e) {
			System.out.println(e);
		}
		
        return new ImsResponse<>(ret);
    }
}
