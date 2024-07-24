package com.cms.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cms.entity.CmsEmployeeBean;

@Mapper
public interface EmployeeMapper {

	public List<CmsEmployeeBean> findAll(CmsEmployeeBean input);

}
