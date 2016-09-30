/* 주제: 서블릿 생명주기와 메서드들
 * Servlet 인터페이스
 * 서블릿 컨테이너가 자바프로그램을 실행할 때 호출하는 메서드 규칙
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet01 implements Servlet {
  
  ServletConfig config;
  
  public Servlet01() {
    System.out.println("servlet01()");
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    this.config = config;
    
  }


  @Override
  public void destroy() {
    System.out.println("Destroy()");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig()");
    return this.config;
  }

  @Override
  public String getServletInfo() {

    return "servlet01";
  }

 
  @Override
  public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
    System.out.println("service");
    
  }

}
