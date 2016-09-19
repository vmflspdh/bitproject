<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>
 
 <%-- <jsp:useBean>의 scope 속성 사용하기
 	객체를 꺼내거나 저장할 때 사용할 저장소(scope)를 지정하는 속성이다. 
 	저장소(scope)선택하기
 	저장소를 지정하지 않으면  기본이 PageContext이다.
 	해당 JSP페이지에서만ㅅ 사용가능하다.
 	
 	값
 	page : PageContext 저장소
 	request: ServletRequest 저장소
 	session : HttpSesssion 저장소 
 	ㅁplication : ServletContext) 저장소
 --%>
 
 
 <jsp:useBean id="board" class="vo.Board" scope="page"></jsp:useBean>
 
 <%--위 태그를 자바코드로 표현: 
 	vo.Board board = null;
 	if(pageContext.getAttribute("board")!=null){  // 기본으로 JspContext에서 찾는다.
 		board=(vo.Board)pageContext.getAttribute("board");
 	} else {
 		board = new vo.Board();
 		pageContext.setAttribute("board",board); //JspContext 저장소에 보관한다.
 		}
 --%>
 
 
 
 board 게시물: <%=board%>
 Jspcontext : <%=pageContext.getAttribute("board",PageContext.PAGE_SCOPE)%>
 board ==JspContext : <%=pageContext.getAttribute("board",PageContext.PAGE_SCOPE)==board %>
 request : <%=request.getAttribute("board")%>
 HttpSession : <%=session.getAttribute("board")%>
 ServletContext : <%=application.getAttribute("board")%>
 
<%-- board객체는 JspContext에 있다. SessionAttribute처럼 --%>




