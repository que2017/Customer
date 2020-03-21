package com.duiyi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

	public void updateCustomer(Customer cust) {
		String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
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
						cust.getDescription(),
						cust.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void deleteCustomerById(String id) {
		String sql = "delete from customer where id=?";
		QueryRunner runner = new QueryRunner(DaoUtil.getSource());
		try {
			runner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void deleteCustomerByIdWithTrans(Connection conn, String id) throws SQLException {
		String sql = "delete from customer where id=?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn, sql, id);
		
	}

	public List<Customer> selectCustomer(Customer cust) {
		String sql = "select * from customer where 1=1";
		List<Object> list = new ArrayList<Object>();
		if (cust.getName() != null && !"".equals(cust.getName())) {
			sql += " and name like ?";
			list.add("%" + cust.getName() + "%");
		}
		if (cust.getGender() != null && !"".equals(cust.getGender())) {
			sql += " and gender=?";
			list.add(cust.getGender());
		}
		if (cust.getType() != null && !"".equals(cust.getType())) {
			sql += " and type=?";
			list.add(cust.getType());
		}
		QueryRunner runner = new QueryRunner(DaoUtil.getSource());
		try {
			if (list.size() > 0) {
				return runner.query(sql, new BeanListHandler<Customer>(Customer.class), list.toArray());
			} else {
				return runner.query(sql, new BeanListHandler<Customer>(Customer.class));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
