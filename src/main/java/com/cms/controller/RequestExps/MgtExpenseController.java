package com.cms.controller.RequestExps;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.form.RequestExps.MgtExpenseForm;
import com.cms.service.RequestExps.MgtExpenseService;

@RestController
@RequestMapping(value = "/MgtExpense")
public class MgtExpenseController {

	@Autowired
	MgtExpenseService service;
	
	@GetMapping("/init")
	public void init (MgtExpenseForm form) {
		
		//部門抽出
		getDepartment();
		//職務抽出
		getPosition();
		
	}

	//部門抽出
	@GetMapping("/getDepartment")
	public Map<String, String> getDepartment() {
		
		return service.getDepartment();
	}

	//職務抽出
	@GetMapping("/getPosition")
	public Map<String, String> getPosition() {
		
		return service.getPosition();
	}
	
	

	@PostMapping("/SelectExpense")
	public List<MgtExpenseForm> SelectExpense(@RequestParam(required = false) String test ) {
		
		return service.SelectExpense(test);
	}
}
