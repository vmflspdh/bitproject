<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>
 
 <% 
 Board obj= new Board();
 obj.setNo(10);
 obj.setTitle("haha");
 obj.setContents("contents...");
 obj.setViewCount(100);
 request.setAttribute("board", obj);
 %>
 
 <jsp:useBean id="board" class="vo.Board" scope="request"></jsp:useBean>
 <%--vo.Board board = request.getAttribute("board");
 //ㅠㅐㅁㄱㅇrk null이 아니더라도 --%>
 
 
 board 게시물: <%=board%>
 
 ServletRequest : <%=request.getAttribute("board")%>
 
<%-- board객체는 JspContext에 있다. SessionAttribute처럼 --%>




