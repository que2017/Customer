package com.duiyi.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duiyi.domain.Customer;
import com.duiyi.factory.BasicFactory;
import com.duiyi.service.CustomerService;

public class SelectCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Customer customer = new Customer(request.getParameterMap());
		
		CustomerService service = BasicFactory.getFactory().getInstance(CustomerService.class);
		List<Customer> custList = service.selectCustomers(customer);
		if (custList == null || custList.isEmpty()) {
			return;
		}
		StringBuffer buff = new StringBuffer();
		buff.append("[");
		for (Customer cust : custList) {
			buff.append("{" + cust.toString() + "},");
		}
		String jsonStr = buff.substring(0, buff.length() - 1) + "]";
		response.getWriter().write(jsonStr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
