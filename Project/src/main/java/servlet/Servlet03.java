package servlet;
// 주제: <load-on-startup>
// 서블릿 객체는 최초 요청 시 생성된다.
// 그런데 서블릿이 사용할 자원을 준비시키는데(생성자를 호출하거나 init()를 호출하는 것)
// 시간이 오래걸린다면, 최소로 요청하는 사용자는 늦게 응답을 받을 수있다.
// 저 웅요한 것은, 자원을 준비하는 중에 오류가 있다 하더라도 
// 그것은 최초 요청할 때까지 알수없다. 이것이 문제다.
// 특정 서블릿에 오류가 있는데도 불구하고 그 오류를 파악하지 못하고 있다가 서비스를 제공하는 중에 
// 그서블릿을 실행했을 때 비로소 오류를 발견한다면 이것은 치명적이다.
// 즉 최초 요청할때 오류를 발견된다면 업무에 대단한 차질을 빚을 수 있다.
// 해결책?
// => 서블릿을 요청하지 않아도, 서버를 실행할떄 서블릿 객체를 미리 생성한다면
// 서버 실행 중에 오류를 미리 발견하여 조치를 취할 수 있을것이다.
// => web.xml에 서블릿을 등록할 때 설정하라
// 서버실행할때 서블릿을 생성하라고 설정하라
// => 문법
// <load-on-startup>순번</load-up-startup>
// 생성될 서블릿이 여러 개이고, 그 생성 순서가 중요하다면
// 순번으로 조정하라. 중요하지 않다면 그냥 아무 숫자를 집어 넣어라!

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
    // TODO Auto-generated method stub
    System.out.println("init()");
    this.config = config;
    
    try {
      String driver = config.getInitParameter("driver");
      String jdbcUrl = config.getInitParameter("jdbcUrl");
      String username = config.getInitParameter("username");
      String password = config.getInitParameter("password");
      
      
      Class.forName(driver);
      Connection con = DriverManager.getConnection(jdbcUrl, username, password);

    } catch (Exception e) {e.printStackTrace();}
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
