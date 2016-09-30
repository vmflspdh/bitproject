package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

  ServletConfig config;

  // Servlet lifecycle 과 관련된 메서드
  // 1) Servlet Container가 서블린 객체를 만든 후 호출하는 메서드
  //=> 각 서블릿 클래스에 대해 인스턴스는 딱 한개만 만든다
  //=> 따라서 이 메서드는 각 서블릿에 대해 딱 한번만 호출된다
  //=> 주로 서블릿 객체가 작업할 때 사용할 자원을 준비하는 코드를 넣는다.

  @Override
  public void init(ServletConfig config) throws ServletException {
    // 파라미터로 받은 ServletConfig 객체는 잘 보관해두었다가
    // getServletConfig() 메서드가 호출될 때 이 객체를 리턴하라!
    this.config = config;

    System.out.println("init()");

  }

  // 2) 클라이언트 요청에 들어올 때마다 Servlet Container가 호출하는 메서드
  // => 이 메서드가 가장 중요하다.
  // => 클라이언트 요청이 있을 떄마다 호출되는 메서드 이기 때문에
  //  이 메서드 안에 요청을 처리하는 코드를 둔다

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // 서블릿 컨테이너는 이 메서드를 호출하면서 작업할 때 사용하라고,
    // 아주 중요한 두 개의 객체를 파라미터로 넘겨준다
    // ServletRequset : 요청 정보를 다룰 때 사용할 도구들이 들어있다.
    // ServletResponse : 응답에 관련된 도구들이 들어있다.

    System.out.println("service()");

  }

  // 3) Servlet Container가 종료되기 직전에 각 서블릿 객체에 대해 호출하는 메서드
  // => 서블릿 컨테이너가 종료되기 직전에 딱 한번 호출된다.
  // => 보통 init()에서 준비한 자원을 해제시키는 작업을 수행한다.

  @Override
  public void destroy() {
    // 특별히 서버를 멈추기전에 해제해야할 자원이 있다면,
    // 이 메서드에 그 코드를 작성하라!
    
    System.out.println("destroy()");

  }

  // Servlet 관리할 때 호출되는 메서드
  // 4) Servlet container가 관리자 화면에서 서블릿의 이름을 출력할 때 호출하는 메서드
  
  @Override
  public String getServletInfo() {
    return "인사말을 출력하는 서블릿";
  }

  // 5) Servlet Container 또는 내부에서 서블릿 설정 정보를 다룰 때 호출하는 메서드
  // => 이 메서드는 ServletConfig 객체를 리턴한다.
  // => 보통 init()에서 파라미터 받은 객체를 그대로 리턴한다.
  //    ServletConfig 객체는 new 연산자로 임의적으로 만들 수 없다.
  
  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }
}
