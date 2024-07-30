package com.cms.service.RequestExps;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.form.RequestExps.MgtExpenseForm;
import com.cms.mappers.RequestExps.MgtExpenseMapper;

@Service
public class MgtExpenseServicelmpl implements MgtExpenseService {

	@Autowired
	MgtExpenseMapper mapper;

	@Override
	public List<MgtExpenseForm> SelectExpense(String test) {

		List<MgtExpenseForm> ExpenseList = new ArrayList<>();
		
		ExpenseList = setMock();
		
		return ExpenseList;
	}

	@Override

	public Map<String, String> getDepartment() {

		Map<String, String> DepartmentMap = new HashMap<>();

		DepartmentMap.put("1", "総務部");
		DepartmentMap.put("2", "人事部");
		DepartmentMap.put("3", "営業部");

		return DepartmentMap;
	}

	@Override
	public Map<String, String> getPosition() {

		Map<String, String> PositionMap = new HashMap<>();

		PositionMap.put("1", "社長");
		PositionMap.put("2", "部長");
		PositionMap.put("3", "課長");

		return PositionMap;
	}

	public List<MgtExpenseForm> setMock() {

		List<MgtExpenseForm> list = new ArrayList<>();

		MgtExpenseForm Form1 = new MgtExpenseForm();
		MgtExpenseForm Form2 = new MgtExpenseForm();
		MgtExpenseForm Form3 = new MgtExpenseForm();
		
		
		// 创建一个 Date 对象
		Date applicationDate1 = new Date(2024 - 1900, 0, 2);
		Date applicationDate2 = new Date(2024 - 1900, 1, 2);
		Date applicationDate3 = new Date(2024 - 1900, 2, 2);
		
		  // 创建一个 SimpleDateFormat 对象
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");

        // 将 Date 对象格式化为字符串
        String formattedDate1 = dateFormat1.format(applicationDate1);
        String formattedDate2 = dateFormat2.format(applicationDate2);
        String formattedDate3 = dateFormat3.format(applicationDate3);
		 
		
		BigDecimal totalAmount1 = new BigDecimal("50000");
		BigDecimal totalAmount2 = new BigDecimal("60000");
		BigDecimal totalAmount3 = new BigDecimal("70000");
		
		Form1.setCompany_name("野村証券");
		Form1.setExpense_application_id(1001);
		Form1.setEmployee_id(1);
		Form1.setName("张三");
		Form1.setDepartment("総務部");
		Form1.setPosition("社長");
		Form1.setApplication_date(formattedDate1);
		Form1.setTotal_amount(totalAmount1);
		Form1.setProcessing_status("承認まち");
		Form1.setSettlement_amount(totalAmount1);
		
		Form2.setCompany_name("NTTデータ");
		Form2.setExpense_application_id(1002);
		Form2.setEmployee_id(2);
		Form2.setName("李四");
		Form2.setDepartment("人事部");
		Form2.setPosition("部長");
		Form2.setApplication_date(formattedDate2);
		Form2.setTotal_amount(totalAmount2);
		Form2.setProcessing_status("承認済み");
		Form2.setSettlement_amount(totalAmount2);
		
		Form3.setCompany_name("富士通");
		Form3.setExpense_application_id(1003);
		Form3.setEmployee_id(3);
		Form3.setName("王五");
		Form3.setDepartment("営業部");
		Form3.setPosition("課長");
		Form3.setApplication_date(formattedDate3);
		Form3.setTotal_amount(totalAmount3);
		Form3.setProcessing_status("清算中");
		Form3.setSettlement_amount(totalAmount3);
		
		list.add(Form1);
		list.add(Form2);
		list.add(Form3);

		return list;
	}

}
