package com.duiyi.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtil {
	private static DataSource source = new ComboPooledDataSource();
	
	public static DataSource getSource() {
		return source;
	}
	
	private DaoUtil() {
	}
}
