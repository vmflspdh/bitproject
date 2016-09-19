package servlet;
/* 주제: HttpServlet 추상 클래스를 상속 받아 서블릿 구현하기
 * Servlet(인터페이스)
 *  <-- GenericServlet(추상클래스)
 *      <--HttpServlet(
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet08")
public class Servlet08 extends HttpServlet {
  ServletConfig config;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    PrintWriter out = response.getWriter();
    out.print("Hello...^^");
  }
  

}
