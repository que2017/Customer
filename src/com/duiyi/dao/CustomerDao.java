package com.duiyi.dao;

import java.util.List;

import com.duiyi.domain.Customer;

public interface CustomerDao {
	/**
	 * 通过客户从数据库中查找客户
	 *
	 * @param name 客户姓名
	 * @return 客户对象
	 */
	Customer findCustomerByName(String name);

	/**
	 * 添加客户
	 *
	 * @param cust 客户对象
	 */
	void addCustomer(Customer cust);

	/**
	 * 查找所有用户
	 *
	 * @return 所有用户列表
	 */
	List<Customer> getAllCustomers();

}
