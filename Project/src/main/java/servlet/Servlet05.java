package servlet;
/* 주제: 브라우저로 출력하기 
 *  servletRespone로 
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet05")
public class Servlet05 implements Servlet {
  ServletConfig config;

 

  @Override
  public void init(ServletConfig config) throws ServletException {
    // TODO Auto-generated method stub
    this.config = config;
  }

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.print("Hello...^^");
   
  }

  @Override
  public void destroy() {
  }

  @Override
  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return config;
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return "servlet05";
  }

}
