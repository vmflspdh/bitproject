/* 주제: HttpGenericServlet2, 도우미 클래스 호출하기
 */

package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet22")
public class Servlet22 extends HttpGenericServlet2{

// HTTPGeneric
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
   
    response.setContentType("text/plain;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.println("GET 요청...");
    
  }

}
