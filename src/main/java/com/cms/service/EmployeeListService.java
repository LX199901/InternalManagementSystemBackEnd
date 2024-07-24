package com.cms.service;

import java.util.List;

import com.cms.entity.CmsEmployeeBean;

public interface EmployeeListService {

	public List<CmsEmployeeBean> findAll(String name,String birthday);
}
