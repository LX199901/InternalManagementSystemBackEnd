package com.ims.vue.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ims.vue.entity.CmsEmployeeBean;

@Mapper
public interface HelloWorldMapper {

	public List<CmsEmployeeBean> findAll(CmsEmployeeBean input);

}
