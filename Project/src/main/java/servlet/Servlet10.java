package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet10")
public class Servlet10 extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    //0) 출력 도구가 사용할 문자표 지정
    //HTML 데이터를 출력할 것이다. MIME Type을 지정한다.
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>안녕하세요</h1>");
    out.println("</body>");
    out.println("</html>");
    
    
   
    
    
    
  }
}