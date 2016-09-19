<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

[c:url]
	- URL 쉽게 만들기


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--https://search.naver.com/search.naver?where=nexearch&ie=utf8&query=java&sm=tab_stc --%>
<c:url var="testurl" value="https://search.naver.com/search.naver" >
	<c:param name="where" value="nexearch"/>
	<c:param name="ie" value="utf8"/>
	<c:param name="query" value="java"/>
	<c:param name="sm" value="tab_stc"/>
	
</c:url>
${testurl}












