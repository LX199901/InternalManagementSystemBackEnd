package com.cms.mappers.CustMgt;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cms.entity.CustMgt.CustMgtContactBean;

@Mapper
public interface CustMgtContactMapper {

		@Select(
	    "SELECT 	contact_name, 		contact_tel, "
    		+  " contact_mail, 				customer_id, "
    		+  " created_date,				last_modified_date "
	    + " FROM customer_contact "
	    + " WHERE contact_id = #{contactId} ")
		CustMgtContactBean getContactById(Integer contactId);

}
