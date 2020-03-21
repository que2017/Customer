package com.duiyi.test;

import org.junit.Test;

import com.duiyi.dao.CustomerDao;
import com.duiyi.domain.Customer;
import com.duiyi.factory.BasicFactory;

public class BatchMockCustomerTest {
	@Test
	public void mockCustomerTest() {
		CustomerDao dao = BasicFactory.getFactory().getInstance(CustomerDao.class);
		for (int i = 0; i < 100; i++) {
			Customer cust = new Customer();
			cust.setName("duiyi" + i);
			cust.setGender("ÄÐ");
			cust.setBirthday("1992-09-08");
			cust.setCellphone("189090987676");
			cust.setEmail("aaa@qq.com");
			cust.setPreference("ÀºÇò,×ãÇò");
			cust.setType("°×½ð¿Í»§");
			cust.setDescription("Miaoshucc1");
			dao.addCustomer(cust);
		}
	}
}
