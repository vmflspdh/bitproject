package servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 주제: include
 *    -다른 서블릿에 실행을 포함하고 싶을 때 사용하는 기법이다.
 *    -forward 다른 서블릿을 실행한후 되돌아 온다.
 */
@WebServlet("/servlet34/p5")
public class Servlet34_p5 extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();    
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>p1</title></head>");
    out.println("<body>");
    out.printf("이름 = %s<br>\n",session.getAttribute("name"));
    out.printf("나이 = %s<br>\n",session.getAttribute("age"));
    out.printf("이메일 = %s<br>\n",session.getAttribute("email"));
    out.println("</body></html>");
  }

}
