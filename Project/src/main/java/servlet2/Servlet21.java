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

/* 주제: HttpGenericServlet 도우미 클래스 사용하기
 *   => service()의 ServletRequest, ServletResponse 파라미터 값을 
 *    원래의 타입으로 형변화하는게 귀찮아서,
 *    그것을 미리 처리한 HttpGenericServlet을 상속받아 서블릿을 만들기.
 * 
 * 
 */
@WebServlet("/servlet21")
public class Servlet21 extends HttpGenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("service(HttpServletRequest,HttpServletReseponse)");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("HTTP 요청방법: %s\n", request.getMethod());
  }

}
