<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>
 
 <%-- <jsp:useBean>의 type 속성
 --%>
 
 
 <jsp:useBean id="board" class="vo.Board" scope=" "></jsp:useBean>
 <%--vo.Board board = request.getAttribute("board");
 //ㅠㅐㅁㄱㅇrk null이 아니더라도 --%>
 
 
 board 게시물: <%=board%>
 
 ServletRequest : <%=request.getAttribute("board")%>
 
<%-- board객체는 JspContext에 있다. SessionAttribute처럼 --%>




