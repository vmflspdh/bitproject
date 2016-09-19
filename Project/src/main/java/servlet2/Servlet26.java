package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 주제: Redirect(리다이렉트) 방법과 용도
 */
@WebServlet("/servlet26")
public class Servlet26 extends HttpServlet  {

  private static final long serialVersionUID = 1L;

  // HttpGenericServlet2에서 추가한 메서드 중에서 POST 요청에 대해 호출될 메서드를 오버라이딩 하자!
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int age = Integer.parseInt(request.getParameter("age"));
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Refresh 테스트</title>");
    out.println("</head>");
    out.println("<body>");
    if(age<19) {
      out.println("미성년입니다.");
    } else{
      out.println("성년입니다.");
    }
    out.println("</body>");
    out.println("</html>");
    
    if(age<19){
      response.sendRedirect("servlet24_page2");
    } else {
      response.sendRedirect("servlet24_page3");
    }
  }

}
