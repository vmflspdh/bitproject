/* 주제: HTTP 요청과 응답
 * => 웹 브라우저는 웹 서버에 요청할 때 HTTP 규칙에 따라 데이터를 보낸다
 * => 웹서버 또한 웹 브라우저에 응답할 때 HTTP 규칙에 따라 데이터를 보낸다.
 * => 확인하는 방법
 * 
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet13")
public class Servlet13 extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    
    int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    String op = request.getParameter("op");

  
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println(" <head>");
    out.println("<body>");
    out.println("</body>");
    out.println(" </head>");
    out.println("</html>");

    switch (op) {
    case "+": out.printf("%d %s %d = %d\n", a, op, b,  a + b); break;
    case "-": out.printf("%d %s %d = %d\n", a, op, b,  a - b); break;
    case "*": out.printf("%d %s %d = %d\n", a, op, b,  a * b); break;
    case "/": out.printf("%d %s %d = %d\n", a, op, b,  a / b); break;
    default:
    
    }

  }

}

/* HTTP요청
 * [HTTP요청프로토콜(웹브라우저 --> 웹서버)]
 * => 규칙
 * Request Line (요청방법 URI 프로토콜이름/버젼) CRLF
 * 0개 이상의 헤더 (일반/요청/엔티티) CRLF
 * 빈줄
 * (POST 요청인 경우 데이터가 이 순서에 놓인다)
 */

//GET /web01/servlet13?a=10&b=5&op=* HTTP/1.1
//Host: localhost:8080
//Cache-Control: max-age=0
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//Accept-Encoding: gzip, deflate, sdch
//Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

/* 1. Request-Line
 * 요청방법 URI 프로토콜명/버전
 * 
 */
 
/* HTTP응답프로토콜(웹서버 --> 웹브라우저)
 */

//HTTP/1.1 200 OK
//Server: Apache-Coyote/1.1
//Content-Type: text/html;charset=UTF-8
//Content-Length: 65
//Date: Tue, 23 Aug 2016 07:51:54 GMT
//Proxy-Connection: Keep-alive
//
//<html>
// <head>
//<body>
//</body>
// </head>
//</html>
//10 * 5 = 50



//   https://tools.ietf.org/html/rfc2616
