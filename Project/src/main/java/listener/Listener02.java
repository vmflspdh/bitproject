package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/*
 * 요청이 들어올때 작업 수행
 * 
 * 용도 - 요청이들어오는 기록을 남기고 싶을때
 *     - 요청을 처리하기 전 추가 작업을 하고싶을 때 
 *        (주로 Log남기기) 웹 애플리케이션 모니터링 
 */
@WebListener
public class Listener02 implements ServletRequestListener{
  public Listener02() {
    System.out.println("Listener02()");
  }
  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
   System.out.println("Listener02.requestDestroyed()");
    //요청이들어오면 호출된다.
   System.out.println(sre.getServletRequest().getRemoteAddr());
  }

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("Listener02.requestInitialized()");
    //service()를 실행한후 호출된다.
  }

}
