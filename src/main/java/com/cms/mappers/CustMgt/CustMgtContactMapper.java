package com.cms.mappers.CustMgt;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cms.entity.CustMgt.CustMgtContactBean;

@Mapper
public interface CustMgtContactMapper {

		@Select(
	    "SELECT contact_id, 			contact_name, 		contact_tel, "
    		+  " contact_mail, 			customer_id, "
    		+  " created_date,			last_modified_date "
	    + " FROM customer_contact "
	    + " WHERE contact_id = #{contactId} ")
		public CustMgtContactBean getContactById(Integer contactId);

		@Insert(
		"INSERT INTO customer_contact "
		+ " (contact_name, contact_tel, contact_mail, 	customer_id)"
		+ "   values ( #{contact_name},  #{contact_tel},  #{contact_mail}, 	#{customer_id}) ")
		@Options(useGeneratedKeys = true, keyProperty = "contact_id")
		public Integer createContact(CustMgtContactBean custMgtContactBean);

		@Update("UPDATE customer_contact " +
		        "SET  contact_name 		= #{custMgtContactBean.contact_name},"
			        + "	contact_tel 		= #{custMgtContactBean.contact_tel}, "
			        + "	contact_mail 	= #{custMgtContactBean.contact_mail}, "
			        + "	last_modified_date 	= CURRENT_TIMESTAMP " 
		        + " WHERE contact_id = #{contactId} AND customer_id = #{custMgtContactBean.customer_id}")
		public void updateContact(Integer contactId, CustMgtContactBean custMgtContactBean);
		


}
