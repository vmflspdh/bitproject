/* GET과 POST, HEAD의 호출
 *  
 */


package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpGenericServlet2 extends GenericServlet{
  
  // 이 메서드는 톰캣서버가 호출해야하기 때문에 무조건 퍼블릭으로

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    System.out.println("service(ServletRequest,ServletResponse)");

    HttpServletRequest httpRequest = (HttpServletRequest)request;
    HttpServletResponse httpResponse = (HttpServletResponse)response;

    service(httpRequest, httpResponse);

  }

  // 위의 service()에서 내부적으로 호출하거나, 자식 클래스가 재정의 할 수 있기 때문에
  // protected로 선언한다. 단 외부에서 호출할 일이 없기 때문에 public으로 공개할 필요는 없다.
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    switch (request.getMethod()) {
    case "GET": doGet(request, response); break;
    case "POST": doPost(request, response); break;
    case "HEAD": doHead(request, response); break;
    case "TRACE": doTrace(request, response); break;
    case "DELETE": doDelete(request, response); break;
    case "PUT": doPut(request, response); break;
    default :
      doDefault(request, response);
    }
  }

  // 이 메서드는 자식 클래스에서도 사용하지 않기 때문에 private로 사용한다.
  private void doDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>오류</title></head>");
    out.println("<body>");
    out.println("<h1>오류!</h1>");
    out.println("<p>요구하신 HTTP 요청 메서드를 지원하지 않습니다.</p>");
    out.println("</body></html>");

  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    doDefault(request, response);
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    doDefault(request, response);
  }
  protected void doHead(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    doDefault(request, response);

  }

  protected void doTrace(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    doDefault(request, response);

  }

  protected void doDelete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    doDefault(request, response);

  }



  protected void doPut(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    doDefault(request, response);

  }






}
