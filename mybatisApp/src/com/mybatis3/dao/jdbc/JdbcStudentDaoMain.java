package com.mybatis3.dao.jdbc;

import java.util.Date;

import com.mybatis3.domain.Student;

public class JdbcStudentDaoMain {

	public static void main(String[] args) {

		JdbcStudentDao jdbcStudentDao = new JdbcStudentDao();
		System.out.println("----findStudentById---");
		Student findStudent = jdbcStudentDao.findStudentById(1);
		System.out.println(">>> "+findStudent);
		System.out.println("----createStudent---");
		long ts = System.currentTimeMillis();// For creating unique student
		Student newStudent = new Student(0, "student_" + ts, "student_" + ts + "@gmail.com", new Date(),null);
		int rowCount=jdbcStudentDao.createStudent(newStudent);
		System.out.println(">>>"+newStudent);
		
		System.out.println("----updateStudent---");
		int updateStudId = 4;
		Student updateStudent = jdbcStudentDao.findStudentById(updateStudId);
		ts = System.currentTimeMillis();// For creating unique student email
		updateStudent.setEmail("student_" + ts + "@gmail.com");
		jdbcStudentDao.updateStudent(updateStudent);
		System.out.println(">>>"+updateStudent);
		System.out.println("----findStudentList---");
		System.out.println(jdbcStudentDao.findStudentList());
		
	}

}
