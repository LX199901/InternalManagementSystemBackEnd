package com.ims.react.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ims.vue.entity.CmsEmployeeBean;

@Mapper
public interface EmployeeMapper {

	public List<CmsEmployeeBean> findAll(CmsEmployeeBean input);

}
