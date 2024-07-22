package com.ims.react.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.react.mappers.EmployeeMapper;
import com.ims.vue.entity.CmsEmployeeBean;

import io.micrometer.common.util.StringUtils;

@Service
public class EmployeeListServiceImpl implements EmployeeListService {

	@Autowired 
	EmployeeMapper map;
	
	public List<CmsEmployeeBean> findAll(String name, String birthday) {
		CmsEmployeeBean input = new CmsEmployeeBean();

		if (StringUtils.isNotEmpty(name)) {
			input.setName(name);
		}
		if (StringUtils.isNotEmpty(birthday)) {
			input.setBirthday(birthday);
		}
		System.out.println(input.getBirthday());
		return map.findAll(input);
	}

}
