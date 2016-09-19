package servlet;
// 주제: 서블릿 생명주기와 메서드들
//=> Servlet 인터페이스
// - 서블릿 컨테이너가 자바 프로그램을 실행할 때 호출하는 메서드 규칙.
// -init(); 서블릿 객체를 생성한 후 호출한다.
//        => 서블릿이 작업하는데 필요한 자원을 준비시키는 코드를 둔다.
// -service() : 클라이언트 요청이 들어올 때 마다 호출한다.
//        => 클라이언트 요청을 처리하는 코드를 둔다.
// -destory() : 서블릿 컨테이너를 종료하기 직전이나 웹 애클리케이션을 멈추기 직전에 호출한다.
//        => 웹 애플리케이션을 종료하기 전에 사용한 자원을 해제시키는 코드를 둔다.
// -getServletInfo() : 보통 서블릿 관리자 화면에서 서블릿 정보를 출력할 때 호출한다.
// -getServletConfig() : 서블릿 설정 정보를 알고 싶을 때 호출한다.
// 
// 서블릿 객체 생성
//  - 서블릿 객체는 해당 서블릿에 대해 최초 요청시 생성된다.
//  - 서버가 실행되는 동안 한 개만 생성되어 사용된다.
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet01 implements Servlet{
  ServletConfig config;
  
  
  public Servlet01() {
   System.out.println("Servlet01()");
  }
  
  
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
