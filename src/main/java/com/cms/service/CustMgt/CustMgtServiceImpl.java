package com.cms.service.CustMgt;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.CustMgt.CustMgtBean;
import com.cms.entity.CustMgt.CustMgtQueryBean;
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
	public List<CustMgtQueryBean> getCustomersByEmployeeId(Integer employeeId) {
		log.debug("CustMgtServiceImpl.getCustomersByEmployeeId({}) start searching.", employeeId);
		List<CustMgtQueryBean> custMgtQueryBeanList=  new ArrayList<>();
		
		try {
	        custMgtQueryBeanList = custMgtMapper.getCustomersByEmployeeId(employeeId);
	        
	        if (custMgtQueryBeanList != null && !custMgtQueryBeanList.isEmpty() && custMgtQueryBeanList.get(0) != null) {
	            log.debug("CustMgtServiceImpl.getCustomersByEmployeeId({}) got customers.", employeeId);
	            return custMgtQueryBeanList;
	        } else {
	            log.debug("CustMgtServiceImpl.getCustomersByEmployeeId({}) got nothing.", employeeId);
	            return new ArrayList<>(); 
	        }
	        
	    } catch (IndexOutOfBoundsException e) {
	        log.error("CustMgtServiceImpl.getCustomersByEmployeeId({}) encountered an IndexOutOfBoundsException: {}", employeeId, e.getMessage());
	        return new ArrayList<>();
	        
	    } catch (Exception e) {
	        log.error("CustMgtServiceImpl.getCustomersByEmployeeId({}) encountered an exception: {}", employeeId, e.getMessage());
	        return new ArrayList<>(); 
        }
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
