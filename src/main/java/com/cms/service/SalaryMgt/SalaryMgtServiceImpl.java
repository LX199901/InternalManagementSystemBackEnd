package com.cms.service.SalaryMgt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.SalaryMgt.SalaryMgtBean;
import com.cms.form.CustMgt.SalaryMgt.SalaryMgtForm;
import com.cms.mappers.SalaryMgt.SalaryMgtMapper;

@Service
public class SalaryMgtServiceImpl implements SalaryMgtService{

	@Autowired
	SalaryMgtMapper mapper;
	
	//检索工资履历,后续追加检索条件
	@Override
	public List<SalaryMgtBean> getSalaryRecord(SalaryMgtForm form) {
		System.out.println(form);
		int offset = (form.getPage() - 1) * form.getPage_size();
	    form.setPage(offset);
    
	    List<SalaryMgtBean> salaryList = mapper.getSalaryRecord(form);
	  
	    return salaryList;
	}
	//获取工资履历件数,后续追加检索条件
	@Override
	public Integer getSalaryTotal(SalaryMgtForm form) {
		
		return mapper.getSalaryTotal(form);
	}

}
