package com.cms.service.CustMgt;

import com.cms.entity.CustMgt.CustMgtContactBean;

public interface CustMgtContactService {

	CustMgtContactBean getContactById(Integer contactId);

	Integer createContact(CustMgtContactBean custMgtContactBean);

}
