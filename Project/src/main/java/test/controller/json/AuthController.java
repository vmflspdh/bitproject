package test.controller.json;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import test.dao.BookmarkDao;
import test.dao.InviteDao;
import test.dao.MemberDao;
import test.vo.JsonResult;
import test.vo.Member;

@Controller 
@RequestMapping("/travel/") 
@SessionAttributes({"member"}) // Model 객체에 저장된 정보 중에서 로그인 회원 정보는 따로 세션으로 관리한다.
public class AuthController {

  @Autowired MemberDao memberDao;
  @Autowired InviteDao inviteDao;
  @Autowired BookmarkDao bookmarkDao;

  @RequestMapping(path="login")
  public Object login(
      HttpSession session, /* 세션이 무효화된 이후에 세션을 자동 생성하도록 강제한다.*/
      HttpServletResponse response,
      String email,
      String password,
      boolean saveEmail, 
      Model model,
      SessionStatus sessionStatus) throws Exception {

    try {
      Cookie cookie = new Cookie("email", email);
      if (!saveEmail) {
        cookie.setMaxAge(0); 
      } else {
        cookie.setMaxAge(60 * 60 * 24 * 7);
      }
      response.addCookie(cookie);

      response.addCookie(new Cookie("test", "okok"));
      cookie = new Cookie("test2", "nono");
      cookie.setMaxAge(120);
      response.addCookie(cookie);

      HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("email", email);
      paramMap.put("password", password);
      Member member = memberDao.selectOneByEmailAndPassword(paramMap);

      if (member == null) {
        sessionStatus.setComplete(); // 스프링이 관리하는 세션 값을 무효화시킨다.
        return JsonResult.fail();

      } else {
        model.addAttribute("member", member); // Model 객체에 로그인 회원 정보를 담는다.
        return JsonResult.success();
      }

    } catch (Exception e) {
      return JsonResult.error(e.getMessage());
    }
  }

  @RequestMapping(path="logout")
  public Object logout(HttpSession session, SessionStatus sessionStatus) throws Exception {

    try {
      sessionStatus.setComplete();
      session.invalidate();
      return JsonResult.success();
    } catch (Exception e) {
      return JsonResult.error(e.getMessage());
    }
  }

  @RequestMapping(path="loginUser")
  public Object loginUser(HttpSession session) throws Exception {
    
    
    
    try {
      Member member = (Member)session.getAttribute("member");
      if (member == null) {
        throw new Exception("로그인이 되지 않았습니다.");
      }
      //System.out.println(member.setInviteCount(inviteDao.inviteCount(member.getNo())));
//      System.out.println();
      int RequestCountAll = (inviteDao.inviteCount(member.getNo()))+(bookmarkDao.bookmarkCount2(member.getNo()));
      System.out.println(RequestCountAll);
      member.setMemberRequest(RequestCountAll);
      //inviteDao.inviteCount(member.getNo());
      System.out.println(member);
      return JsonResult.success(member);
    } catch (Exception e) {
      return JsonResult.error(e.getMessage());
    }  
  }
  
  @RequestMapping(path="regUserPhoto")
  public Object regUserPhoto(int no,HttpSession session) throws Exception {
    
    
    
    try {
      
      System.out.println(no);
      Member member=memberDao.regUserPhoto(no);
      return JsonResult.success(member);
    } catch (Exception e) {
      return JsonResult.error(e.getMessage());
    }  
  }

}










