// 계산기 웹 애플리케이션 만들기

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet12")
public class Servlet12 extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    
    int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    String op = request.getParameter("op");

  
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println(" <head>");
    out.println("<body>");
    out.println("</body>");
    out.println(" </head>");
    out.println("</html>");

    switch (op) {
    case "+": out.printf("%d %s %d = %d\n", a, op, b,  a + b); break;
    case "-": out.printf("%d %s %d = %d\n", a, op, b,  a - b); break;
    case "*": out.printf("%d %s %d = %d\n", a, op, b,  a * b); break;
    case "/": out.printf("%d %s %d = %d\n", a, op, b,  a / b); break;
    default:
    
    }

  }

}

/* URL과 특수문자
 * => '+' : URL에서 + 문자는 공백(space)를 의미한다.
 *          진짜 '+' 문자를 파라미터 값으로 표현하고 싶다면 URL 인코딩 문자로 표현하자!
 *          예) %2B
 * =. '%' : URL에서 %는 인코딩 문자의 시작 기호로 사용된다.
 *          예) %2b는 '+'문자의 코드 값을 의미한다.
 * 
 * URI(Uniform Resource Identifier)?
 * => 인터넷 상의 특정 컴퓨터에 저장된 자원(파일)을 가리키는 식별자 주소이다.
 * 
 * 1) URN
 *    예)
 * 2) URL
 *    예) http://
 *          
 *  URL 인코딩
 *  => 아스키 문자표에 없는 문자를 아스키 문자화시키는 것을 말한다.
 *  => URL을 작성할때 아스키 문자표(영어 대/소문자, 숫자, 특수문자 일부)에 정의되지 않는 문자는
 *     특별한 형식으로 변환해야한다.
 *     이렇게 특별한 문자로 변환하는 것을 'URL 인코딩'이라 부른다.
 *  => 아스키 문자 중에서도 URL 인코딩을 위해 사용되는 '%'문자나 공백을 표현하기 위해 사용되는 '+'와 같은 문자는 'URL인코딩' 하여야 한다.
 *  왜, 아스키 문자만 URL로 작성해야 하는가?
 *  => 게이트웨이 또는 라우터 장비 중에는 7비트 전용 장비가 존재한다.
 *  => 한글과 같이 8비트로 표현해야 하는 데이터는 이 장비를 통과하면 데이터 손실이 발생한다.
 *  => 그러나 ASCII 문자는 7비트이기 때문에 어떤 장비를 통과하더라도 데이터 손실이 발생하지 않는다.
 *  => 이런 이유로 한글처럼 8비트로 표현해야하는 데이터는 아스키 문자화 시켜야 한다.
 *  => URL 인코딩 예) 'A가' ------> A%EA%B0%80 (UTF-8 EAB080)
 *  
 */
