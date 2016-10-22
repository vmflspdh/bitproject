package test.controller.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import test.dao.CommentDao;
import test.dao.ReviewDao;
import test.vo.Member;
import test.vo.Review;


//@Component
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/travel/") // 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class ReviewController {
  @Autowired
  ReviewDao reviewDao;
  @Autowired
  CommentDao commentDao;

  @RequestMapping(path="rvlist", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String list(
      @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(name = "length", defaultValue = "10") int length) throws Exception {
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      HashMap<String, Object> map = new HashMap<>();
      map.put("startIndex", (pageNo - 1) * length);
      map.put("length", length);
      
      List<Review> list = reviewDao.selectList(map);
//      result.put("totalPage", totalPage);
      
      int countAll = reviewDao.countAll();
      
      int totalPage = countAll/ length;
      if((countAll%length>0)){
        totalPage++;
      }
      
      //int reviewCount= commentDao.countAll(no);
      
      System.out.println(totalPage);
      result.put("totalPage", totalPage);
      result.put("length", length);
      result.put("pageNo", pageNo);
      result.put("state", "success");
      result.put("data", list);
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
    
    
  }
  
  
  
  /*@RequestMapping("list2")
  public ResponseEntity<String> list2(
      @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(name = "length", defaultValue = "5") int length) throws Exception {

    HashMap<String, Object> map = new HashMap<>();
    map.put("startIndex", (pageNo - 1) * length);
    map.put("length", length);

    List<Review> list = reviewDao.selectList(map);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/plain;charset=UTF-8");
    
    return new ResponseEntity<>(
        "클라이언트에게 보낼 내용",
        headers,
        HttpStatus.OK);
  }
  */
  

  @RequestMapping(path="rvadd", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String add(Review review, HttpSession session) throws Exception {
    // 성공하던 실패하던 클라이언트에게 데이터를 보내야 한다. 
    //
    Member member = (Member)session.getAttribute("member");
    review.setMemberno(member.getNo());
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      reviewDao.insert(review);
    result.put("state", "success");
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(path="rvdetail", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String detail(int no) throws Exception {
   
     // dispatcher servlet이 호출
                                        // //board/BoardDetail.do
                                        // 이걸 호출 하는 dispatcherservlet에서 모델객체를
                                        // 만들고
                                        // 모델객체에 담겨있는것을 ServletRequest로 바꺼줄거야
    HashMap<String, Object> result = new HashMap<>();
    try{
      Review review = reviewDao.selectOne(no);
      if(review==null)
        throw new Exception("해당 번호의 게시물이 존재하지 않습니다.");
    result.put("state", "success");
    result.put("data", review);
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(path="rvdetail2", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String detail2(int no) throws Exception {
   
     // dispatcher servlet이 호출
                                        // //board/BoardDetail.do
                                        // 이걸 호출 하는 dispatcherservlet에서 모델객체를
                                        // 만들고
                                        // 모델객체에 담겨있는것을 ServletRequest로 바꺼줄거야
    HashMap<String, Object> result = new HashMap<>();
    try{
      List<Review> list = reviewDao.selectOneByMember(no);
      if(list==null)
        throw new Exception("해당 번호의 게시물이 존재하지 않습니다.");
    result.put("state", "success");
    result.put("data", list);
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(path="rvupdate", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String update(Review review) throws Exception {

    HashMap<String, Object> result = new HashMap<>();
    try{

      reviewDao.update(review);
     /* reviewDao.update2(review);*/
/*      reviewDao.update2(review);
      reviewDao.update2(review);*/
      
      System.out.println(reviewDao.update(review));
      //System.out.println(reviewDao.update2(review));
      result.put("state", "success");
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(path="rvviewupdate", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String viewupdate(int no) throws Exception {

    HashMap<String, Object> result = new HashMap<>();
    try{
      
      reviewDao.viewCountUpdate(no);
      //System.out.println(reviewDao.viewCountUpdate(no));
      result.put("state", "success");
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(path="rvdelete", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String delete(int no) throws Exception {
    
    HashMap<String, Object> result = new HashMap<>();
    try{

      reviewDao.delete(no);
      result.put("state", "success");
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
 

  }
}
