package com.mybatis3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mybatis3.domain.Student;

public class StudentDao {
	public StudentDao() {
	}

	/* @@@@@@@@@@@@@@@@@@@@@@@ SELECT JOIN[students + courses] @@@@@@@@@@@@@@@@@ */
	public Student findStudentByIdWithCourses(Integer studId) {
		return null;
	}

	/*
	 * @@@@@@@@@@@@@@@@@@@@@@@ SELECT JOIN[students + addresses] @@@@@@@@@@@@@@@@@
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		return null;
	}

	/* @@@@@@@@@@@@@@@@@@@@@@@ UPDATE @@@@@@@@@@@@@@@@@ */
	public int updateStudentById(Student updateStudent) {
		return 0;
	}

	/* @@@@@@@@@@@@@@@@@@@@@@@DELETE@@@@@@@@@@@@@@@@@ */
	public int deleteStudentById(Integer studId) {

		return 0;
	}

	public int deleteStudentByName(String name) {

		return 0;
	}

	public int deleteStudentByNameLike(String name) {

		return 0;
	}

	/* @@@@@@@@@@@@@@@@@@@@@@@INSERT@@@@@@@@@@@@@@@@@ */
	public int insertStudent(Student student) {

		return 0;
	}

	public int insertStudentBySequence1(Student student) {

		return 0;
	}

	public int insertStudentBySequence2(Student student) {

		return 0;
	}

	/* @@@@@@@@@@@@@@@@@@@@@@@SELECT@@@@@@@@@@@@@@@@@ */
	/*
	 * resultMap
	 */
	public Student findStudentByIdResultMap(Integer studId) {

		return null;
	}

	public List<Student> findAllStudentsResultMap() {

		return null;
	}

	/*
	 * resultType Dto
	 */
	public Student findStudentById(Integer studId) {

		return null;
	}

	public List<Student> findAllStudents() {

		return null;
	}

	public List<Student> findAllOrderedStudents(String columnName) {

		return null;
	}

	/*
	 * resultType Wrapper(String)
	 */
	public String findStudentNameById(Integer userId) {

		return null;
	}

	public List<String> findStudentNameList() {

		return null;
	}

	/*
	 * resultType Map
	 */
	public Map findStudentByIdMap(Integer userId) {

		return null;
	}

	public List<Map> findAllStudentsMapList() {

		return null;
	}

	public List<Student> findStudentByIdRangeParamMap(HashMap idRangeMap) {

		return null;
	}

	public List<Student> findStudentsThreeParamMap(HashMap studentsMap) {

		return null;
	}

	public int updateStudentParamMap(Map studentMap) {

		return 0;
	}

}
