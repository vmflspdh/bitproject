/* 주제 : 세션에 데이터 저장하기
 * => 세션을 무효화 시키면 해당 데이터가 삭제된다.
 *  
 * 
 */

package servlet5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet48")
public class Servlet48 extends HttpServlet{
  
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
 
     HttpSession session = request.getSession();
     session.invalidate();
     session = request.getSession();
   
   response.setContentType("text/plain;charset=UTF-8");
   PrintWriter out = response.getWriter();
   
   out.printf("세션아이디 = %s\n", session.getId());
   out.printf("name = %s\n", session.getAttribute("name"));
   out.printf("gender = %s\n", session.getAttribute("gender"));
   out.printf("age = %s\n", session.getAttribute("age"));
   out.printf("date = %s\n", session.getAttribute("date"));

}
}

/* 새로 세션을 만들 때?
 * => 클라이언트로 쿠키를 사용하여 세션 아이디를 보낸다.
 * => 예)
 *
 */
