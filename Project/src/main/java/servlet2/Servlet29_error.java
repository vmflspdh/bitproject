/* 주제: forward
 * => 다른 서블릿으로 실행을 위임한다.
 */

package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet29/error")
public class Servlet29_error extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
   
    PrintWriter out = response.getWriter();
    out.println("오류!");
    out.println("파라미터 값이 없거나 지원하지 않는 연산자입니다.");

  }

}
