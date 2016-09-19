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
public class Servlet20 extends GenericServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    // ServletRequest에는 HTTP 요청이(GET/POST/HEAD/TRACE/DELETE 등) 무엇인지 알려주는 메서드가
    // 없다. 그러므로 컴파일 오류.
    // request.getMethod();

    // HTTP프로토콜에 대한 정보를 추출하려면
    // service()파라미터 값을 원래의 타입으로 변환해야 한다.
    HttpServletRequest httpRequest = (HttpServletRequest) request;

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("HTTP 요청방법: %s\n", httpRequest.getMethod());

  }

}
