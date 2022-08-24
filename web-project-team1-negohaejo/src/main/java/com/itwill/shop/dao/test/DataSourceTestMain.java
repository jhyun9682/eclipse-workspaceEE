package com.itwill.shop.dao.test;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DataSourceTestMain {

	public static void main(String[] args)throws Exception {
		BasicDataSource basicDataSource = new BasicDataSource();
		Properties properties=new Properties();
		properties.load(DataSourceTestMain.class.getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		/********************<< javax.sql.DataSource >>**************************/
		DataSource dataSource = (DataSource) basicDataSource;
		Connection con=dataSource.getConnection();
		System.out.println("1.DataSource : "+dataSource);
		System.out.println("2.Connection : "+con);
		
	}

}
