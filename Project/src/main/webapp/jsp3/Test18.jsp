<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

<% //테스트용 데이터 준비
%>
<jsp:useBean id="board" class="vo.Board" scope="page"/>
<jsp:setProperty name="board" property="no" value="10" />
<jsp:setProperty name="board" property="title" value="제목입니다." />
<jsp:setProperty name="board" property="contents" value="내용입니다." />
<jsp:setProperty name="board" property="viewCount" value="15" />

<%-- 객체, 배열, list, Map에서 값 꺼내는 방법
	 --%>



\${board} : ${board}
\${board.getNo()} :${board.getNo()}
\${board.no} : ${board.no}
\${board["no"]} : ${board["no"]}
\${board['no']}  :${board['no']} 
