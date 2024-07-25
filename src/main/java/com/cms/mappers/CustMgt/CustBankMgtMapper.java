package com.cms.mappers.CustMgt;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cms.entity.CustBankMgt.CustBankMgtBean;

@Mapper
public interface CustBankMgtMapper {
	//詳細情報用
	@Select(
	    "SELECT bank_account_id, 	customer_id, 			bank_name, 		bank_branch_name, "
	    	+ " bank_account_name, 	bank_account_num, 	bank_account_memo, "
    		+  "created_date,		 last_modified_date "
	    + " FROM customer_bank "
	    + " WHERE bank_account_id = #{bankAccountId} ")
	public CustBankMgtBean getAccountById(Integer bankAccountId);

}
