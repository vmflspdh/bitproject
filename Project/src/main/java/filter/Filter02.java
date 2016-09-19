/*주제: 필터를 만드는 방법과 구동원리
 * =>javax.servlet.Filter
 * =>init(): 필터 객체를 생성한후 자동으로 호출되는 메서드
 *           필터가 작업할 때 사용할 자원을 준비시키는 코드를 둔다.
 *   doFilter(): 필터가 적용될 때마다 호출되는 메서드  Servlet Container가 호출
 *               서블릿의 service() 메서드를 호출하기 전에 해야할 작업이나, 
 *               호출할 작업을 둔다.
 *   destory() 웹 어플리케이션이 멈출 때 호출되는 메서드
 *             필터가 사용하기 위해 준비한 자원을 해제시키는 코드를 둔다.
 *   => 필터를 웹 애플리케이션 설정에 추가한다. 
 *   DD (Deployment Descriptor) 파일 : web.xml파일에 등록한다.
  */
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/servlet16")
public class Filter02 implements Filter {
  FilterConfig config;

  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config;
    System.out.println("Filter02.init");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
      throws IOException, ServletException {
    System.out.println("Filter02.doFilter(): service()호출하기 전에 수행할 작업...");

    // 다음에 실행할 필터가 있다면 그 필터를 실행한다.
    // 다음 필터가 없다면, 서블릿의 service()를 호출한다.
    nextFilter.doFilter(request, response);

    System.out.println("Filter02.doFilter(): service()호출 한 후 수행할 작업...");
  }

  @Override
  public void destroy() {
    System.out.println("Filter02.destory()....");
  }
  
  

}


/*
 * 필터의 구동원리
 * 1) 웹애플리케이션에 등록된 필터 객체 생성 및 생성자 호출>, ㅑㅜㅑㅅ()
 * 2) 웹 어플리케이션에 등록된 서블릿중ㅇ서<load-on-startup>이 선언된
 * 3) 서블릿 객체 생성 및 생성자호출, init()
 *  4) 서블릿 요청
 *     그 경로에 설정된 필터 실해이  ㅇdoFilter()호출
 *     다음 필터 실행..
 *     더이상 실행할 피터가 없다면 서블릿의 
 *     거꾸로 이젠 필터로 리턴함.
 *     이전 필터가 없을 때 까지 계속 리턴...
 *     필터 호출 그래프
 *     요청
 *     Filter01.doFilter() -->Filter02.doFilter()==>Filter03.doFilter() --> Servlet의 service()호출
 *     -->Filter03.doFilter() 리턴--> Filter02.doFilter()리턴 --> Filter01.doFilter() 리턴
 *     응답
 */






