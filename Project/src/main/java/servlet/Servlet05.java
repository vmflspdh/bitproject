/* 주제: 애노테이션으로 서블릿 등록하기
 * 서블릿 컨테이너가 이 애노테이션을 처리하도록 web.xml을 지정하라
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet05")
public class Servlet05 implements Servlet {

  ServletConfig config;


  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;

  }


  @Override
  public void destroy() {

  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }

  @Override
  public String getServletInfo() {

    return "servlet05";
  }


  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    // 클라이언트로 출력하고 싶다면 ServletResponse 객체에서 출력 도구를 꺼내라
    
    PrintWriter out = response.getWriter();
    out.println("Hello!");

  }

}
