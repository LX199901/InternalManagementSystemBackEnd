package com.cms.service.CustBankMgt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.CustBankMgt.CustBankMgtBean;
import com.cms.mappers.CustMgt.CustBankMgtMapper;

@Service
public class CustBankMgtServiceImpl implements CustBankMgtService {
	
	private final static Logger log = LoggerFactory.getLogger(CustBankMgtService.class);

	@Autowired
	private CustBankMgtMapper custBankMgtMapper;
	
	@Override
	public CustBankMgtBean getAccountById(Integer bankAccountId) {
		log.debug("CustBankMgtService.getAccountById (bankAccountId = {}) start searching.", bankAccountId);
		return custBankMgtMapper.getAccountById(bankAccountId);
	}

}
