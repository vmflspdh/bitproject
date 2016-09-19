package servlet5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/* 주제 : 세션 생성하기
 *  =>request.getSeesion() 메서드를 호출하여 세션을 준비한다.
 *    세션 준비 절차
 *      -웹브라우저에서 쿠키를 이용하여 세션 아이디를 보냈는가?
 *        - 클라이언트가 보낸 요청 헤더에 세션아이디에 해당하는 쿠키가 잇다면 해당아이디의 세션 객체를 찾는다.
 *          -세션이 유효하다면 (타임아웃되지않앗다면)
 *        - 클라이언트가 보낸 요청 헤더에 세션아이디에 해당하는 쿠키가 없다면 새로운 세션 객체를 만든다.
 *          - 응답할 때 새로 만든 세션 객체의 아이디를 쿠키에 담아 클라이언트로 보낸다.
 *          - 웹 브라우저는 서버가 보낸 세션아이디를 임시로 저장한다. 즉 , 실행되는동안만 보관한다. 
 *            - 웹브라우저를 종료(모든 웹브라우저)하면 임시 쿠키가 삭제되기때문에 세션아이디도 삭제된다.vvvvvvvvvvvvvvvvvv
 */
@WebServlet("/servlet44")
public class Servlet44 extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    
   
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.printf("세션아이디 = %s",session.getId());
   
    
  }
  
}
