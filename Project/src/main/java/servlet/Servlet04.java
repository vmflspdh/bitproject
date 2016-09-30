/* 주제: 애노테이션으로 서블릿 등록하기
 * 서블릿 컨테이너가 이 애노테이션을 처리하도록 web.xml을 지정하라
 */
package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet04")
public class Servlet04 implements Servlet {

  ServletConfig config;


  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    this.config = config;

  }


  @Override
  public void destroy() {
    System.out.println("destroy()");

  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig()");
    return this.config;
  }

  @Override
  public String getServletInfo() {

    return "servlet04";
  }


  @Override
  public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
    System.out.println("service");

  }

}
