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

게시물: <%=board%>
(PageContext)게시물2: ${PageScope.board}
(ServletRequest)게시물2: ${requestScope.board}
(HttpSession)게시물2: ${sessionScope.board}
(ServletContext)게시물2: ${applicationScope.board}
범위를 지정하는 객체이름을 생략하면 다음 순서대로 찾는다.
pageScope -> requestScope -> sessionScope -> applicationScope -> 빈문자열 리턴
=> ${board}

<%-- Expression Language
   => ${OGNL 표기법}, #{OGNL 표기법}
   => OGNL(Object Graph Navigation Language)?
   	- 객체의 프로퍼티를 찾아가는 표기법
   	- 예를 들면, 파일 경로와 비슷하다. c:/javaide/workspace/java01/a.txt
   	  예) 객체명.프로퍼티명.프로퍼티명.프로퍼티명  찾아가는 표기법
   	  
   	  
    EL에 미리 정의된 객체
    pageContext: PageContext
    servletContext : ServletContext
    session : Session
    request : ServletRequest
    response : ServletRequest
    param : request.getParameter()
    paramValue : request.getParameterValues()
    header : request.getHeader()
    headerValues : 헤더의값들을 담은 객체
    cookie : 쿠키 정보를 담은객체
    initParam:config.getInitParameter()
    pageScope : JspContext.getAttribute()
    sessionScope : session.getAttribute()
    applicationScope : application.getAttribute() --%>