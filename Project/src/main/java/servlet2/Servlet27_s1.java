package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 주제: forward
 *    -다른 서블릿으로 실행을 위임할때 사용하는 기법이다.
 */
@WebServlet("/servlet27/s1")
public class Servlet27_s1 extends HttpServlet  {

  private static final long serialVersionUID = 1L;

  // HttpGenericServlet2에서 추가한 메서드 중에서 POST 요청에 대해 호출될 메서드를 오버라이딩 하자!
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("첫 번째 서브릿 : Servlet27_s1......");
  //다른 서블릿으로 실행을 위임한다.
    //1) 요청을 다른 서블릿으로 배달해줄 객체를 준비한다.
    RequestDispatcher rd = request.getRequestDispatcher("/servlet27/s2");
    rd.forward(request, response);
  }

}
