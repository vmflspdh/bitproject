<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

<% //테스트용 데이터 준비
ArrayList<String> names = new ArrayList<String>();
names.add("홍길동");
names.add("임꺽정");
names.add("유관순");
names.add("안중근");

pageContext.setAttribute("names",names);
%>


<%-- 객체, 배열, list, Map에서 값 꺼내는 방법
	 --%>


\${names} : ${names}
\${names[1]} :${names[1]}
