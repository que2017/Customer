package com.duiyi.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duiyi.domain.Customer;
import com.duiyi.exception.MsgException;
import com.duiyi.factory.BasicFactory;
import com.duiyi.service.CustomerService;

public class AddCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���������������Ӧ��������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Customer cust = new Customer(request.getParameterMap());
		// ��ȡservice����
		CustomerService service = BasicFactory.getFactory().getInstance(CustomerService.class);
		// ��ӿͻ�
		try {
			service.addCustomer(cust);
			response.getWriter().write("addSucc");
		} catch (MsgException e) {
			response.getWriter().write(e.getMessage().toString());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
