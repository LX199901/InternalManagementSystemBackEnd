package com.cms.service.CustMgt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.CustMgt.CustMgtBean;
import com.cms.mappers.CustMgt.CustMgtMapper;

@Service
public class CustMgtServiceImpl implements CustMgtService{
	
	private final static Logger log = LoggerFactory.getLogger(CustMgtServiceImpl.class);

	@Autowired
	private CustMgtMapper custMgtMapper;

	@Override
	public CustMgtBean getCustomerById(Integer customerId) {
		return custMgtMapper.getCustomerById(customerId);

	}

	@Override
	public Integer createCustomer(CustMgtBean custMgtBean) {
		return custMgtMapper.createCustomer(custMgtBean);
	}

	@Override
	public void updateCustomer(Integer customerId, CustMgtBean custMgtBean) {
		log.debug("CustMgtServiceImpl.updateCustomer: customerId = {}", customerId);
		custMgtMapper.updateCustomer(customerId, custMgtBean);
	}
	
	
}
