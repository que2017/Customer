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

	/**
	 * 根据customer中的条件查询客户，条件包括客户姓名、性别、类型
	 *
	 * @param customer
	 * @return
	 */
	List<Customer> selectCustomers(Customer customer);

	/**
	 * 根据页码及指定条件查找客户数据，每页5条
	 *
	 * @param page
	 */
	List<Customer> pageSelectCustomer(int page, int count, Customer cust);

	/**
	 * 根据指定条件获取客户的总数
	 *
	 * @return
	 */
	int getTotalNumber(Customer cust);

}
