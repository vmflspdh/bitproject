<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

<%-- 논리연산자 사용 --%>

\${true && false} : ${true && false}
\${true and false} : ${true and false}
\${true || false} : ${true || false}
\${true or false} : ${true or false}
\${!false} : ${!false}
\${not false} : ${not false}
