/* 주제: HTTP 요청과 응답
 * => 웹 브라우저는 웹 서버에 요청할 때 HTTP 규칙에 따라 데이터를 보낸다
 * => 웹서버 또한 웹 브라우저에 응답할 때 HTTP 규칙에 따라 데이터를 보낸다.
 * => 확인하는 방법
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

@WebServlet("/servlet14")
public class Servlet14 extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
   
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println(" <head>");
    out.println("<body>");
    
    out.printf("이름=%s, 나이=%s\n", request.getParameter("name"), request.getParameter("age"));
    
    out.println("</body>");
    out.println(" </head>");
    out.println("</html>");

  }

}

//GET /web01/servlet14?name=aaa&age=111 HTTP/1.1
//Host  localhost:8080
//Upgrade-Insecure-Requests 1
//User-Agent  Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36
//Accept  text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//Referer http://localhost:8080/web01/servlet14.html
//Accept-Encoding gzip, deflate, sdch
//Accept-Language ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

/* 설명
 * - 서버에 보내는 데이터는 URL에 포함된다.
 * web01/servlet14?name=aaa&age=111
 * 한번에 보낼 수 있는 데이터가 제한된다
 * 왜? 웹서버는 보통 request-Line 또는 header 크기를 제한하기 때문이다.
 * 소량의 데이터를 보낼 때 사용 (게시글 상세보기, 삭제)
 * 바이너리 데이터를 전송할 수 없다.
 * 즐겨찾기를 등록하거나 이메일로 링크 정보를 공유하기 쉽다.
 * URL에 데이터가 포함되기 때무네 URL과 데이터를 함께 저장할 수 있다.
 * 데이터의 보안을 요구하는 곳에 사용하면 안된다.
 */

// ----------------------------------------------------------------------------------------

//POST /web01/servlet14 HTTP/1.1
//Host  localhost:8080
//Content-Length  16
//Cache-Control max-age=0
//Origin  http://localhost:8080
//Upgrade-Insecure-Requests 1
//User-Agent  Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36
//Content-Type  application/x-www-form-urlencoded
//Accept  text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//Referer http://localhost:8080/web01/servlet14.html
//Accept-Encoding gzip, deflate
//Accept-Language ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.

/* => 설명
 * - 서버에 보내는 데이터는 message-body에 포함된다.
 *    name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=222
 * - message-body에 대한 데이터 정보가 요청 헤더에 포함된다.
 *    content-Length: 40
 *    => 대용량 데이터를 보낼 때 사용 (게시글 등록, 수정)
 *  multi-part 포맷으로 데이터를 보낼 수 있다.
 *  URL과 데이터 정보가 분리되어 있어 링크 정보를 공유할 수 없다.
 *  특정 결과를 출력하는 페이지의 URL을 공유할 수 없다.
 *  URL에 데이터가 포함되어 있지 않기 때문에 보안을 요구할 수 없다.
 */

/* HEAD 요청
 * 프로토콜 예)
 * 설명
 * 서버는 그 자원에 대한 정보만 알고 싶을 때 사용한다.
 * 서버는 요처한 자원의 데이터를 보내지 않고 그 자원에 대한 헤더 정보만 보낸다.
 * 보통 프록시 서버에서 웹 서버에 요청할 떄 사용한다.
 */
