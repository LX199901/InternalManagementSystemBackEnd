package com.cms.entity.CustBankMgt;

import java.util.Date;

import lombok.Data;

@Data
public class CustBankMgtBean {
	private Integer bank_account_id;
	private Integer customer_id;
	private String bank_name;
	private String bank_branch_name;
	private String bank_account_name;
	private String bank_account_num;
	private String bank_account_memo;
	private Date created_date;
	private Date last_modified_date;
}
