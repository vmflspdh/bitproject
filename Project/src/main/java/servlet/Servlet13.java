package servlet;
/*
 * 주제: HTTP 요청과 응답
 * => 웹 브라우저는 웹 서버에 요청할 때 HTTP 규칙에 따라 데이터를 보낸다.
 * => 웹 서버 또한 웹 브라우저에게 응답할 때 HTTP 규칙에 따라 데이터를 보낸다.
 * -> 확인하는 방법?
 *    웹브라우저와 웹서버 사이에 주고 받는 데이터를 모니터링 프로그램을 통해 확인해보자!
 *    
 *    모니터링 프로그램?
 *    Fiddler(무료)
 *    Charlees(느리다)
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet13")
public class Servlet13 extends GenericServlet {

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

/* HTTP 요청(Web Browser--> Web Server)
 * 
 * 
 * 
 * 
 * 
 * 
 * HTTP 응답
 */


















