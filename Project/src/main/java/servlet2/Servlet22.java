package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 주제: HttpGenericServlet2 도우미 클래스 사용하기
 *   => 직접 Servlet 인터페이스에 선언된 serivce()를 구현하기 보다는 
 *   POST , GET , HEAD 등의 요청에 따라 호출되는메서드를 오버라이딩하도록하자
 */
@WebServlet("/servlet22")
public class Servlet22 extends HttpGenericServlet2 {

  private static final long serialVersionUID = 1L;

  // HttpGenericServlet2에서 추가한 메서드 중에서 GET 요청에 대해 호출될 메서드를 오버라이딩 하자!
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("GET요청");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("POST요청");
  }

}
