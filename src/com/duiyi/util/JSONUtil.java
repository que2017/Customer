package com.duiyi.util;

import java.util.List;

import com.duiyi.domain.Customer;

public class JSONUtil {
	public static String listToJsonString(List<Customer> custList) {
		if (custList == null || custList.isEmpty()) {
			return "";
		}
		StringBuffer buff = new StringBuffer();
		buff.append("[");
		for (Customer cust : custList) {
			buff.append("{" + cust.toString() + "},");
		}
		String jsonStr = buff.substring(0, buff.length() - 1) + "]";
		return jsonStr;
	}
	
	private JSONUtil() {
	}
}
