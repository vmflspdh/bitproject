package test.controller.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import test.dao.InviteDao;
import test.vo.Invite;
import test.vo.Member;
import test.vo.RegistForm;
import test.vo.Review;


//@Component
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/travel/") // 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class InviteController {
  @Autowired
  InviteDao inviteDao;
  
  
  @RequestMapping(path="invlist", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String list(HttpSession session) throws Exception {
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      Member member = (Member)session.getAttribute("member");
      int no =  member.getNo();
      List<Invite> list = inviteDao.inviteList(no);
      
      
      result.put("state", "success");
      result.put("data", list);
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
    
    
  }
  

  @RequestMapping(path="invadd", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String add(RegistForm registform,  HttpSession session) throws Exception {
    // 성공하던 실패하던 클라이언트에게 데이터를 보내야 한다. 
    //
    Invite invite = new Invite(); 
    //System.out.println(registform);
    HashMap<String, Object> result = new HashMap<>();
    try{
     
      Member member = (Member)session.getAttribute("member");
      
      invite.setMemberNo(member.getNo());
      invite.setMemberNo2(registform.getMemberNo());
      invite.setInviteName(member.getName());
      invite.setInviteEmail(member.getEmail());
      invite.setInviteGender(member.getGender());
      invite.setState(0);
      invite.setInvitePhoto(member.getMemberPhoto());
      System.out.println(invite);
      System.out.println(registform);
      //System.out.println(member.getNo());
      inviteDao.insert(invite);
    result.put("state", "success");
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }

  
  @RequestMapping(path="invagree", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String agree(int no,  HttpSession session) throws Exception {
    // 성공하던 실패하던 클라이언트에게 데이터를 보내야 한다. 
    HashMap<String, Object> result = new HashMap<>();
    try{
      System.out.println(no);
      inviteDao.inviteAgree(no);
      result.put("state", "success");
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(path="invrefuse", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String refuse(int no,  HttpSession session) throws Exception {
    // 성공하던 실패하던 클라이언트에게 데이터를 보내야 한다. 
    HashMap<String, Object> result = new HashMap<>();
    try{
      System.out.println(no);
      inviteDao.inviteRefuse(no);
      result.put("state", "success");
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(path="invagreelist", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String agreelist(HttpSession session) throws Exception {
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      Member member = (Member)session.getAttribute("member");
      int no =  member.getNo();
      List<Invite> list = inviteDao.inviteAgreeList(no);
      
      
      result.put("state", "success");
      result.put("data", list);
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
    
    
  }
  
}
