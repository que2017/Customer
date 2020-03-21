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

	public void updateCustomer(Customer cust) {
		dao.updateCustomer(cust);
	}

	public void deleteCustomerById(String id) {
		dao.deleteCustomerById(id);
	}

	public void batchDeletCustomerById(String[] ids) {
		// 批量删除要么都删除掉，要么都不删除掉，所有可以采用数据库事务来实现
		Connection conn = DaoUtil.getConnection();
		if (conn == null) {
			return;
		}
		try {
			// 开启数据库事务
			conn.setAutoCommit(false);
			for (String id : ids) {
				dao.deleteCustomerByIdWithTrans(conn, id);
			}
			// 没有异常，提交到数据库批量删除客户信息
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			// 出现异常，回滚
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Customer> selectCustomers(Customer customer) {
		return dao.selectCustomer(customer);
	}

}
