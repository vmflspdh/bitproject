package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet09")
public class Servlet09 extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    //0) 출력도구가 사용할 문자표 지정
    // setContentType("MIME Type;문자표")
    // => MIME (multi-purpose Internet Mail Extention) Type?
    // - 보내는 데이터의 타입을 상대에게 알려줘야 상대편에서 제대로 처리할 수 있다.
    // - Email 프로그램에서 첨부하여 보내는 데이터 타입을 지정하기 위해 만드 문법이다.
    // - 그러나 오늘 날에는 이메일 뿐만 아니라 다른 기술에서도 이 MIME Type을 사용하고 있다.
    // 보통 많이 사용되는 MIME 타입은 국제적으로 공개되ㅓ 있다.
    response.setContentType("text/plain;charset=UTF-8");
    
    // 1) 출력도구를 얻는다.
    PrintWriter out = response.getWriter();
    
    //2) 출력 도구를 사용하여 클라이언트에게 데이터를 보낸다.
    //=> getWriter()가 리턴한 출력도구는 기본으로 Unicode를 ISO-8859-1 문자표에 따라 변환하여 출력한다.
    //=> ISO-8859-1 문자표?
    //  영어 대/소문자, 숫자, 특수문자 등 약 100자 정도의 문자에 대해 코드 값을 정의해 놓고 있따.
    //  즉, 한글에 대해서는 코드 값을 정의하지 않았다.
    // => 그래서 한글 유니코드는 ISO-8859-1 문자표에 없다는 의미에서 '?' 문자코드로 변환되어 출력된다.
    // => 웹브라우저의 출력결과과 그 이유?
    //    영어는 제대로 출력되지만, 한글은'?'로 출력되는 이유이다.
    //=> 해결책?
    //   유니코드를 출력할 때 사용할 문자표를 ISO-8859-1에서 UTF-8로 교체하면 된다.
    // 반드시 출력도구를 얻기 전에, setContentType() 메서드를 호출하여 사용할 문자표를 지정한다.
    // 
    out.println("안녕하세요~~~Hello");
    
    
  }

}
