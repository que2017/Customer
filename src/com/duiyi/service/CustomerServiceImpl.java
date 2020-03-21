package com.duiyi.service;

import java.util.List;

import com.duiyi.dao.CustomerDao;
import com.duiyi.domain.Customer;
import com.duiyi.exception.MsgException;
import com.duiyi.factory.BasicFactory;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao = BasicFactory.getFactory().getInstance(CustomerDao.class);

	public void addCustomer(Customer cust) throws MsgException {
		// 判断客户是否已经存在
		if (dao.findCustomerByName(cust.getName()) != null) {
			throw new MsgException("客户名称已存在！！！");
		}
		// 如果不存在则添加客户信息到数据库
		dao.addCustomer(cust);
	}

	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

	public void update(Customer cust) {
		dao.update(cust);
	}

}
