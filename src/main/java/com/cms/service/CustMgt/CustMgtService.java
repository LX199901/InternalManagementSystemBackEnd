package com.cms.service.CustMgt;

import java.util.List;

import com.cms.entity.CustMgt.CustMgtBean;

public interface CustMgtService {

	CustMgtBean getCustomerById(Integer customerId);
	
	List<CustMgtBean> getCustomersByEmployeeId(Integer employeeId);

	Integer createCustomer(CustMgtBean custMgtBean);

	void updateCustomer(Integer customerId, CustMgtBean custMgtBean);



}
