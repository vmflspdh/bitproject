<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"%>
 그냥 작성하는 텍스트는 템플릿 데이터(template data)라 부른다.
 <% //이 태그를 스크립트릿(scriptlet, 작은 코드 조각)이라 부른다.
 int a;
 int b;
 //이 태크 안에는 자바 코드를 작성한다.
 %>
 그냥 작성하는 텍스트는 템플릿 데이터라 부른다.
<%--
	Jsp 엔진이 하는일
	*Template Data  --------------------> 자바 출력문으로 바꾼다.
		자바 출력문을 생성한다.
		ex)  out.write(" 그냥 작성하는 텍스트는 템플릿 데이터(template data)라 부른다.\r\n");
	*Scriptlet   ------------------------> 그대로 복사한다.
		ex)  int a;
 			 int b;
 --%>