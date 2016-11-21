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
import test.dao.MemberDao;
import test.vo.Invite;
import test.vo.Member;
import test.vo.RegistForm;


//@Component
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/travel/") // 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class InviteController {
  @Autowired
  InviteDao inviteDao;
  @Autowired
  MemberDao memberDao;
  
  
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
  public String add4(int no, int no2,  HttpSession session) throws Exception {
    //1. 초대를 요청하는테이블에서 이사용자가 등록되어있는지 확인
    //2. 만약 등록되어있다면 
    
    // 성공하던 실패하던 클라이언트에게 데이터를 보내야 한다. 
    //
    System.out.println(no);
    System.out.println(no2);
     Invite invite = new Invite(); 
    //System.out.println(registform);
    HashMap<String, Object> result = new HashMap<>();
    try{
      
      Member member = (Member)session.getAttribute("member");
      System.out.println(member.getNo());
      invite.setMemberNo(member.getNo());
      invite.setMemberNo2(no);
      invite.setInviteName(member.getName());
      invite.setInviteEmail(member.getEmail());
      invite.setInviteGender(member.getGender());
      invite.setState(0);
      invite.setInvitePhoto(member.getMemberPhoto());
      invite.setInviteBoardNo(no2);
      System.out.println(invite);
      //System.out.println(member.getNo());
      if(inviteDao.inviteCheck(invite)>0){
        result.put("state", "exist");
      } else {
        inviteDao.insert(invite);
        result.put("state", "success");
      }
      
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }

  
  @RequestMapping(path="invagree", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String agree(int no, int no2, int no3 ,HttpSession session) throws Exception {
    // 성공하던 실패하던 클라이언트에게 데이터를 보내야 한다. 
    HashMap<String, Object> result = new HashMap<>();
    System.out.println(no2);
    try{
      Invite invite = new Invite();
      Member member = memberDao.selectOne(no2);
      invite.setMemberNo(member.getNo());
      invite.setMemberNo2(no3);
      invite.setInviteName(member.getName());
      invite.setInviteEmail(member.getEmail());
      invite.setInviteGender(member.getGender());
      invite.setState(1);
      invite.setInvitePhoto(member.getMemberPhoto());
      invite.setInviteBoardNo(no);
      
      System.out.println(member);
      session.setAttribute("inviteMemberNo", invite.getMemberNo2());
      inviteDao.inviteAgreeInsert(invite);
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
