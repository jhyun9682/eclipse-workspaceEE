<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Car"%>
<%@page import="com.itwill.bean.User"%>
<%@page import="com.itwill.bean.Guest"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Car c=new Car(1,"TESLAR","RED");
	Student s=new Student(1000,"천학생",new Car(1234,"ANANTE","WHITE"));

	Guest g=new Guest(100,"백백백","2022-08-16","guest100@gmail.com","http://www.100.co.kr","오늘은 EL을공부합니다.","참쉽네요");	
	User u=new User("guard","1111","가아드","guard@gmail.com");
	Date d=new Date();
	
	
	request.setAttribute("car", c);
	request.setAttribute("student", s);
	
	request.setAttribute("guest", g);
	request.setAttribute("user", u);
	request.setAttribute("date", d);
	

%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL 자바 Bean객체의 property(멤버변수)출력</h1><hr/>
<ul>
	<li>${car}</li>
	<li>{car.getNo()}:${car.getNo()}</li>
	<li>{car.no}:${car.no}</li>
	<li>${car.model}</li>
	<li>${car.color}</li>
	<li>${student}</li>
	<li>${student.no}</li>
	<li>${student.name}</li>
	<li>${student.car}</li>
	<li>${student.car.no}</li>
	<li>${student.car.model}</li>
	<li>${student.car.color}</li>
	<li>${guest}</li>
	<li>${guest.guest_no}</li>
	<li>${guest.guest_name}</li>
	<li>${user}</li>
	<li>${user.userId}</li>
	<li>${user.email}</li>
	<li>${date}</li>
	<li>${date.getYear()+1900} 년</li>
	<li>${date.year+1900} 년</li>
	<li>${date.month+1} 월</li>
	
</ul>
</body>
</html>