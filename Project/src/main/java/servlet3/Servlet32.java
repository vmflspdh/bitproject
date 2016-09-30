package servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/servlet32")
public class Servlet32 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // ServletContext 보관소에 저장된 값을 꺼낸다
   ServletContext servletContext = this.getServletContext();
   String a1 = (String)servletContext.getAttribute("a1");
   

   // ServletRequest 보관소에 값을 저장한다.
   String r1 = (String)request.getAttribute("r1");
   
   // 다른 서블릿으로 포워딩한다.
   
   response.setContentType("text/plain;charset=UTF-8");
   PrintWriter out = response.getWriter();
   
   out.printf("a1 = %s\n", a1);
   out.printf("r1 = %s\n", r1);
  }
}
