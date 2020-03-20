package com.duiyi.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.duiyi.domain.Customer;
import com.duiyi.util.DaoUtil;

public class CustomerDaoImpl implements CustomerDao {
	public Customer findCustomerByName(String name) {
		// 从数据库中查找客户
		String sql = "select * from customer where name=?";
		QueryRunner runner = new QueryRunner(DaoUtil.getSource());
		try {
			return runner.query(sql, new BeanHandler<Customer>(Customer.class), name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addCustomer(Customer cust) {
		String sql = "insert into customer values (null,?,?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DaoUtil.getSource());
		try {
			runner.update(sql,
					cust.getName(),
					cust.getGender(),
					cust.getBirthday(),
					cust.getCellphone(),
					cust.getEmail(),
					cust.getPreference(),
					cust.getType(),
					cust.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Customer> getAllCustomers() {
		String sql = "select * from customer";
		QueryRunner runner = new QueryRunner(DaoUtil.getSource());
		try {
			return runner.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
