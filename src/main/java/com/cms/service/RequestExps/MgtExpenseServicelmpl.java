package com.cms.service.RequestExps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.RequestExps.MgtExpenseBean;
import com.cms.form.RequestExps.MgtExpenseForm;
import com.cms.mappers.RequestExps.MgtExpenseMapper;

@Service
public class MgtExpenseServicelmpl implements MgtExpenseService {

	@Autowired
	MgtExpenseMapper mapper;
	
	
	public List<MgtExpenseBean> SelectExpense(MgtExpenseForm form) {
		
		return null;
	}

}
