package test.controller.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.dao.CommentDao;
import test.vo.Comment;
import test.vo.JsonResult;


//@Component
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/travel/") // 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class CommentController {
  @Autowired
  CommentDao commentDao;

  @RequestMapping(path="cmlist")
  public Object list(int no ) throws Exception {
    System.out.println(no);
    try{
      
      
      return JsonResult.success(commentDao.selectList2(no));
    } catch(Exception e) {
      
      return JsonResult.fail(e.getMessage());
    }
    
    
  }
  
  @RequestMapping(path="cmadd")
  public Object add(Comment comment) throws Exception {
    try{
      System.out.println(comment.toString());      
      //System.out.println(no);
      //comment.setReviewboardNo(no);
      System.out.println(comment.getReviewcommentNo());
      commentDao.insert(comment);
      return JsonResult.success();
    } catch(Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  
}
