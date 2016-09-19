package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * 리스너 - 개요
 * => 특정 사건(이벤트)이 발생했을때, 실행되는 객체
 * => 이벤트 
 * 1) 웹 애플리케이션이 시작되엇다.
 * 2) 웹 애플리케이션이 종료되었다.
 * 3) 요청이 들어왔다.
 * 4) 요청 전용 창고에 데이터가 저장되었다.
 * 5) 세션이 준비되었다.
 * 6) 세션 전용창고에 데이터가 입고되었다.
 * ...
 *  ServletContextListener
 *  웹애플리케이션이 시작되거나 종료될때 호출될 메서드를 정의한 인터페이스
 *  이 인터페이스의 구현체는 시작되거나 종료될때마다 실행된다.
 *  모든 서블릿을 위한 공용 도구를 준비할 떄 주로 사용한다.
 *  
 *  리스너도 서블릿과 필터처럼 웹애플리케이션 DD(Deployment Descriptor)파일에 등록해야 한다.
 *  또는 애노테이션을 붙여야한다.
 */
public class Listener01 implements ServletContextListener{
  // 웹 애플리케이션을 시작한후 바로 호출한다. ServletContainer
  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    // TODO Auto-generated method stub
    System.out.println("Listener01.contextInitialized()");
  }
  // 웹 애플리케이션이 종료하기 직전에 실행한다. ServletContainer
  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
    // TODO Auto-generated method stub
    System.out.println("Listener01.contextDestroyed()");
  }


}
