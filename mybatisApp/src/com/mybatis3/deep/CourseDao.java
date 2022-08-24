package com.mybatis3.deep;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Course;

public class CourseDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.mybatis3.dao.mapper.CourseMapper.";

	public CourseDao() {
		try {
			InputStream mybatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Course findCourseByIdWithStudents(Integer courseId) {
		return null;
	}

}
