package com.ims.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.vue.entity.CmsEmployeeBean;
import com.ims.vue.mappers.HelloWorldMapper;

import io.micrometer.common.util.StringUtils;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Autowired 
	HelloWorldMapper map;
	
	public List<CmsEmployeeBean> findAll(String id, String name) {
		CmsEmployeeBean input = new CmsEmployeeBean();

		if (StringUtils.isNotEmpty(id)) {
			input.setEmployeeId(id);
		}

		if (StringUtils.isNotEmpty(name)) {
			input.setName(name);
		}

		return map.findAll(input);
	}

}
