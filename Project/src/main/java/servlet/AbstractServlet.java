package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AbstractServlet implements Servlet {
  
  ServletConfig config;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;

  }


  @Override
  public void destroy() {

  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }

  @Override
  public String getServletInfo() {

    return this.getClass().getName();
  }


  @Override
  public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
    // TODO Auto-generated method stub
    
  }

}
