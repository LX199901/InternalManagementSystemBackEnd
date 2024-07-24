package com.cms.entity.CustMgt;

import java.util.Date;

import lombok.Data;

@Data
public class CustMgtBean {
	private Integer	customer_id ;
	private String	customer_name ;
	private String	customer_serial ;
	private String	customer_tel ;
	private String	customer_dep_name ;
	private String	customer_dep_tel ;
	private String	customer_dep_addr ;
	private	Integer register_employee_id ;
	private	Date created_date ;
	private	Date last_modified_date ;
}
