package com.duiyi.dao;

import java.util.List;

import com.duiyi.domain.Customer;

public interface CustomerDao {
	/**
	 * ͨ���ͻ������ݿ��в��ҿͻ�
	 *
	 * @param name �ͻ�����
	 * @return �ͻ�����
	 */
	Customer findCustomerByName(String name);

	/**
	 * ��ӿͻ�
	 *
	 * @param cust �ͻ�����
	 */
	void addCustomer(Customer cust);

	/**
	 * ���������û�
	 *
	 * @return �����û��б�
	 */
	List<Customer> getAllCustomers();

}
