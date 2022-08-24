package com.mybatis3.deep;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.deep.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0.mybatis-config-mapper-interface.xml --> InputStream
		 */
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		/*
		 * 2. SqlSessionFactory
		 */
		/*
		 * 3. SqlSession open
		 */
		/*
		 * autocommit true
		 */
		/*
		 * 4. StudentMapper[MapperInterface]��ü����
		 */
		/*
		org.apache.ibatis.binding.MapperProxy
		 */
		/*
		 * 5. StudentMapper[MapperInterface]��ü���[CRUD]
		 */
		/*
		 * 5. SqlSession close
		 */
	}
}













