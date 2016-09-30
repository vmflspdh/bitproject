package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet11")
public class Servlet11 extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    
    // 클라이언트가 보낸 데이터 꺼내기
    // => 서블릿에 데이터 보내는 방법
    // URL에 데이터를 첨부한다.
    // 예 http://localhost:8080/web01/servlet10?name=haha
    String name = request.getParameter("name");
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println(" <head>");
    out.println("<body>");
    out.printf("%s님 안녕하세요!!!!!!!!!!\n", name);
    out.println("</body>");
    out.println(" </head>");
    out.println("</html>");


  }

}

/* URL의 파라미터 값이 한글일 때 깨짐 현상
 * => TOmcat8 에서는 한글이 제대로 처리된다.
 * => tomcat7이하 버전에서는 URL의 한글 파라미터 값이 깨지는 문제가 발생한다.
 */
