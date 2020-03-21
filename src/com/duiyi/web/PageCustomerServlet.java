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
import com.duiyi.util.JSONUtil;

public class PageCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		CustomerService service = BasicFactory.getFactory().getInstance(CustomerService.class);
		// ��ѯ��ҳ����
		List<Customer> custList = service.pageSelectCustomer(page, 5, null);
		// ��ѯ��������
		int totalCount = service.getTotalNumber(null);
		int totalPage = (totalCount - 1) / 5 + 1;
		// ��֯��JSON��ʽ��data���ظ������
		StringBuffer buff = new StringBuffer();
		buff.append("{'totalCount':'" + totalCount + "',");
		buff.append("'totalPage':'" + totalPage + "',");
		buff.append("'currPage':'" + page + "',");
		buff.append("'list':" + JSONUtil.listToJsonString(custList) + "}");
		response.getWriter().write(buff.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
