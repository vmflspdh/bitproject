package servlet;
/* 주제: 애노테이션으로 서블릿 등록하기
  @WebServlet("URL")
  web.xml에서 <servlet>과 <servlet-mapping>태그를 사용하지 않아도 된다.
  서블릿 컨테이너가 이 애노테이션을 처리하도록 
  web.xml에 <web-app> 태그에 속성 값을 지정하라!
   
  Servlet 3.0 API부터 사용 가능하다.
*/
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
    // TODO Auto-generated method stub
    System.out.println("init()");
    this.config = config;
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
