package servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 주제: include
 *    -다른 서블릿에 실행을 포함하고 싶을 때 사용하는 기법이다.
 *    -forward 다른 서블릿을 실행한후 되돌아 온다.
 */
@WebServlet("/servlet31")
public class Servlet31 extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //ServletContext보관소에 저장된 값을 꺼낸다.
    ServletContext servletContext = this.getServletContext();
    String a1 = (String)servletContext.getAttribute("a1");
    
    //ServeltRequest보관소에 값을 저장한다.
    String r1 = (String)request.getAttribute("r1");
    
    //보관소에 저장되었던 값을 출력해보자!
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("a1=%s\n",a1);
    out.printf("r1=%s\n",r1);
  }

}
