package servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

//서블릿 클래스를 쉽게 마들수 잇도록 Servlet 인터페이스의 다섯 개 메서드 중에서 
//init(), dstory(), getServletInfo(), getServletConfig(), service()
public abstract class AbstarctServlet implements Servlet{
  
  ServletConfig config;
  
  @Override
  public void destroy() {
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    // TODO Auto-generated method stub
    this.config = config;
  }
  
  @Override
  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return config;
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return this.getClass().getName();
  }
}
