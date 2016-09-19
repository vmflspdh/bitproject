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
/* 주제 : 쿠키값 꺼내기 path(/web01/servlet38)
 *    웹브라우저는 서버로 부터 받은 쿠키를 보관하고있다가 헤더에 첨부해서 보낸다.
 */
@WebServlet("/test/okok/haha/servlet40")
public class Servlet40 extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1) 요청헤더에 첨부되어있는 쿠키꺼내기
    // 안타깝게도 키만 입력하면 value를 리턴하는 메서드가없다.
    Cookie[] cookies = request.getCookies();
    //간단한 응답
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    if(cookies ==null){
      return;
    }else{
      for(Cookie c:cookies )
        out.printf("%s-----------%s\n",c.getName(),URLDecoder.decode(c.getValue(),"UTF-8"));
    }
    
  }
  /*
   * Url 인코딩의 의미로 홍길동은 현재 2바이트 
   * Unicode인데 UTF-8로 인코딩해서 ASCII코드화 시킨다.
   */
  
}
