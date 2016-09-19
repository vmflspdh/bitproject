<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

[c:remove]
	- 저장소에 보관된 객체를 제거한다.
<%--	<c:remove var="변수명" scope="저장소" />--%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="name" value="홍길동" scope="request"/>


${name},
<c:remove var="name"  scope="request"/>
${name},






