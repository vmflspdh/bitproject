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
/* 주제 : 기존의 세션 생성하기
 *    세션 관리 정책에 따라서,
 *    웹브라우저에서 세션아이디를 요청 헤더에 첨부하여 쿠키 형태로 보냈고,
 *    서블릿에서 확인해보니 그 세션 아이디에 해당하는 세션 객체가 존재하고 유효하다면, 그 존재하는 객체를 리턴한다.
 */
@WebServlet("/servlet46")
public class Servlet46 extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    session.setAttribute("name","홍길순");
    session.setAttribute("gender", false);
    session.setAttribute("age",20);
    session.setAttribute("date",new Date());
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.printf("세션아이디 = %s",session.getId());
   
    
  }
  
}
