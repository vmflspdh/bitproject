/* 주제 : 쿠키 값 꺼내지
 * => 유효기간이 지난 쿠키는 웁
 * 
 */

package servlet4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/servlet42")
public class Servlet42 extends HttpServlet{
  
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
   //1) 쿠키를 만든다.
   Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
   // 쿠키의 사용 범위를 지정하지 않으면 쿠키를 보내는 서블릿의 경로가 사용범위이다.
   
   Cookie c2 = new Cookie("email", "test@test.com");
   c2.setMaxAge(30); // 30초 동안 유지
   
   Cookie c3 = new Cookie("age", "20"); // 쿠키의 사용범위를 지정한다.
   c3.setMaxAge(60);
   
   //2) 쿠키를 응답 헤더에 싣는다
   response.addCookie(c1);
   response.addCookie(c2);
   response.addCookie(c3);
   
   //3) 간단한 응답
   response.setContentType("text/plain;charset=UTF-8");
   PrintWriter out = response.getWriter();
   out.println("웹브라우저로 쿠키를 보냈습니다. HTTP 응답을 확인하세요");
}
}

/*URL 인코딩의 의미
 * => "홍길동" (2바이트 유니코드) ---> UTF-8(2~4byte)  형식으로 인코딩 ---> ASCII 코드
 */
