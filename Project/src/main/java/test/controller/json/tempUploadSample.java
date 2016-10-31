package test.controller.json;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import test.dao.BoardFileDao;
import test.util.FileUploadUtil;
import test.vo.BoardFile;


@Controller
@RequestMapping("/travel/")
public class tempUploadSample {
  @Autowired ServletContext sc;
  @Autowired BoardFileDao boardFiledao;
  

  @RequestMapping(value="fileUpload", method = RequestMethod.POST, produces="application/json")
  @ResponseBody
  public String upload(MultipartHttpServletRequest req, 
      HttpServletResponse res, HttpSession session) throws IOException {
    String uploadDir = sc.getRealPath("/upload") + "/";
    Iterator<String> itr =  req.getFileNames();
    /* Iterator : 모든 컬랙션으로부터 정보를 얻을 수 있는 인터페이스
     */
    MultipartFile mpf = req.getFile(itr.next());
    String originFileName = mpf.getOriginalFilename();

    String newFilename = null;
    if (mpf != null && ! mpf.isEmpty()) {
      newFilename = FileUploadUtil.getNewFilename(originFileName);
      mpf.transferTo(new File(uploadDir + newFilename));
      BoardFile boardFile = new BoardFile();
      boardFile.setTravelMainNo(54);
      boardFile.setFileName(newFilename);
      boardFiledao.insert(boardFile);
    }

    return "{\"code\":\"1\", \"msg\":\"file upload success.\",\"data\":\""+newFilename+"\"}";
  }
  
  
  

/*  @RequestMapping(path="userProfileFileLoder")
  public Object profileFileLoder (HttpSession session) {
    try {
      HoneyMembers honeyMember = (HoneyMembers)session.getAttribute("member");
      MemberFile memberFile = new MemberFile();
      memberFile.setFilename(hMembersService.getProfileFileName(honeyMember.getMemberNo()));
      return JsonResult.success(memberFile.getFilename());
    } catch(Exception e) {
      e.printStackTrace();
      return JsonResult.fail(e.getMessage());
    }

  }*/
  
}
