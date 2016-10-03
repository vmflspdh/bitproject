package test.controller.json;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import test.dao.MemberDao;
import test.vo.Member;

@Controller
@RequestMapping("/travel/")// 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class MemberController {

  @Autowired
  MemberDao memberDao;

  @RequestMapping(path="list", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String list(
      @RequestParam (defaultValue="1") int pageNo,
      @RequestParam (defaultValue="5") int length) throws Exception{


    HashMap<String, Object> result = new HashMap<>();

    try {
      HashMap<String, Object> map = new HashMap<>();
      map.put("startIndex", (pageNo - 1) * length);
      map.put("length", length);

      List<Member> list = memberDao.selectList(map);
      result.put("state", "success");
      result.put("data", list);


    } catch (Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }

    return new Gson().toJson(result);


  }
  
  

  @RequestMapping(path="add" , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String add(Member member) throws Exception{
    // 성공하든 실패하든 클라이언트에게 데이터를 보내야 한다.
    HashMap<String, Object> result = new HashMap<>();

    try {
      memberDao.insert(member);
      result.put("state", "success");

    } catch (Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }

    return new Gson().toJson(result);

  }

  @RequestMapping(path="detail", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String detail(int no) throws Exception {


    HashMap<String, Object> result = new HashMap<>();

    try {
      Member member = memberDao.selectOne(no);

      if (member == null)
        throw new Exception("해당 번호의 게시물이 존재하지 않습니다.");
      result.put("state", "success");
      result.put("data", member);

    } catch (Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }

    return new Gson().toJson(result);

  }


  @RequestMapping(path="update", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String update(Member member) throws Exception {


    HashMap<String, Object> result = new HashMap<>();
    System.out.println("hi i received!!");
    try {
      HashMap<String,Object> paramMap = new HashMap<>();

      paramMap.put("no", member.getNo());
      paramMap.put("password", member.getPassword());

    if (memberDao.selectOneByPassword(paramMap) == null) {
        throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다.");
      }
      memberDao.update(member);
      result.put("state", "success");

    } catch (Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }

    return new Gson().toJson(result);

  }

  @RequestMapping(path="delete", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
    public String delete(int no, String password) throws Exception {
      HashMap<String,Object> result = new HashMap<>();
      try {
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("no", no);
        paramMap.put("password", password);
        
        if (memberDao.selectOneByPassword(paramMap) == null) {
          throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다!");
        }
        memberDao.delete(no);
        result.put("state", "success");
      } catch (Exception e) {
        result.put("state", "fail");
        result.put("data", e.getMessage());
      }

    return new Gson().toJson(result);


  }

}
