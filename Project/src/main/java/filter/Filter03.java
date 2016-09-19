/*주제: 필터의 용도
 *  => 요청을 처리하기 전에 특정 서블릿 그룹에 대해 공통으로 수행할 작업이 있다면
 *     필터에 그 작업을 작성하라!
 *     예) 암호해제, 압축해제, 디코딩, 사용자 검증, 사용권한 확인 , 로그 기록등
 *  => 요청을 처리한 후 클라이언트에게 보내기 전에 해야 할 작업이 있다면
 *     필터에 그 작업을 작서앟라!
 *     예) 암호화, 콘텐츠를 압축, 인코딩, 특정 URL로 리다이렉트, 로그 기록 등
 *  => 필터의 특징
 *     디자인 패턴 중에 Chain of Responsibility를 응용한 것이다.
 *     상속 문법과 달리 임의의 기능 추가 하거나 빼기가 쉽다.
 *     서블릿 코드를 변경하지 않고 기능을 추가하거나 변경할수 있다.
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

@WebFilter("/servlet17")
public class Filter03 implements Filter {
  FilterConfig config;

  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
      throws IOException, ServletException {
    
    // 서블릿에 전달하는 파라미터 값의 문자집합을 알려준다
    // 각 서블릿마다 작성할 필요가 없다.
    request.setCharacterEncoding("UTF-8");
    // 다음에 실행할 필터가 있다면 그 필터를 실행한다.
    // 다음 필터가 없다면, 서블릿의 service()를 호출한다.
    nextFilter.doFilter(request, response);

  }

  @Override
  public void destroy() {
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






