package com.itwill.toy.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


public class DataSourceUtil {
	
	public static DataSource getDataSource() {
		Properties properties = new Properties();
		BasicDataSource basicDataSource = new BasicDataSource();
		
		try {
			properties.load(DataSourceUtil.class.getResourceAsStream("jdbc.properties"));
			
			/***** Apache DataSource[commons-dbcp2] ***/
			basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
			basicDataSource.setUrl(properties.getProperty("url"));
			basicDataSource.setUsername(properties.getProperty("username"));
			basicDataSource.setPassword(properties.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return basicDataSource;
		
	}
}
