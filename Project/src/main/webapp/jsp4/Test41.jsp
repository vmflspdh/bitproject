<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

[fmt:parseDate]
	- 문자열을 java.util.Date객체로 변환


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="date1" value="2016-9-8"/>

<fmt:parseDate value="${ date1}" pattern="yyyy-MM-dd" var="dateObj1"/>


<%=pageContext.getAttribute("dateObj1") %>,

<fmt:parseDate value="2016-9-9" pattern="yyyy-MM-dd" var="dateObj2"/>
${dateObj2},
<fmt:parseDate value="9/30/2016" pattern="MM/dd/yyyy" var="dateObj3"/>
${dateObj3},




