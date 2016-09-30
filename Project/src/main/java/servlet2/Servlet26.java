/* 주제: 리다이렉트(Redirect) 방법과 용도
 * => 클아이언트에게 즉시 다른 URL을 요청하도록 병령을 내릴 때,
 * => 방법: 응답상태 코드 (200 대신 301)를 바꾼다.
 * => 용도
 *    - 리프래시와 달리 콘텐츠 출력없이 다른 페이지로 보낼 때 사용한다.
 */

package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet26")
public class Servlet26 extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
   
    int age = Integer.parseInt(request.getParameter("age"));
    
   
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
   out.println("<html>");
       out.println("<head>");
       out.println("<title>Refresh 테스트</title>");
       out.println("</head>");
       out.println("<body>");
    if (age < 19) {
      out.println("미성년입니다.");
    } else {
      out.println("성년입니다.");
    }
    out.println("</body>");
    out.println("</html>");
    
    // 리다이렉트를 클라이언트로 콘텐츠를 보내지 않는다.
    // 그럼 이전에 출력한 것은 어떻게 되는가?
   
    if (age < 19) {
      response.sendRedirect("servlet24_page2");
    } else {
      response.sendRedirect("servlet24_page3");
    }
    
  }

}
