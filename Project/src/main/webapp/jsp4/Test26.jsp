<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

[c:out]
	-출력문을 만드는 태그이다.
<%
pageContext.setAttribute("name","홍길동");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:out value="안녕하세요"/>,
<c:out value="${name}"/>,
<c:out value="${'okok'}"/>,
<c:out value="${name2}" default="기본값"/>,
<c:out value="${name2}">기본값</c:out>,
<%-- 태그가 처리되기전에 EL이 먼저 처리된다. --%>






