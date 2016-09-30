/* 주제: forward
 * => 다른 서블릿으로 실행을 위임한다.
 */

package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet28/s3")
public class Servlet28_s3 extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    
    PrintWriter out = response.getWriter();
    out.println("세번째 서블릿 : Servlet28_s3.....");

    
  }

}
