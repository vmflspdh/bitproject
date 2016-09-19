<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

<jsp:useBean id="board" class="vo.Board" scope="request"/>
<jsp:setProperty name="board" property="no" value="10" />
<jsp:setProperty name="board" property="title" value="제목입니다." />
<jsp:setProperty name="board" property="contents" value="내용입니다." />
<jsp:setProperty name="board" property="viewCount" value="15" />

<%-- EL(Expretion Language) 리터럴(literal)표현식
	EL에서 값 표기법
	 --%>


문자열${"홍길동"}
문자열${'홍길동'}
숫자${20}
숫자${3.14}
참 거짓: ${true} , ${false}
null ${null} (null은 빈 문자열을 리턴한다.)