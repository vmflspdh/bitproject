<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

[c:forEach]
	- 여러 조건 테스트할 때 사용한다.

<%
pageContext.setAttribute("names","홍길동,임꺽정,유관순,안중근,윤봉길");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${names}" var="name"  >
${name}:::
</c:forEach>












