/* 주제: Get과 Post 요청 구분하기
 */

package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/servlet20")
public class Servlet20 extends GenericServlet{


  @Override
  public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
    // HTTP프로토콜에 대한 정보를 추출하려면
    // service()파라미터 값을 원래의 타입으로 변환해야한다.
    // ServletRequest에는 HTTP 요청 방법 (GET/POST/HEAD/PUT/TRACE/DELETE)이 무엇인지 알려주는 메서드가 없다.
    // 다음은 컴파일 요류
    // request.getMethod();
    
    
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    
    response.setContentType("text/plain;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.printf("HTTP요청방법 : %s\n", httpRequest.getMethod());
    
  }

}
