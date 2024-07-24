package com.cms.service.CustMgt;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.CustMgt.CustMgtBean;
import com.cms.mappers.CustMgt.CustMgtMapper;

@Service
public class CustMgtServiceImpl implements CustMgtService{
	
//	private final static Logger log = LoggerFactory.getLogger(CustMgtServiceImpl.class);

	@Autowired
	private CustMgtMapper custMgtMapper;

	@Override
	public CustMgtBean getCustomerById(Integer customerId) {
//		log.warn("CustMgtServiceImpl.getCustomerById");

		return custMgtMapper.getCustomerById(customerId);

	}
	
	
}
