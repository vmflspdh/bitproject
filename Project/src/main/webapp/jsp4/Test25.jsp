<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>

<%//JSTL 사용기초 %>
1. JSTL이란?
	- JSP 라이브러리에 포함되지 않은 확장라이브러리이다.
	- JSP Standard Tag Library
2. JSTL 사용법
	- JSTL 구현체를 다움로드 받아야 한다.
	- JSP 페이지에 태그 라이브러리를 임포트한다.
	- 그리고 해당 태그를 사용한다.
3. JSTL 태그들
	- Core(c, 기본 문법제공) : http://java.sun.com/jsp/jstl/core
	- I18N(fmt, 라벨처리(다국어 지원 기능)) : http://java.sun.com/jsp/jstl/fmt
	- XML(x, xml다루는기능) : http://java.sun.com/jsp/jstl/xml
	- Database(sql, sql질의 기능) : http://java.sun.com/jsp/jstl/sql
	- Functions(fn, 기타 함수 제공) : http://java.sun.com/jsp/jstl/functions
4. JSTL 태그 임포트 하는 방법
 <%--
<%@ taglib uri="사용할 태그 라이브러리 네임스페이스" prefix="별명"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:out value="안녕하세요"/>







