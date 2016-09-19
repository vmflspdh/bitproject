<%@ page language="java" 
		contentType="text/plain; charset=UTF-8"
    	pageEncoding="UTF-8"%>
 템플리데이터1
 템플리데이터2
 <%!
 private int plus(int a, int b){
   return a+b;
 }
 %>
 템플리데이터3
 <%= plus(20,30) %>
 템플리데이터4
 템플리데이터5
<%--
	jsp 선언문(declaration element)
	<%! 클래스 안에 작성할 자바 코드%>
	변수나 메서드 선언에 사용된다 -----------------------vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	
	
	Jsp 엔진이 하는일
	<%!= 자바코드 %>	이면----------->	class Test04_jsp extends ...{
									자바코드
									.....
									}
	잘못된예)
	<%!= if(true){} %>	이면----------->	class Test04_jsp extends ...{
									if(true){}
									.....
									}
 --%>