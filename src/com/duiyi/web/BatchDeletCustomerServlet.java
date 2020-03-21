package com.duiyi.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duiyi.factory.BasicFactory;
import com.duiyi.service.CustomerService;

public class BatchDeletCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String[] ids = request.getParameter("id").split(",");
		if (ids.length == 0) {
			return;
		}
		CustomerService service = BasicFactory.getFactory().getInstance(CustomerService.class);
		service.batchDeletCustomerById(ids);
		response.getWriter().write("batchDelSucc");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
