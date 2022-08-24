package com.mybatis3.deep;

public class MapperInterfaceStudentDaoMain {

	public static void main(String[] args) {
		MapperInterfaceStudentDao mapperInterfaceStudentDao=
				new MapperInterfaceStudentDao();
		System.out.println("<<<<<<<<<<<<<< StudentMapper Interface를 사용한Dao메쏘드호출 >>>>>>>>>");
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println("---------findStudentById-----------------------------");
		
	}

}
