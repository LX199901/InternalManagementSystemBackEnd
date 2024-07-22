package com.ims.react.controller.workhour;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ims.common.data.ImsResponse;
import com.ims.react.service.EmployeeListService;
import com.ims.vue.entity.CmsEmployeeBean;

@RestController
@RequestMapping("/react")
public class WorkHourController {

	@Autowired
	private EmployeeListService service;
	
	@GetMapping("/WorkHourList")
    public ImsResponse<CmsEmployeeBean> selectEmployees(@RequestParam(required = false)String name,@RequestParam(required = false)String birthday) {


		List<CmsEmployeeBean> ret = new ArrayList<CmsEmployeeBean>();
		try {
			ret = service.findAll(name, birthday);
		} catch (Exception e) {
			System.out.println(e);
		}
		
        return new ImsResponse<>(ret);
    }
}