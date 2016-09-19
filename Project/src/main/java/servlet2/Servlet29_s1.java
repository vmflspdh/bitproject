package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 주제: include
 *    -다른 서블릿에 실행을 포함하고 싶을 때 사용하는 기법이다.
 *    -forward 다른 서블릿을 실행한후 되돌아 온다.
 */
@WebServlet("/servlet29/s1")
public class Servlet29_s1 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  // HttpGenericServlet2에서 추가한 메서드 중에서 POST 요청에 대해 호출될 메서드를 오버라이딩 하자!
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/plain;charset=UTF-8");

    RequestDispatcher rd = request.getRequestDispatcher("/servlet29/header");
    rd.include(request, response);

    try{
      int a = Integer.parseInt(request.getParameter("a"));
      int b = Integer.parseInt(request.getParameter("b"));
      String op = request.getParameter("op");
      int result = 0;
      switch(op) {
      case "+": result=a+b; break;
      case "-": result=a-b; break;
      case "*": result=a*b; break;
      case "/": result=a/b; break;
      default:
        throw new Exception("지원하지 않는 연산자입니다.");
      }
      PrintWriter out = response.getWriter();
      out.printf("%d %s %d = %d\n", a,op,b,result);
      
    } catch(Exception e){
      rd = request.getRequestDispatcher("/servlet29/error");
      rd.forward(request, response);//forward는 한번보내면 안돌아온다.
    }
    
    rd = request.getRequestDispatcher("/servlet29/footer");
    rd.include(request, response);
//    System.out.println("-----------------------------");
  }

}
