package com.cms.mappers.SalaryMgt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cms.entity.SalaryMgt.SalaryMgtBean;
import com.cms.form.CustMgt.SalaryMgt.SalaryMgtForm;

@Mapper
public interface SalaryMgtMapper {

	@Select({
	    "<script>",
	    "SELECT *",
	    "FROM employees e",
	    "LEFT JOIN salary s ON e.employee_id = s.employee_id",
	    "<where>",
	    "<if test='salary_date != null and salary_date != \"\"'>",
	    "  AND s.payment_date LIKE CONCAT(#{salary_date}, '%')",
	    "</if>",
	    "<if test='department_id > 0'>",
	    "  AND e.department_id = #{department_id}",
	    "</if>",
	    "<if test='position_id > 0'>",
	    "  AND e.position_id = #{position_id}",
	    "</if>",
	    "<if test='param_name != null and param_name != \"\"'>",
	    "  AND e.name LIKE CONCAT('%', #{param_name}, '%')",
	    "</if>",
	    "<if test='param_id > 0'>",
	    "  AND e.employee_id = #{param_id}",
	    "</if>",
	    "</where>",
	    "LIMIT #{page}, #{page_size}",
	    "</script>"
	})
	public List<SalaryMgtBean> getSalaryRecord(SalaryMgtForm form);
	
	
	
	@Select({
	    "<script>",
	    "SELECT count(1)",
	    "FROM employees e",
	    "LEFT JOIN salary s ON e.employee_id = s.employee_id",
	    "<where>",
	    "<if test='salary_date != null and salary_date != \"\"'>",
	    "  AND s.payment_date LIKE CONCAT(#{salary_date}, '%')",
	    "</if>",
	    "<if test='department_id > 0'>",
	    "  AND e.department_id = #{department_id}",
	    "</if>",
	    "<if test='position_id > 0'>",
	    "  AND e.position_id = #{position_id}",
	    "</if>",
	    "<if test='param_name != null and param_name != \"\"'>",
	    "  AND e.name LIKE CONCAT('%', #{param_name}, '%')",
	    "</if>",
	    "<if test='param_id > 0'>",
	    "  AND e.employee_id = #{param_id}",
	    "</if>",
	    "</where>",
	    "</script>"
	})
	public Integer getSalaryTotal(SalaryMgtForm form);
}
