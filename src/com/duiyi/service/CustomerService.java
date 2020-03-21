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

	/**
	 * ����customer�е�������ѯ�ͻ������������ͻ��������Ա�����
	 *
	 * @param customer
	 * @return
	 */
	List<Customer> selectCustomers(Customer customer);

	/**
	 * ����ҳ�뼰ָ���������ҿͻ����ݣ�ÿҳ5��
	 *
	 * @param page
	 */
	List<Customer> pageSelectCustomer(int page, int count, Customer cust);

	/**
	 * ����ָ��������ȡ�ͻ�������
	 *
	 * @return
	 */
	int getTotalNumber(Customer cust);

}
