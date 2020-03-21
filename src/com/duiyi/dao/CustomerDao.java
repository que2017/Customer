package com.duiyi.dao;

import java.sql.Connection;
import java.sql.SQLException;
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
	 * ����idɾ���ͻ���Ϣ���������ݿ���������
	 *
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	void deleteCustomerByIdWithTrans(Connection conn, String id) throws SQLException;

	/**
	 * ����customer�е�������ѯ�ͻ������������ͻ��������Ա�����
	 *
	 * @param customer
	 * @return
	 */
	List<Customer> selectCustomer(Customer customer);

}
