package com.duiyi.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.duiyi.dao.CustomerDao;
import com.duiyi.domain.Customer;
import com.duiyi.exception.MsgException;
import com.duiyi.factory.BasicFactory;
import com.duiyi.util.DaoUtil;

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

	public void updateCustomer(Customer cust) {
		dao.updateCustomer(cust);
	}

	public void deleteCustomerById(String id) {
		dao.deleteCustomerById(id);
	}

	public void batchDeletCustomerById(String[] ids) {
		// ����ɾ��Ҫô��ɾ������Ҫô����ɾ���������п��Բ������ݿ�������ʵ��
		Connection conn = DaoUtil.getConnection();
		if (conn == null) {
			return;
		}
		try {
			// �������ݿ�����
			conn.setAutoCommit(false);
			for (String id : ids) {
				dao.deleteCustomerByIdWithTrans(conn, id);
			}
			// û���쳣���ύ�����ݿ�����ɾ���ͻ���Ϣ
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			// �����쳣���ع�
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Customer> selectCustomers(Customer customer) {
		return dao.selectCustomer(customer);
	}

}
