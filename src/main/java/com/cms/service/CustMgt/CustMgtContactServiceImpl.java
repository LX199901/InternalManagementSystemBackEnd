package com.cms.service.CustMgt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.CustMgt.CustMgtContactBean;
import com.cms.mappers.CustMgt.CustMgtContactMapper;

@Service
public class CustMgtContactServiceImpl implements CustMgtContactService{
	
	@Autowired
	private CustMgtContactMapper custMgtContactMapper;
	
	private static final Logger log = LoggerFactory.getLogger(CustMgtContactServiceImpl.class);

	@Override
	public CustMgtContactBean getContactById(Integer contactId) {
		log.debug("CustMgtContactServiceImpl.getContactById (contactId = {})", contactId);
		return custMgtContactMapper.getContactById(contactId);
	}

	@Override
	public Integer createContact(CustMgtContactBean custMgtContactBean) {
		log.debug("CustMgtContactServiceImpl.createContact");
		return custMgtContactMapper.createContact(custMgtContactBean);
	}

}
