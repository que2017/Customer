package com.duiyi.dao;

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

}
