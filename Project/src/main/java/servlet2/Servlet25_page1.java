/* 주제: REfresh 방법
 * 클라이언트에게 콘텐츠 출력을 완료한 후, 다른 URL로 다시 요청하도록 만드는 방법.
 * 방법 1: HTTP 응답 헤더에 Refresh 정보 삽입
 * 방법 2 : HTML <Meta> 태그
 */

package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet25_page1")
public class Servlet25_page1 extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
   
    int age = Integer.parseInt(request.getParameter("age"));
    
   
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
   out.println("<html>");
       out.println("<head>");
       out.println("<title>Refresh테스트</title>");
       
       if (age < 18) {
         out.printf("<meta http-equiv='Refresh' content='1;url=servlet24_page2'>");
       } else {
         out.printf("<meta http-equiv='Refresh' content='1;url=servlet24_page3'>");
       }
       
       out.println("</head>");
       out.println("<body>");
    if (age < 19) {
      out.println("미성년입니다.");
    } else {
      out.println("성년입니다.");
    }
    out.println("</body>");
    out.println("</html>");
    
  }

}
