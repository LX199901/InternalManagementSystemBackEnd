package com.cms.form.CustMgt.SalaryMgt;

import lombok.Data;

@Data
public class SalaryMgtForm {

	//工资年月
	String salary_date;
	//部门id
	int department_id;
	//职务id
	int position_id;
	//社员名
	String param_name;
	//社员ID
	int param_id;
	//每页条数
	int page_size;
	//页数
	int page;
	//tabkey
	String tab_key;
}
