package com.cms.service.RequestExps;

import java.util.List;

import com.cms.entity.RequestExps.MgtExpenseBean;
import com.cms.form.RequestExps.MgtExpenseForm;

public interface MgtExpenseService {

	public List<MgtExpenseBean> SelectExpense (MgtExpenseForm form);
}
