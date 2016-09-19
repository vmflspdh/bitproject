package servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 주제: ServletContext 사용시 주의할점
 */
@WebServlet("/servlet34/p1")
public class Servlet34_p1 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>p1</title></head>");
    out.println("<body>");
    out.println("<form action='p2' method='post'>");
    out.println("이름: <input type='text' name='name'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body></html>");
  }

}
