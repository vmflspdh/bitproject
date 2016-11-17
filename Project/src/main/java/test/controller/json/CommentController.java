package test.controller.json;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.dao.CommentDao;
import test.vo.Comment;
import test.vo.JsonResult;
import test.vo.Member;


//@Component
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/travel/") // 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class CommentController {
  @Autowired
  CommentDao commentDao;

  @RequestMapping(path="cmlist")
  public Object list(int no,HttpSession session ) throws Exception {
    /*System.out.println(no);
    Member member=(Member)session.getAttribute("member");
    
    System.out.println(member.getNo());*/
    try{

      return JsonResult.success(commentDao.selectList2(no));
    } catch(Exception e) {
      
      return JsonResult.fail(e.getMessage());
    }
    
    
  }
  
  @RequestMapping(path="cmadd")
  public Object add(Comment comment,HttpSession session) throws Exception {
    Member member = (Member)session.getAttribute("member");
    try{
    comment.setMemberNo(member.getNo());
    
      //System.out.println(comment.toString());      
      //System.out.println(no);
      //comment.setReviewboardNo(no);
      //System.out.println(comment.getReviewcommentNo());
      commentDao.insert(comment);
      return JsonResult.success();
    } catch(Exception e) {
      //JOptionPane.showConfirmDialog(null, "기본 확인창입니다.");
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  @RequestMapping(path="cmupdate")
  public Object update(Comment comment) throws Exception {

    try {
      System.out.println(comment.toString());
      System.out.println(commentDao.update(comment));
      return JsonResult.success();

    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  @RequestMapping(path="cmdelete")
  public Object delete(int no) throws Exception {

    try {
      System.out.println(commentDao.delete(no));
      return JsonResult.success();

    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  
}
