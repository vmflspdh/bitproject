/* 주제: 리스너 - 개요
 * => 특정 사건(이벤트)이 발생했을 때 실행되는 객체
 * => 이벤트
 * 1) 웹애플리케이션이 시작되었다.
 * 2) 웹애플리케이션이 종료되었다.
 * 3) 요청이 들어왔다.
 * 4) 요청 전용 창고에 데이터가 입고되었다.
 * 5) 세선이 준비되었다.
 * 6) 세션 전용 창고에 데이터가 입고되었다.
 * 
 * ServletContextListener
 *  - 웹애플리케이션이 시작되거나 종료될 때 호출될 메서드를 정의한 인터페이스
 *  - 이 인터페이스 
 * 
 */

package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener02 implements ServletRequestListener{
  
  public Listener02() {
    System.out.println("Listener02()");
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    // 요청이 들어오면 호출된다.
    System.out.println(sre.getServletRequest().getRemoteAddr());
    System.out.println("Listener02.requestDestroyed()");
    
  }

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("Listener02.requestInitialized()");
    
  }


}
