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
/* 주제 : client(웹 브라우저)에게 데이터를 보관시키는 방법 - 쿠키(cookie)
 * => 클라이언트에게 데이터를 보낼 때 응답 헤더를 이용하여 보낸다. 
 * => 데이터(쿠키)는 key/value 한 쌍의 값으로 클라이언트로 보낸다. 
 *    key와 value는 반드시 문자열이어야 한다.
 *    key와 value는 ISO-8859-1로 인코딩되어야 한다.
 *    한글? Url 인코딩을 수행하여 ASCII 코드화 시킨 다음에 보내야 한다.
 *    데이터의 사용 범위를 지정할 수 있다.
 *    데이터의 유효 기간을 지정할 수 있다.
 *    웹브라우저는 서버로부터 받은 데이터의
 *    사용 범위 내에 있는 URL을 요청할 때는 반드시 요청 헤더에 포함하여 서버에 보내야 한다. 
 */
@WebServlet("/servlet35")
public class Servlet35 extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1) 쿠키를만든다.
    Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동","UTF-8"));
    Cookie c2 = new Cookie("email","test@test.com");
    Cookie c3 = new Cookie("age","23");
    
    //쿠키를 응답 헤더에 싣는다.
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);
    /*Set-Cookie: name=%ED%99%8D%EA%B8%B8%EB%8F%99
      Set-Cookie: email="test@test.com"; Version=1
      Set-Cookie: age=23 
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
