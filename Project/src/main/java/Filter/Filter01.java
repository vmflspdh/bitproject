/* Filter 인터페이스를 구현한다
 * init()
 * Filter를 쓰기전에 사용할 자원을 초기화한다.
 * 
 */

package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/servlet16")
public class Filter01 implements Filter {

  FilterConfig config;

  @Override
  public void init(FilterConfig config) throws ServletException {

    this.config = config;
    System.out.println("Filter01.init()" );

  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
      throws IOException, ServletException {
    System.out.println("Filter01.doFilter(): service() 호출하기 전에 수행할 작업.....");
    
    // 다음에 실행할 필터가 있다면 그 필터를 실행한다.
    // 만약 다음필터가 없다면, 서블릿의 service()를 호출한다.
    
    nextFilter.doFilter(request, response);
    
    System.out.println("Filter01.doFilter(): service() 호출한 후에 수행할 작업.....");
    
    System.out.println();
  }
  
  @Override
  public void destroy() {
    System.out.println("Filter01.destroy()......");
    
  }
}

/* 필터의 구동원리
 * 1) 웹 애플리케이션 시작
 * 2) 웹 애플리케이션에 등록된 필터 객체 생성 및 생성자 호출, init() 호출
 * 3) 웹 어플리 케이션에 등록된 서블릿 중에서 <load-on-startup>이 선언된 서블릿 객체 생성 및 생성자 호출, init() 호출
 * 4) 서블릿을 요청
 *    -> 그 경로에 설정된 필터 실행; doFilter()호출
 *    -> 다음 필터 실행...
 *    -> 더이상 실행할 필터가 없다면, 서블릿의 service() 호출
 *    -> 이전 필터가 없을 때까지 계속 리턴
 */
