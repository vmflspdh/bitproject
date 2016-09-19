package servlet;
/* 주제: AbstractServlet 클래스를 사용하여 Servlet 
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet06")
public class Servlet06 extends AbstarctServlet {
  ServletConfig config;

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.print("Hello...^^");
  }

}
