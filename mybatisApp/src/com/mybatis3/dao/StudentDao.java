package com.mybatis3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mybatis3.domain.Student;

public class StudentDao {
	public StudentDao() {
	}

	/**************************************************
	 * SELECT [student]
	 **************************************************/
	/*
	 select sql의결과타입이 DTO[DTO List] 객체인경우
	 resultType :  DTO
	*/
	public Student findStudentById(Integer studId) {
		return null;
	}

	public List<Student> findAllStudents() {
		return null;
	}

	/*
	 * select sql의결과타입이 DTO[DTO List] 객체인경우
	 * resultMap :  DTO
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		return null;
	}

	public List<Student> findAllStudentsResultMap() {
		return null;
	}

	/**************************************************
	 * SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우
	 * resultMap : studentWithAddressResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		return null;
	}

	/*********************************************************
	 * SELECT[students + courses[course_enrollment] JOIN( 1 : N )
	 ********************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우
	 * resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		return null;
	}

	/**************************************************
	 * INSERT
	 ***************************************************/
	/*
	parameterType: DTO,VO,Domain
	*/
	public int insertStudent(Student student) {
		return 0;
	}

	public int insertStudentBySequence1(Student student) {
		return 0;
	}

	public int insertStudentBySequence2(Student student) {
		return 0;
	}

	/**************************************************
	 * UPDATE
	 ***************************************************/
	/*
	  parameterType: DTO,VO,Domain
	 */
	public int updateStudentById(Student updateStudent) {
		return 0;
	}

	/**************************************************
	 * DELETE
	 ***************************************************/
	/*
	 parameterType: java.lang.Integer,java.lang.String
	 */
	public int deleteStudentById(Integer studId) {
		return 0;
	}

}
