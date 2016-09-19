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

/* 주제: include
 *    -다른 서블릿에 실행을 포함하고 싶을 때 사용하는 기법이다.
 *    -forward 다른 서블릿을 실행한후 되돌아 온다.
 */
@WebServlet("/servlet33/p4")
public class Servlet33_p4 extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext sc = this.getServletContext();
    sc.setAttribute("email", request.getParameter("email"));
    
    System.out.println(request.getParameter("email"));
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>p1</title></head>");
    out.println("<body>");
    out.println("<form action='p5' method='post'>");
    out.println("<p>입력을 완료했습니다.</p>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body></html>");
  }

}
