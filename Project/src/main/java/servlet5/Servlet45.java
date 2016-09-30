/* 주제 : 세션 생성하기
 * => request.getSession() 메서드를 호출하여 세선을 준비한다.
 * => 세션 준비절차
 *    -> 웹브라우저에서 쿠키를 이용하여 세션 아이디를 보냈는가?
 *    -> 세션 아이디가 있다면, 해당 아이디의 세션 객체를 찾는다.
 *    -> 세션 아이디가 없다며, 새로운 세션 객체를 만든다. - 응답할 때 새로 만든 세션 객체의 아이디를 쿠키에 담아 클라이언트로 보낸다.
 *                      - 웹 브라우저는 서버가 보낸 세션 아이디를 임시로 저장한다.
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

@WebServlet("/servlet45")
public class Servlet45 extends HttpServlet{
  
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
   // 다음 메서드가 리턴하는 것은 기존에 존재하던 세션 객체이다.
   // 물론 웹브라우저가 알려준 세션 아이디에 해당하는 객체 일 것이다.
   //=> 만약, 웹브라우저를 종료했다가 새로 띄운 다음에 이 서블릿을 실행한다면,
   // 세션 아이디를 못 받았기 때문에 세션 객체를 새로 리턴할 것이다.
     HttpSession session = request.getSession();
   
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
