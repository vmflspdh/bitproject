package servlet2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpGenericServlet extends GenericServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    System.out.println("service(ServletRequest,ServletReseponse)");
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    HttpServletResponse httpResponse = (HttpServletResponse)response;
    
    service(httpRequest,httpResponse);
  }
  
  public abstract void service(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException;
}
