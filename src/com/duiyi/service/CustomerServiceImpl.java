package com.duiyi.service;

import java.util.List;

import com.duiyi.dao.CustomerDao;
import com.duiyi.domain.Customer;
import com.duiyi.exception.MsgException;
import com.duiyi.factory.BasicFactory;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao = BasicFactory.getFactory().getInstance(CustomerDao.class);

	public void addCustomer(Customer cust) throws MsgException {
		// �жϿͻ��Ƿ��Ѿ�����
		if (dao.findCustomerByName(cust.getName()) != null) {
			throw new MsgException("�ͻ������Ѵ��ڣ�����");
		}
		// �������������ӿͻ���Ϣ�����ݿ�
		dao.addCustomer(cust);
	}

	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

	public void update(Customer cust) {
		dao.update(cust);
	}

}
