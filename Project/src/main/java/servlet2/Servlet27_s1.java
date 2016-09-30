/* 주제: forward
 * => 다른 서블릿으로 실행을 위임한다.
 * => 이전 서블릿에서 버퍼에 출력한 내용은 버려진다.
 * => 단 출력 스트림을 얻기전에 호출한 setContentType()설정은 유효하다.
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

@WebServlet("/servlet27/s1")
public class Servlet27_s1 extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    response.setContentType("text/plain;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("첫번째 서블릿: Servlet27_s1.....");
    

    
    RequestDispatcher rd = request.getRequestDispatcher("/servlet27/s2");
    
    rd.forward(request, response);
    
  }

}
