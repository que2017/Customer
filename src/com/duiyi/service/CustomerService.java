package com.duiyi.service;

import java.util.List;

import com.duiyi.domain.Customer;
import com.duiyi.exception.MsgException;

public interface CustomerService {
	/**
	 * ��ӿͻ�
	 *
	 * @param cust �ͻ�����
	 * @throws MsgException 
	 */
	void addCustomer(Customer cust) throws MsgException;

	/**
	 * ��ѯ���пͻ�
	 *
	 * @return �ͻ��б�
	 */
	List<Customer> getAllCustomers();

	/**
	 * ���¿ͻ���Ϣ
	 *
	 * @param cust
	 */
	void updateCustomer(Customer cust);

	/**
	 * ����idɾ���ͻ���Ϣ
	 *
	 * @param id
	 */
	void deleteCustomerById(String id);

	/**
	 * ����id�ַ������飬����ɾ���ͻ���Ϣ
	 *
	 * @param ids
	 */
	void batchDeletCustomerById(String[] ids);

}
