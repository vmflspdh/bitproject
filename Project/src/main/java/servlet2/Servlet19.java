/* 주제: HttpServletRequest와 HttpServletResponse
 * => 요청이 들어오면 톰캣서버는 서블릿에 대해 service() 메서드를 호출한다.
 *    이 때 두개의 파라미터 값을 넘기는데
 *    httpServiceRequest와 httpServiceResponse를 넘긴다.
 * => 즉 service() 메서드의 파라미터 값은
 *    Servlet
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
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet19")
public class Servlet19 extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    response.setContentType("text.plain;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.printf("HttpServletRequest = %b\n", request instanceof HttpServletRequest);
    out.printf("HttpServletResponse = %b\n", response instanceof HttpServletResponse);
    
  }

}
