package com.cms.entity.SalaryMgt;

import lombok.Data;

@Data
public class SalaryMgtBean {

	private int salary_id;
	private int employee_id;
	private String name;
	private double attendance_days;
	private String working_hours;
	private double basic_salary;
	private double overtime_allowance;
	private double residential_allowance;
	private double transportation_allowance;
	private double other_allowance;
	private double payment;
	private double health_insurance_premium;
	private double pension_insurance_premium;
	private double employment_insurance_premium;
	private double withholding_tax;
	private double deduction;
	private double other_pay;
	private double total_salary;
	private String payment_date;
	private String payment_issue_date;
}
