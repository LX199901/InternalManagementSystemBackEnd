package com.cms.entity.CustMgt;

import java.util.Date;

import lombok.Data;

@Data
public class CustMgtContactBean {
	private Integer contact_id;
	private String contact_name;
	private String contact_tel;
	private String contact_mail;
	private Integer customer_id;
	private Date created_date;
	private Date last_modified_date;
}
