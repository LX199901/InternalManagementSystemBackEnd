package com.cms.mappers.CustMgt;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cms.entity.CustMgt.CustMgtBean;

@Mapper
public interface CustMgtMapper {

	@Select(
	    "SELECT customer_id,		 customer_name, 	customer_serial, 	customer_tel, "
    		+  "customer_dep_name,	 customer_dep_tel, 	customer_dep_addr, 	register_employee_id, "
    		+  "created_date,		 last_modified_date "
	    + " FROM customer "
	    + " WHERE customer_id = #{customerId} ")
	public CustMgtBean getCustomerById(Integer customerId);
	
	

}
