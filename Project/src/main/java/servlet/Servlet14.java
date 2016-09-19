package servlet;
/*
 * 주제: 요청 방식과 응답 - GET, POST, HEAD
 * => GET
 * 
 * => POST
 * 
 * => HEAD
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet14")
public class Servlet14 extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    //클라이언트가 보낸 데이터 꺼내기
    // 서블릿에 데이터 보내는 방버?
    // URL에 데이터를 첨부한다.
    // 예) http://localhost:8080/web01/servlet11?파라미터명=값&파라미터명=값&파라미터명=값;
    
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    out.printf("이름=%s, 나이=%s",request.getParameter("name"), request.getParameter("age"));
      
    
    out.println("</body>");
    out.println("</html>");
    
    /* GET 방식
     * 설명 
     * 서버에 보내는 데이터는 URL에포함된다.
     * /web01/servlet14?name=aaa&age=111
     * 한 번에 보낼수 있는 데이터가 제한된다.
     * 왜? 웹서터는 보통 request-line또는 header의 크기를 제한하기 때문이다
     * 예) Tomcat/Apache(8KB) ,IIS6/7(16KB)
     * 바이너리 데이터를 전송할수 없다.
     * URL 에 데이터가 포함되기 때문에 URL과 데이터를 함께 저장할 수 있다.
     * 
     * 
     * => 특징정리
     *  소량의 데이터를 보낼때 (게시글 상세보기,삭제) 사용
     *  바이너리 데이터 전송 불가
     *  즐겨 찾기로 등록하거나 이메일 또는 게시판을 통해 링크 정보를 공유하기 쉽다.
     *  데이터의 보안을 요구하는 곳에 사용하면 안된다
     * 
     * POST 방식
     * 설명
     * 서버에 보내는 데이터는 message-body에 포함된다.
     *  title=bbb&age=22
     * message-body에 대한 데이터 정보가 요청헤더에 포함된다.
     * Content-length:40
     * Content-Type:application/x-www-form-urlencoded
     * 서버에 보내는 데이터의 크기 제한이 없다.
     * 서버에서 승인하는 만큼 보낼 수 있다.
     * mult-part 포맷으로 바이너리 데이터를 전송할수있다.
     * URL과 데이터 정보가 분리되어 있어 링크 정보를 공유할수 없다.
     * 
     * => 특징정리
     *  대용량 데이터를 보낼때 (게시글 등록/삭제)사용
     *  바이너리 데이터 전송가능
     *  특정 결과를 출력하는 페이지의 링크정보를 공유해봐야 소용없다.
     *  URL에 데이터가 포함되어 있지 않기 때문에 보안을 요구하는 데이터인 경우 노출을 막을 수 있다.
     * 
     * web01/servlet14?name=bbb&age=111
     * 
     * HEAD 요청
     * 웹브라우저에서 HEAD요청을 발생시킬 수 없다.
     * => 요청 프로토콜 예)
     * HEAD /web01/servlet14 HTTP/1.1
     * Host: localhost:8080
     * 
     * => 응답 프로토콜 예)
     * HTTP/1.1 200 OK
       Server: Apache-Coyote/1.1
       Content-Type: text/html;charset=UTF-8
       Transfer-Encoding: chunked
       Date: Wed, 24 Aug 2016 02:39:16 GMT
       
     * =>설명
     *  서버에 그 자원에 대한 정보만 알고 싶을 때 사용한다.
     *  서버는 요청한 자원의 데이터를 보내지 않고 그 자원에 대한 헤더 정보만 보낸다.
     *  보통 프록시 서버에서 웹서버에 요청할 때 사용한다.
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
    
    
   
    
    
    
  }
}

/* HTTP 요청(Web Browser--> Web Server)
 * 
 * 
 * 
 * 
 * 
 * 
 * HTTP 응답
 */


















