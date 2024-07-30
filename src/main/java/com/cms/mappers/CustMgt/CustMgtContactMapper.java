package com.cms.mappers.CustMgt;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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
		public CustMgtContactBean getContactById(Integer contactId);

		@Insert(
		"INSERT INTO customer_contact "
		+ " (contact_name, contact_tel, contact_mail, 	customer_id)"
		+ "   values ( #{contact_name},  #{contact_tel},  #{contact_mail}, 	#{customer_id}) ")
		@Options(useGeneratedKeys = true, keyProperty = "contact_id")
		public Integer createContact(CustMgtContactBean custMgtContactBean);

}
