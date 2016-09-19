<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

 
 <jsp:useBean id="list" type="java.util.List<String>" class="java.util.ArrayList" scope="request"></jsp:useBean>
 <%--vo.Board board = request.getAttribute("board");
 //ㅠㅐㅁㄱㅇrk null이 아니더라도 --%>
 
 
 
 ServletRequest : <%=request.getAttribute("list")%>
 
<%-- board객체는 JspContext에 있다. SessionAttribute처럼 --%>




