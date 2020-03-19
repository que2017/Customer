package com.duiyi.service;

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

}
