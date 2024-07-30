package com.cms.form.RequestExps;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MgtExpenseForm {

	//テストする際に使用
	String test;
	
	//経費申請ID
	int expense_application_id;
	
	//会社名称
	String company_name;
	
	//社員ID
	int employee_id;
	
	//社員名
	String name;
	
	//部門
	String department;
	
	//職務
	String position;
	
	//申請日
	String application_date;
	
	//総金額
	BigDecimal total_amount;
	
	//処理状態
	String processing_status;
	
	//精算金額
	BigDecimal settlement_amount;
	
}
