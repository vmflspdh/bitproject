<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"%>
 템플리데이터1
 템플리데이터2
 <%
 String name = "홍길동";
 %>
 템플리데이터3
 <%= name %>
 템플리데이터4
 템플리데이터5
<%--
	표현식(expressiong element)
	<%= expression%>
	expression? 값을 리턴하는 자바 코드 
	
	예)
	<%= pluse(20,10) %>
	<%= name %>
	<%= 20 +2 %>
	
	Jsp 엔진이 하는일
	<%= name %>	이면----------->	out.println(name);
	
 --%>