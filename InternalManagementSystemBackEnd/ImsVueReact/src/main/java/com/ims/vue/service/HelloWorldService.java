package com.ims.vue.service;

import java.util.List;

import com.ims.vue.entity.CmsEmployeeBean;

public interface HelloWorldService {

	public List<CmsEmployeeBean> findAll(String id,String name);
}
