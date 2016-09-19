<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>

<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"
    	trimDirectiveWhitespaces="true"%>
    	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--experssion language에 포함 --%>
text1=${param.text1}
password1=${param.password1}
hidden1=${param.hidden1}
hobby1=${param.hobby1}
hobby2=${param.hobby2}
hobby3=${param.hobby3}
hobby4=${param.hobby4}
hobby5=${param.hobby5},
<c:forEach items="${paramValues.cook}" var="value">
cook=${value}
</c:forEach>
gen=${param.gen}
maj=${param.maj}
prog=${param.prog}
date1=${param.date1}
color1=${param.color1}
email1=${param.email1}
file1=${param.file1}
file2=${param.file2}
