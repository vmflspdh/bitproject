package servlet3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 주제: include
 *    -다른 서블릿에 실행을 포함하고 싶을 때 사용하는 기법이다.
 *    -forward 다른 서블릿을 실행한후 되돌아 온다.
 */
@WebServlet("/servlet30")
public class Servlet30 extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //ServletContext보관소에 값을 저장한다.
    ServletContext servletContext = this.getServletContext();
    servletContext.setAttribute("a1", "hello");
    
    //ServeltRequest보관소에 값을 저장한다.
    request.setAttribute("r1", "world!");
    
    //다른서블릿으로 포워딩
    RequestDispatcher rd = request.getRequestDispatcher("/servlet31");
    rd.forward(request, response);
  }

}
