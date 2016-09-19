package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// POST와 GET, HEAD, 등의 요청을 구분하여 메서드 호출
// HttpGenericServlet 클래스에서 한 발 더 나아 가 
// 클라이언트의 HTTP 요청을 구분해서 메서드를 호출하도록 추가하엿다.
public abstract class HttpGenericServlet2 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  // 이 메서드는 톰캣 서버(Servlet Container)가 호출하기 떄문에 public으로 공개해야 한다.
  // SErvlet 인터페이스에 선언된 메서드는 무조건 public이다.
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    System.out.println("service(ServletRequest,ServletReseponse)");
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    service(httpRequest, httpResponse);
  }

  // 이 메서드는 위의 service에서 내부적으로 호출하거나,
  // 자식 클래스가 재정의 할지도 모르기 때문에 public으로 공개할 필요는 없다.
  // protected로 선언한다. 단 외부에서 호출할 일이 없기 때문에 public으로 공개할 필요는 없다.
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    switch (request.getMethod()) {
    case "GET":
      doGet(request, response);
      break;
    case "POST":
      doPost(request, response);
      break;
    case "HEAD":
      doHead(request, response);
      break;
    case "TRACE":
      doTreace(request, response);
      break;
    case "DELETE":
      doDelete(request, response);
      break;
    case "PUT":
      doPut(request, response);
      break;
    default:
      doDefault(request, response);
      break;

    }
  }

  // 이 메서드는 자식 클래스에서도 사용하지 않기 때문에 private로 접근권한을 최소로 낮춘다.
  private void doDefault(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>오류!</title></head>");
    out.println("<body>");
    out.println("<h1>오류!</h1>");
    out.println("<p>요구하신 HTTP 요청 메서드를 지원하지 않습니다.</p>");
    out.println("</body></html>");
  }

  // 나머지 메서드는 자식 클래스에서 오버라이딩 할수도 있기 때문에 protected로 한다.
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);
  }

  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doDefault(request, response);
  }

  protected void doTreace(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doDefault(request, response);
  }

  protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);
  }
}
