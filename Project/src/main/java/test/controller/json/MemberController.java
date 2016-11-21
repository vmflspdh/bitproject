package test.controller.json;

import java.io.File;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import test.dao.MemberDao;
import test.util.FileUploadUtil;
import test.vo.JsonResult;
import test.vo.Member;

@Controller
@RequestMapping("/travel/")// 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class MemberController {

  @Autowired MemberDao memberDao;
  @Autowired ServletContext sc;

  @RequestMapping(path="list")
  public Object list(
      @RequestParam (defaultValue="1") int pageNo,
      @RequestParam (defaultValue="5") int length) throws Exception{

    try {
      HashMap<String, Object> map = new HashMap<>();
      map.put("startIndex", (pageNo - 1) * length);
      map.put("length", length);

      return JsonResult.success(memberDao.selectList(map));

    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }

  }



  @RequestMapping(path="add")
  public Object add(Member member) throws Exception{
  	System.out.println(member);
  	
    try {
      
    	String email = member.getEmail();
    	
    	if (memberDao.checkEmail(email) != null) {
    		System.out.println("이메일 있음");
    		return JsonResult.fail();
    	} else {
    		System.out.println("이메일 없음");
    	memberDao.insert(member);
      return JsonResult.success();
    	}

    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }

  }

  @RequestMapping(path="detail")
  public Object detail(int no) throws Exception {

    try {
      Member member = memberDao.selectOne(no);

      if (member == null)
        throw new Exception("해당 번호의 게시물이 존재하지 않습니다.");
      return JsonResult.success(member);

    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }


  @RequestMapping(path="update")
  public Object update(Member member, MultipartFile file, HttpSession session) throws Exception {

    
    System.out.println(member);
    System.out.println(file);
    
    System.out.println("hi i received!!");
    try {
      HashMap<String,Object> paramMap = new HashMap<>();

      paramMap.put("no", member.getNo());
      paramMap.put("password", member.getPassword());

      if (memberDao.selectOneByPassword(paramMap) == null) {
        throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다.");
      }

      String newFilename = null;
      if (file != null) {
      if (!file.isEmpty()) {
        newFilename = FileUploadUtil.getNewFilename(file.getOriginalFilename());
        file.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
        System.out.println(newFilename);
        member.setMemberPhoto(newFilename);
        System.out.println(member);
      }
      session.setAttribute("member", member);
      memberDao.update(member);
      } else {
        System.out.println("수정할 파일이 없습니다.");
      }
      return JsonResult.success();

    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }



  @RequestMapping(path="delete")
  public Object delete(int no, String password) throws Exception {

    try {
      HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("no", no);
      paramMap.put("password", password);

      if (memberDao.selectOneByPassword(paramMap) == null) {
        throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다!");
      }
      memberDao.delete(no);
      return JsonResult.success();

    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }

}
