package servlet;
/*여러개의 필터 꼭기
 *  요청한 URL과에 대해 실행할 필터가 여러개 있을 경우,
 *  각 필터는 모두 실행된다.
 *  필터의 적용 순서에 영향을 받는 프로그램으로 개발하지 말라!
 *  유지보수에 좋지 않ㄷ나.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet18")
public class Servlet18 extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
   System.out.println("Servlet18.service()....");
    
    
    
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


















