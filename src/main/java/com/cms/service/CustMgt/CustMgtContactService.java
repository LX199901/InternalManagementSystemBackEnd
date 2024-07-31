package com.cms.service.CustMgt;

import java.util.List;

import com.cms.entity.CustMgt.CustMgtContactBean;

public interface CustMgtContactService {

	CustMgtContactBean getContactById(Integer contactId);

	List<CustMgtContactBean> getContactsByCustomerId(Integer customerId);

	Integer createContact(CustMgtContactBean custMgtContactBean);

	void updateContact(Integer contactId, CustMgtContactBean custMgtContactBean);

	void deleteContact(Integer contactId);

}
