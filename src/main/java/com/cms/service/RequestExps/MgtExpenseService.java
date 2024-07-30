package com.cms.service.RequestExps;

import java.util.List;
import java.util.Map;

import com.cms.form.RequestExps.MgtExpenseForm;

public interface MgtExpenseService {

	public List<MgtExpenseForm> SelectExpense (String test);
	
	public Map<String, String> getDepartment();
	
	public Map<String, String> getPosition();
	
}
