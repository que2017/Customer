package com.duiyi.service;

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

}
