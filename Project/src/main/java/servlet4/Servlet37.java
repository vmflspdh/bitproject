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
/* 주제 : 쿠키를  사용할범위(URL) 지정하기
 */
@WebServlet("/test/servlet37")
public class Servlet37 extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1) 쿠키를만든다.
    Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동","UTF-8"));//지정하지않앗으므로 /test/servlet37이다.
    Cookie c2 = new Cookie("email","test@test.com");
    c2.setPath("/web01/test"); //쿠키의 사용범위 root까지 지정해줘야한다. 지정하지않으면 보내는 서블릿의 경로이다.
    // 사용범위를 지정할 때는 웹 어플리케이션 루트가 아닌 웹 서버루트까지 지정해줘야한다.
    Cookie c3 = new Cookie("age","23");
    c3.setPath("/web01/test2");//쿠키의 사용범위를 지정한다.
    
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
