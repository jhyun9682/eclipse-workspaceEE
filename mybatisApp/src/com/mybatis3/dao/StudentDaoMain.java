package com.mybatis3.dao;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		/**************************************************
	 	 SELECT 
		 **************************************************/
		/*
		  select sql의결과타입이 DTO[DTO List] 객체인경우
		  resultType :  Dto
		 */
		System.out.println("---------findStudentById-----------------------------");
		System.out.println("---------findAllStudents-----------------------------");
		/*
		  select sql의결과타입이 DTO[DTO List] 객체인경우
		  resultMap :  DTO
		 */
		
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println("---------findAllStudentsResultMap--------------------");
		
		/**************************************************
	 	 SELECT[student + address JOIN]( 1 : 1 )
		 **************************************************/
		/*
		 * select sql의결과타입이 DTO,VO,Domain객체인경우
		 * resultMap : studentWithAddressResultMap
		 */
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println("---------findStudentByIdWithCourses------------------");
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudent(Dto)--------------------------");
		System.out.println("---------insertStudentBySequence1--------------------");
		System.out.println("---------insertStudentBySequence2--------------------");
		/**************************************************
		 UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		
		
		
	}
}
