package com.cms.mappers.CustMgt;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cms.entity.CustMgt.CustMgtBean;
import com.cms.entity.CustMgt.CustMgtQueryBean;

@Mapper
public interface CustMgtMapper {

	//詳細情報用
	@Select(
	    "SELECT customer_id,		 customer_name, 	customer_serial, 	customer_tel, "
    		+  "customer_dep_name,	 customer_dep_tel, 	customer_dep_addr, 	register_employee_id, "
    		+  "created_date,		 last_modified_date "
	    + " FROM customer "
	    + " WHERE customer_id = #{customerId} ")
	public CustMgtBean getCustomerById(Integer customerId);

	//顧客検索用
	@Select({
	    "<script>",
	    "SELECT customer_id,		 customer_name, 	customer_serial, 	customer_dep_name ",
	    "FROM ",
	    "    customer ",
	    "WHERE ",
	    "    register_employee_id = #{employeeId} ",
        "    <if test='customerId != null'>",
        "        AND customer_id = #{customerId} ",
        "    </if>",
        "    <if test='customerSerial != null'>",
        "        AND customer_serial = #{customerSerial} ",
        "    </if>",
        "    <if test='customerName != null'>",
        "        AND customer_name LIKE CONCAT('%', #{customerName}, '%') ",
        "    </if>",
        "    <if test='customerDepName != null'>",
        "        AND customer_dep_name LIKE CONCAT('%', #{customerDepName}, '%') ",
        "    </if>",
	    "ORDER BY ",
	    "    customer_id ",
	    "</script>"
	})
	public List<CustMgtQueryBean> getCustomersByEmployeeId(Integer employeeId, Integer customerId, String customerSerial, String customerName, String customerDepName);
	
	//新規顧客
	@Insert(
		"INSERT INTO customer ("
			+ " customer_name, 		 customer_serial, 	customer_tel, "
			+ "	customer_dep_name,	 customer_dep_tel, 	customer_dep_addr, 	register_employee_id "
			+ "	) "
		+ "VALUES ( "
			+ " #{customer_name}, 		#{customer_serial}, 	#{customer_tel}, "
			+ "	#{customer_dep_name},	#{customer_dep_tel}, 	#{customer_dep_addr}, 	#{register_employee_id} )")
	 @Options(useGeneratedKeys = true, keyProperty = "customer_id")
	public Integer createCustomer(CustMgtBean custMgtBean);

	
	//顧客更新
	@Update("UPDATE customer " +
        "SET  customer_name 		= #{custMgtBean.customer_name},"
	        + "	customer_serial 	= #{custMgtBean.customer_serial}, "
	        + "	customer_tel 		= #{custMgtBean.customer_tel}, "
	        + "	customer_dep_name 	= #{custMgtBean.customer_dep_name}, "
	        + "	customer_dep_tel 	= #{custMgtBean.customer_dep_tel}, "
	        + "	customer_dep_addr 	= #{custMgtBean.customer_dep_addr}, "
	        + "	last_modified_date 	= CURRENT_TIMESTAMP " 
        + " WHERE customer_id = #{customerId} AND register_employee_id = #{custMgtBean.register_employee_id}")
	public void updateCustomer(Integer customerId, CustMgtBean custMgtBean);

	
	

}
