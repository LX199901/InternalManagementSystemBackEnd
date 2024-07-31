package com.cms.service.CustMgt;

import java.util.ArrayList;
import java.util.List;

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
	public List<CustMgtContactBean> getContactsByCustomerId(Integer customerId) {
		log.debug("CustMgtContactServiceImpl.getContactsByCustomerId ({})", customerId);
		List<CustMgtContactBean> contactsList = new ArrayList<>();

		try {
			contactsList = custMgtContactMapper.getContactsByCustomerId(customerId);
			if (contactsList!= null && !contactsList.isEmpty() &&  contactsList.get(0) != null) {
				log.debug("CustMgtContactServiceImpl.getContactsByCustomerId ({}) got contact.", customerId);
				return contactsList;
			} else {
				log.debug("CustMgtContactServiceImpl.getContactsByCustomerId ({}) got nothing.", customerId);
				return new ArrayList<>(); 
			}
		} catch (Exception e) {
			log.debug("CustMgtContactServiceImpl.getContactsByCustomerId ({}) encountered an exception: {}", customerId,  e.getMessage());
			return new ArrayList<>(); 
		}
	}

	@Override
	public Integer createContact(CustMgtContactBean custMgtContactBean) {
		log.debug("CustMgtContactServiceImpl.createContact");
		return custMgtContactMapper.createContact(custMgtContactBean);
	}

	@Override
	public void updateContact(Integer contactId, CustMgtContactBean custMgtContactBean) {
		custMgtContactMapper.updateContact(contactId, custMgtContactBean);
	}

	@Override
	public void deleteContact(Integer contactId) {
		custMgtContactMapper.deleteContact(contactId);
	}

}
