<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

<%//테스트용 데이터 준비
pageContext.setAttribute("name","홍길동");

%>


<%-- empty 연산자 사용 --%>

\${empty name} : ${empty name}
\${empty name2} : ${empty name2}

[조건 연산자 사용하기]
\${10>20?"크다":"작다"} :${10>20?"크다":"작다"}