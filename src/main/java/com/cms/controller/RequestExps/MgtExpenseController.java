package com.cms.controller.RequestExps;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.entity.RequestExps.MgtExpenseBean;
import com.cms.form.RequestExps.MgtExpenseForm;
import com.cms.service.RequestExps.MgtExpenseService;

@Controller
@RequestMapping(value = "/MgtExpense")
public class MgtExpenseController {

	@Autowired
	MgtExpenseService service;

	//部門抽出
	@GetMapping("/getDepartment")
	public List<Map<String, String>> getDepartment() {
		return null;
	}

	//職務抽出
	@GetMapping("/getPosition")
	public List<Map<String, String>> getgetPosition() {
		return null;
	}

	@PostMapping("/SelectExpense")
	public List<MgtExpenseBean> SelectExpense(MgtExpenseForm form) {

		return null;
	}
}
