package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet29/header")
public class Servlet29_header extends HttpServlet  {

  private static final long serialVersionUID = 1L;

  // HttpGenericServlet2에서 추가한 메서드 중에서 POST 요청에 대해 호출될 메서드를 오버라이딩 하자!
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    
    
    PrintWriter out = response.getWriter();
    out.println("*************************");
    
  }

}
