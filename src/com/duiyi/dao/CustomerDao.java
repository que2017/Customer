package com.duiyi.dao;

import java.sql.Connection;
import java.sql.SQLException;
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
	 * 根据id删除客户信息，用于数据库事务需求
	 *
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	void deleteCustomerByIdWithTrans(Connection conn, String id) throws SQLException;

	/**
	 * 根据customer中的条件查询客户，条件包括客户姓名、性别、类型
	 *
	 * @param customer
	 * @return
	 */
	List<Customer> selectCustomer(Customer customer);

}
