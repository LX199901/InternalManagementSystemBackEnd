package com.cms.service.CustMgt;

import com.cms.entity.CustMgt.CustMgtBean;

public interface CustMgtService {

	CustMgtBean getCustomerById(Integer customerId);

	Integer createCustomer(CustMgtBean custMgtBean);


}
