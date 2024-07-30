package com.cms.controller.RequestExps;

import java.util.ArrayList;
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
	public List<Map<String, String>> init (MgtExpenseForm form) {
		
		List<Map<String, String>> results = new ArrayList<>();
		
//		//部門抽出
//		getDepartments();
//		//職務抽出
//		getPositions();
//		//処理状態抽出
//		getProcessingStatus();
		
		//部門抽出
		results.add(getDepartments());
		//職務抽出
		results.add(getPositions());
		//処理状態抽出
		results.add(getProcessingStatus());
		
		return results;
		
	}

	//部門抽出
//	@GetMapping("/getDepartments")
	public Map<String, String> getDepartments() {
		
		return service.getDepartments();
	}

	//職務抽出
//	@GetMapping("/getPositions")
	public Map<String, String> getPositions() {
		
		return service.getPositions();
	}
	
	//処理状態抽出
//	@GetMapping("/getProcessingStatus")
	public Map<String, String> getProcessingStatus() {
		
		return service.getProcessingStatus();
	}
	
	

	@PostMapping("/SelectExpense")
	public List<MgtExpenseForm> SelectExpense(@RequestParam(required = false) String test ) {
		
		return service.SelectExpense(test);
	}
}
