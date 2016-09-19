<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

[c:import]
	- HTTP 요청을 수행하는 방법


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--https://search.naver.com/search.naver?where=nexearch&ie=utf8&query=java&sm=tab_stc --%>
<c:url var="testurl" value="https://search.naver.com/search.naver" >
	<c:param name="where" value="nexearch"/>
	<c:param name="ie" value="utf8"/>
	<c:param name="query" value="java"/>
	<c:param name="sm" value="tab_stc"/>
	
</c:url>

<c:import url="${testurl}"/>
<%-- url로 지정된 서버에 요청한 후 서버로부터 받은 결과를"contents"라는 이름으로 저장한다.
	변수명을 지정하지않으면 바로출력한다. --%>












