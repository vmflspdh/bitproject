<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

[fmt:formatDate]
	- java.util.Date객체를 문자열로 변환


<%//테스트용 데이터 준비
Date today = new Date();
pageContext.setAttribute("today",today);  //범위를 지정하지않으면 기본이 pageContext이다.
%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:formatDate value="${today }" pattern="yyyy-MM-dd"/>,
<fmt:formatDate value="${today }" pattern="MM/dd/yyyy"/>


