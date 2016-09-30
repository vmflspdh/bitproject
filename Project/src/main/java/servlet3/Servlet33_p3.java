package servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/servlet33/p3")
public class Servlet33_p3 extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext sc = request.getServletContext();
    
    request.setCharacterEncoding("UTF-8");
    sc.setAttribute("age", request.getParameter("age"));
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>p3</title></head>");
    out.println("<body>");
    out.println("<form action='p4' method='post'>");
    out.println("이메일: <input type='text' name='email'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body></html>");

  }
}
