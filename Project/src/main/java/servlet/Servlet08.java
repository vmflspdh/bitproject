/* 주제: 애노테이션으로 서블릿 등록하기
 * 서블릿 컨테이너가 이 애노테이션을 처리하도록 web.xml을 지정하라
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet08")
public class Servlet08  extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("안녕하세요~Hello~~~~~~~~~");
  }

  }

