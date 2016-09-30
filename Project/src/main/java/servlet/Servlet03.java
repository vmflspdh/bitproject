/* 주제: 서블릿 생성자 vs init() 메서드
 * - 생성자 에서는 서블릿 관련 정보를 얻을 수 없다
 * - init()는 파라미터로 servletConfig 객체를 받는다
 * ServletConfig 객체로 web.xml 파일에 저장된 값들을 조회할 수 있다.
 * 따라서 서블릿이 필요한 자원을 준비할 때 생성자에서 준비하는 것 보다는
 * init()에서 준비하는 것이 더 편하다
 * 
 */
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet03 implements Servlet {

  ServletConfig config;


  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    this.config = config;

    try { 

      String driver = config.getInitParameter("driver");
      String jdbcUrl = config.getInitParameter("jdbcUrl");
      String username = config.getInitParameter("username");
      String password = config.getInitParameter("password");

      System.out.println(driver);
      System.out.println(jdbcUrl);
      System.out.println(username);
      System.out.println(password);
      
      Class.forName(driver);
      Connection con = DriverManager.getConnection(jdbcUrl, username, password);

    } catch (Exception e) {
      e.printStackTrace();
    }


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
    return "servlet03";
  }


  @Override
  public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
    System.out.println("service()");

  }

}
