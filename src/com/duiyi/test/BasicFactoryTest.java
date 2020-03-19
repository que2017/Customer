package com.duiyi.test;

import org.junit.Test;

import com.duiyi.factory.BasicFactory;
import com.duiyi.service.CustomerService;

public class BasicFactoryTest {
	@Test
	public void getInstanceTest() {
		CustomerService service = BasicFactory.getFactory().getInstance(CustomerService.class);
		System.out.println(service);
	}
}
