package servlet3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/servlet30")
public class Servlet30 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // ServletContext 보관소에 값을 저장한다.
   ServletContext servletContext = this.getServletContext();
   servletContext.setAttribute("a1", "hello");
   
   // ServletRequest 보관소에 값을 저장한다.
   request.setAttribute("r1", "world!");
   
   // 다른 서블릿으로 포워딩한다.
   
   RequestDispatcher rd = request.getRequestDispatcher("/servlet31");
   rd.forward(request, response);
  }
}
