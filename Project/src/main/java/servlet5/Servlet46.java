/* 주제 : 세션에 데이터 저장하기
 * => 웹브라우저 별로 구분하여 저장할 데이터가 있다면,
 *    그 데이터는 세션에 보관하라!
 * => 참고!
 *    - 웹 브라우저에 상관없이 모든 사용자가 즉 모든 서블릿이 공유할 데이터는
 *    ServletContext에 보관하라!
 *    - 요청을 처리하는 동안(응답하기 전까지)공유할 데이터는 ServletRequest에 보관하라
 * => 데이터 저장하는 방법
 *  
 * 
 */

package servlet5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet46")
public class Servlet46 extends HttpServlet{
  
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
 
     HttpSession session = request.getSession();
     session.setAttribute("name", "홍길순");
    session.setAttribute("gender", false);
    session.setAttribute("age", 20);
    session.setAttribute("date", new Date());
   
   response.setContentType("text/plain;charset=UTF-8");
   PrintWriter out = response.getWriter();
   out.printf("세션아이디 = %s\n", session.getId());

}
}

/* 새로 세션을 만들 때?
 * => 클라이언트로 쿠키를 사용하여 세션 아이디를 보낸다.
 * => 예)
 *
 */
