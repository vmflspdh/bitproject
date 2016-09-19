<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

<% //테스트용 데이터 준비
HashMap<String,String> nameMap = new HashMap<String,String>();
nameMap.put("s01","홍길동	");
nameMap.put("s02","임꺽정");
nameMap.put("s03","유관순	");
nameMap.put("s04","안중근	");
nameMap.put("s-5","안중2	");

pageContext.setAttribute("nameMap",nameMap);
%>


<%-- 객체, 배열, list, Map에서 값 꺼내는 방법
	 --%>


\${nameMap['s01']} : ${nameMap['s01']}
\${nameMap["s02"]} : ${nameMap["s02"]}
\${nameMap.s03} : ${nameMap.s03}
\${nameMap['s-5']} : ${nameMap['s-5']}
