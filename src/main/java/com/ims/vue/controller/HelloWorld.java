package com.ims.vue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ims.vue.entity.CmsEmployeeBean;
import com.ims.vue.service.HelloWorldService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/hello")
public class HelloWorld {

	@Autowired
	private HelloWorldService service;

	/**
	 * 全検索
	 * 
	 * @param employeeId 社員ID
	 * @param name 社員名
	 * @return List<CmsEmployeeBean>
	 */
	@RequestMapping("/findAll")
	public List<CmsEmployeeBean> findAll(
			@RequestParam String employeeId,
			@RequestParam String name) {
		
		System.out.println(employeeId);
		System.out.println(name);
		
		List<CmsEmployeeBean> ret = new ArrayList<CmsEmployeeBean>();
		try {
			ret = service.findAll(employeeId, name);
		} catch (Exception e) {
			System.out.println(e);
		}
		return ret;
	}
}
