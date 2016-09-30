/* 주제: POST 요청으로 데이터를 보낼 때 한글 깨짐 문제
 * => GET 요청인 경우 톰캣 서버의 설정으로 클라이언트가 보내는 데이터의 문자표를 지정했다.
 * => POST 요청으로 데이터를 보내는 경우, 톰캣 서버의 설정으로 처리할 수 없다.
 *    데이터를 꺼내기 전에 어떤 문자표를 사용할 것인지 지정해야 한다.
 *    request.setcharactorEncoding
 * 
 */

package servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet18")
public class Servlet18 extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    long startMllis = System.currentTimeMillis();
    System.out.println("Servlet18.service()...");
    long endMllis = System.currentTimeMillis();
    
    System.out.println(endMllis - startMllis);
    
  }

}
