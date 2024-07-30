package com.cms.mappers.RequestExps;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cms.entity.RequestExps.MgtExpenseBean;
import com.cms.form.RequestExps.MgtExpenseForm;

@Mapper
public interface MgtExpenseMapper {

	List<MgtExpenseBean> SelectExpense(MgtExpenseForm form);
}
