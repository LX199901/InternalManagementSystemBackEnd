package com.ims.react.service;

import java.util.List;

import com.ims.vue.entity.CmsEmployeeBean;

public interface EmployeeListService {

	public List<CmsEmployeeBean> findAll(String name,String birthday);
}
