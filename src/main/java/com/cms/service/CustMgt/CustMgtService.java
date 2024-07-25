package com.cms.service.CustMgt;

import java.util.List;

import com.cms.entity.CustMgt.CustMgtBean;
import com.cms.entity.CustMgt.CustMgtQueryBean;

public interface CustMgtService {

	CustMgtBean getCustomerById(Integer customerId);
	
	List<CustMgtQueryBean> getCustomersByEmployeeId(Integer employeeId);

	Integer createCustomer(CustMgtBean custMgtBean);

	void updateCustomer(Integer customerId, CustMgtBean custMgtBean);



}
