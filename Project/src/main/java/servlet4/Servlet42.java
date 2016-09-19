package servlet4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* 주제 : 쿠키의 유효기간 지정하기
 * => 쿠키에 유효기간을 지정하지 않으면 웹 브라우저가 실행되는 동안만 유지된다.
 *    즉 웹 브라우저를 종료하면 쿠키가 모두 삭제된다.
 *    쿠키의 유효기간을 지정하면 그 기간만큼은 임시 캐시폴더에 저장된다.
 *    웹 브라우저를 종료하거나 OS를 종료하더라도 유지된다.
 */
@WebServlet("/test/servlet42")
public class Servlet42 extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1) 쿠키의 유효기간 지정하기
    Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동","UTF-8"));
    // 쿠키의 유효기간을 지정하지 않으면 웹 브라우저가 실행되는 동안 유지
    Cookie c2 = new Cookie("email","test@test.com");
    c2.setMaxAge(30);//int 값은 초이다.
    Cookie c3 = new Cookie("age","23");
    c3.setMaxAge(60);
    
    //쿠키를 응답 헤더에 싣는다.
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);
    /*
        Set-Cookie: name=%ED%99%8D%EA%B8%B8%EB%8F%99
        Set-Cookie: email="test@test.com"; Version=1; Path=/web01/test
        Set-Cookie: age=23; Path=/web01/test2
     */
    
    //간단한 응답
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("httl 응답을 확인하세요");
    
    
  }
  /*
   * Url 인코딩의 의미로 홍길동은 현재 2바이트 
   * Unicode인데 UTF-8로 인코딩해서 ASCII코드화 시킨다.
   */
  
}
