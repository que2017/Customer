package com.duiyi.service;

import java.util.List;

import com.duiyi.domain.Customer;
import com.duiyi.exception.MsgException;

public interface CustomerService {
	/**
	 * 添加客户
	 *
	 * @param cust 客户对象
	 * @throws MsgException 
	 */
	void addCustomer(Customer cust) throws MsgException;

	/**
	 * 查询所有客户
	 *
	 * @return 客户列表
	 */
	List<Customer> getAllCustomers();

	/**
	 * 更新客户信息
	 *
	 * @param cust
	 */
	void updateCustomer(Customer cust);

	/**
	 * 根据id删除客户信息
	 *
	 * @param id
	 */
	void deleteCustomerById(String id);

	/**
	 * 根据id字符串数组，批量删除客户信息
	 *
	 * @param ids
	 */
	void batchDeletCustomerById(String[] ids);

}
