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
		List<CustMgtBean> custMgtBeanList = custMgtMapper.getCustomersByEmployeeId(employeeId);
		List<CustMgtQueryBean> custMgtQueryBeanList = new ArrayList<>();
		        
        for (CustMgtBean custMgtBean : custMgtBeanList) {
            CustMgtQueryBean custMgtQueryBean = new CustMgtQueryBean();
            custMgtQueryBean.setCustomer_id(custMgtBean.getCustomer_id());
            custMgtQueryBean.setCustomer_name(custMgtBean.getCustomer_name());
            custMgtQueryBean.setCustomer_serial(custMgtBean.getCustomer_serial());
            custMgtQueryBean.setCustomer_dep_name(custMgtBean.getCustomer_dep_name());
            custMgtQueryBeanList.add(custMgtQueryBean);
        }
        
        return custMgtQueryBeanList;
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
