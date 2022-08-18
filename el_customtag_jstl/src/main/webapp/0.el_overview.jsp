<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.bean.User"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/***********String,Wrapper속성객체******************/
	request.setAttribute("a", new String("속성객체"));
	request.setAttribute("b", new Integer(2));
	request.setAttribute("c", new Boolean(true));
	request.setAttribute("d", "속성객체2");
	request.setAttribute("e", 3);			// auto boxing
	request.setAttribute("f", false);		// auto boxing
	/***********자바빈 속성객체******************/
	request.setAttribute("guest", new Guest(1,"KIM","2022/03","guard@email.com","http://www.google.com","타이틀","컨텐트"));
	request.setAttribute("user", new User("guard","1111","가아드","kang@naver.com"));
	/********List(array)속성객체*****************/
	List<Guest> guestList=new ArrayList<Guest>();
	guestList.add(new Guest(10,"KIM","2022/03","guard10@email.com","http://www.google.com","타이틀10","컨텐트10"));
	guestList.add(new Guest(20,"JIM","2022/07","guard20@email.com","http://www.google.com","타이틀20","컨텐트20"));
	guestList.add(new Guest(30,"MIM","2022/09","guard30@email.com","http://www.google.com","타이틀30","컨텐트30"));
	request.setAttribute("guestList", guestList);
	/********Map 속성객체*****************/
	Map<String,Guest> guestMap=new HashMap<String,Guest>();
	guestMap.put("g1", new Guest(90,"SIM","2022/03","guard90@email.com","http://www.google.com","타이틀90","컨텐트90"));
	guestMap.put("g2", new Guest(91,"FIM","2022/08","guard91@email.com","http://www.google.com","타이틀91","컨텐트91"));
	guestMap.put("g3", new Guest(92,"VIM","2022/01","guard92@email.com","http://www.google.com","타이틀92","컨텐트92"));
	request.setAttribute("guestMap", guestMap);
	
	/*************JSP local변수******************/
	String str1="난 JSP로칼변수";
	int int1=1234;
	User user1=new User("KANG","2222","2022-03","kang@naver.com");
	
	
	
	/*
	속성(attribute)객체
		- 속성객체이름: a,b,c,d,e,f,guest,user,guestList,guestMap
	*/

%>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language)</h1><hr>
<ul>
	<li>#########NO EL(EL을 사용하지않았을때)##########</li>
	<li>------------String,Wrapper---------------</li>
	<li><%=request.getAttribute("a")%></li>
	<li><%=request.getAttribute("b")%></li>
	<li><%=request.getAttribute("c")%></li>
	<li><%=request.getAttribute("d")%></li>
	<li><%=request.getAttribute("e")%></li>
	<li><%=request.getAttribute("f")%></li>
	<li>------------java Bean---------------</li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_no()%></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_name()%></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_email()%></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_homepage()%></li>
	<li><%=((User)request.getAttribute("user")).getUserId()%></li>
	<li><%=((User)request.getAttribute("user")).getPassword()%></li>
	<li><%=((User)request.getAttribute("user")).getName()%></li>
	<li><%=((User)request.getAttribute("user")).getEmail()%></li>
	<li>------------List---------------</li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_no()%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_name()%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_email()%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_homepage()%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_title()%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_content()%></li>
	<li>------------Map---------------</li>
	<li><%=((Map<String,Guest>)request.getAttribute("guestMap")).get("g1").getGuest_no() %></li>
	<li><%=((Map<String,Guest>)request.getAttribute("guestMap")).get("g1").getGuest_name() %></li>
	<li><%=((Map<String,Guest>)request.getAttribute("guestMap")).get("g1").getGuest_email() %></li>
	<li><%=((Map<String,Guest>)request.getAttribute("guestMap")).get("g1").getGuest_homepage() %></li>
	<li><%=((Map<String,Guest>)request.getAttribute("guestMap")).get("g1").getGuest_title() %></li>
	<li><%=((Map<String,Guest>)request.getAttribute("guestMap")).get("g1").getGuest_content() %></li>
	<li>------------JSP service안에선언된 local변수--------------</li>
	<li><%=str1%></li>
	<li><%=int1%></li>
	<li><%=user1.getUserId()%></li>
	<li><%=user1.getPassword()%></li>
	<li><%=user1.getEmail()%></li>
	<li><%=user1.getName()%></li>
	
	<li>######### EL사용 ##########</li>
	<li>------------String,Wrapper---------------</li>
	<li>${a}</li>
	<li>${b}</li>
	<li>${c}</li>
	<li>${d}</li>
	<li>${e}</li>
	<li>${f}</li>
	<li>------------java Bean---------------</li>
	<li>${guest.getGuest_no()}</li>
	<li>${guest.getGuest_name()}</li>
	<li>${guest.getGuest_email()}</li>
	<li>${guest.getGuest_homepage()}</li>
	<li>${guest.getGuest_title()}</li>
	<li>${guest.getGuest_content()}</li>
	
	<li>${user.userId}</li>
	<li>${user.password}</li>
	<li>${user.name}</li>
	<li>${user.email}</li>
	<li>------------List---------------</li>
	<li>${guestList.get(0).getGuest_no()}</li>
	<li>${guestList[0].guest_name}</li>
	<li>${guestList[0].guest_email}</li>
	<li>${guestList[0].guest_homepage}</li>
	<li>${guestList[0].guest_title}</li>
	<li>${guestList[0].guest_content}</li>
	
	<li>------------Map---------------</li>
	<li>${guestMap.g1.guest_no}</li>
	<li>${guestMap["g1"].guest_name}</li>
	<li>${guestMap.g1.guest_email}</li>
	<li>${guestMap.g1.guest_homepage}</li>
	<li>${guestMap.g1.guest_title}</li>
	<li>${guestMap.g1.guest_content}</li>
	<li>------------JSP service안에선언된 local변수 EL로는 출력 불가능--------------</li>
	<li>${str1}</li>
	<li>${int1}</li>
	<li>${user1.getUserId()}</li>
	<li>${user1.getPassword()}</li>
	<li>${user1.getEmail()}</li>
	<li>${user1.getName()}</li>
	
</ul>
</body>
</html>








