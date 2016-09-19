<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

<% //테스트용 데이터 준비
%>

<%
pageContext.setAttribute("names",new String[]{"홍길동","임꺽정","유관순","안중근"});
%>

\${names} : ${names}
\${names[2]} :${names[2]}
