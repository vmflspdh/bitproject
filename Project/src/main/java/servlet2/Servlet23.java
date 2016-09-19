package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 주제: 오리지날 도우미 클래스(HttpServlet) 사용하기
 * => JAVA EE에서 제공해주는 HttpServlet 클래스를 상속받아서 서블릿을 만들어보자
 */
@WebServlet("/servlet23")
public class Servlet23 extends HttpServlet  {

  private static final long serialVersionUID = 1L;

  // HttpGenericServlet2에서 추가한 메서드 중에서 POST 요청에 대해 호출될 메서드를 오버라이딩 하자!
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("POST요청");
  }

}
