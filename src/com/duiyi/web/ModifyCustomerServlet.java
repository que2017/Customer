package com.duiyi.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duiyi.domain.Customer;
import com.duiyi.factory.BasicFactory;
import com.duiyi.service.CustomerService;

public class ModifyCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Customer cust = new Customer(request.getParameterMap());
		cust.setId(Integer.parseInt(request.getParameter("id")));
		// System.out.println(cust.toString());
		CustomerService service = BasicFactory.getFactory().getInstance(CustomerService.class);
		service.updateCustomer(cust);
		response.getWriter().write("modifySucc");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
