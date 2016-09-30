/* 주제: POST 요청으로 데이터를 보낼 때 한글 깨짐 문제
 * => GET 요청인 경우 톰캣 서버의 설정으로 클라이언트가 보내는 데이터의 문자표를 지정했다.
 * => POST 요청으로 데이터를 보내는 경우, 톰캣 서버의 설정으로 처리할 수 없다.
 *    데이터를 꺼내기 전에 어떤 문자표를 사용할 것인지 지정해야 한다.
 *    request.setcharactorEncoding
 * 
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet17")
public class Servlet17 extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
   
    // getParameter()를 호출하기 전에 클라이언트가 보낸 데이터가 어떤 문자표를 사용했는 알려줘라.
    // request.setCharacterEncoding("UTF-8");
    // 필터 03에 있음
    
    String age = request.getParameter("age");
    String name = request.getParameter("name");
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println(" <head>");
    out.println("<body>");
    
    out.printf("이름=%s, 나이=%s\n", name, age);
    
    out.println("</body>");
    out.println(" </head>");
    out.println("</html>");

  }

}

/* 클라이언트가 보낸 데이터를 꺼내기 전에 문자표를 지정하는 이유?
 * 데이터를 꺼낼 떄 getparameter() 메서드를 사용한다.
 * 이 메서드는 클라이언트가 보낸 데이터를 2바이트 유니코드로 변환하여 리턴한다.
 * 왜? 자바가 실행중에 문자로 다룰때는 2바이트 유니코드로 바꾸기 때문이다.
 * 즉 JVM은 무조건 문자를 2바이트 유니코드(char 타입)로 다룬다.
 * 문제는 클라이언트가 보낸 데이터를 기본으로 ISO-8859-1로 간주한다는 것이다.
 * 그 뜻은 클아이언트가 보낸 데이터를 영어로 간주하고 유니코드로 바꾸게 된다.
 * 예) 'AB가'
 * getParameter()를 호출하기 전에 클라이언트가 보낸 데이터가 어떤 문자표를 사용하는지 알려줘야 한다.
 * 그러면 제대로 변환할 것이다.

 */
