package servlet;
/*
 * 주제: 계산기 웹 애플리케이션 만들기
 *  웹 브라우저에서 서블릿에 데이터를 보내는 방법을 연습
 *  서블릿에서 클라이언트가 보낸 데이터를 꺼내는 방법을 연습
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet12")
public class Servlet12 extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    //클라이언트가 보낸 데이터 꺼내기
    // 서블릿에 데이터 보내는 방버?
    // URL에 데이터를 첨부한다.
    // 예) http://localhost:8080/web01/servlet11?파라미터명=값&파라미터명=값&파라미터명=값;
    int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    String op = request.getParameter("op");
    int result = 0;
    
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    switch(op){
    case "+":  out.printf("%d %s %d = %d\n",a,op,b,a+b); break;
    case "-":  out.printf("%d %s %d = %d\n",a,op,b,a-b); break;
    case "*":  out.printf("%d %s %d = %d\n",a,op,b,a*b); break;
    case "/":  out.printf("%d %s %d = %d\n",a,op,b,a/b); break;
    default: 
      out.println("지원하지 않는 연산자입니다.");
      
    }
    out.println("</body>");
    out.println("</html>");
    
    
   
    
    
    
  }
}

/* 
 * URL과 특수 문자
 * => '+' : URL에서 +문자는 공백(space)을 의미한다.
 *          진짜 '+'문자를 파라미터 값으로 표현하고 싶다면 URL인코딩 문자로 표현하라
 *          예) %2B
 * => '%' : URL에서 %는 인코딩 문자의 시작 기호로 사용된다.
 *          예) %2B는  '+' 문자의 코드 값을 의미한다.
 *  
 * URI(Uniform Resource Identifier)?
 *  인터넷 상의 특정 컴퓨터에 저장된 자원(파일)을 가리키는 식별자/주소 이다.
 *  표기법
 *  1) URN
 *     예) urn:isbn:0451450523, urn:uuid:6e8bc430-9c3
 *  2) URL
 *     예) http://www.bitcamp.co.kr:8080/java85/test.txt
 *  => 웹에서는 URI 표기법 중에서 URL을 주로 사용한다.
 *          
 *          
 * URL 인코딩?(ASCII를 문자화)
 * => ASCII문자표에 없는 문자는 ASCII 문자화 시키는것을 말한다.
 * => URL을 작성할 때 ASCII 문자표(영어 대/소문자, 숫자, 특수문자 일부)에 정의되지 않는 문자는 
 *  특별한 형식으로 변환되어 서버에 보내진다.
 *  이렇게 특별한 문자로 변환하는 것을 "URL"인코딩이라 부른다.
 * 
 * => ASCII 문자 중에서도 URL 인코딩을 위해 사용되는 '%' 문자나 공백을 표현하기 위해 사용되는 
 * '+'와 같은 문자는 "URL 인코딩"하여야 한다.
 * 
 * => 왜 , ASCII 문자만 URL로 작성해야 하는가?
 *  게이트웨이 또는 라우터 장비 중에는 7비트 전용 장비가 존재한다.
 *  한글과 같이 8비트로 표현해야 한느 데이터는 이 장비를 통과하면 데이터 손실이 발생한다.
 *  그러나 ASCII문자는  7비트아기때문에 어떤 장비를 통과하더라도 데이터 손실이 발생하지 않는다.
 *  이러한 이유로 한글 처럼 8비트로 표현해야 하는 데이터는 ASCII문자화 시키는 것이 
 *  데이터 손실을 없앨수 있는 방법이다.
 *  URL 인코딩 예) 'A가'----->A%EA%B0%80 (UTF-8문자표의 코드 값으로 ASCII 문자화)
 *  URL 디코딩 예) A%EA%B0%80---->'A가'
 */


















