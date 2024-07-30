package com.cms.service.SalaryMgt;

import java.util.List;

import com.cms.entity.SalaryMgt.SalaryMgtBean;
import com.cms.form.CustMgt.SalaryMgt.SalaryMgtForm;

public interface SalaryMgtService {

	List<SalaryMgtBean> getSalaryRecord(SalaryMgtForm form);
	
	Integer getSalaryTotal(SalaryMgtForm form);
}
