package servlet;
// 주제: 서브릿 생성자 vs init() 메서드

// 생성자에서는 서블릿 관련 정보를 얻을수 없다.
// 그러나 init()는 파라미터로 ServletConfig 객체를 받는다.
// ServletConfig 객체로 web.xml 파일에 저장된 값들을 조회 할 수 잇다.
// 따라서 서블릿이 필요한 자원을 준비할 때 생성자에서 준비하는 것 보다는
// init()에서 준비하는 것이 더 편리하다.
// 주제: 서블릿을 실행 할 때 사용할 자원을 준비시키는 메서드가 init()이다.

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet02 implements Servlet {
  ServletConfig config;

  public Servlet02() {
    try {
      String driver = "";
      String jdbcUrl = "";
      String username = "";
      String password = "";
      Class.forName("클래스이름");
      Connection con = DriverManager.getConnection(jdbcUrl, username, password);

    } catch (Exception e) {}
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    // TODO Auto-generated method stub
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

    } catch (Exception e) {}
  }

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

    System.out.println("service()");
  }

  @Override
  public void destroy() {
    System.out.println("destory()");
  }

  @Override
  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return config;
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return "servlet01";
  }

}
