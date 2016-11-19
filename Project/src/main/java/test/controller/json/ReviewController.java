package test.controller.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import test.dao.CommentDao;
import test.dao.ReviewContentDao;
import test.dao.ReviewDao;
import test.dao.ReviewPhotoDao;
import test.util.FileUploadUtil;
import test.vo.Member;
import test.vo.Review;
import test.vo.ReviewContent;
import test.vo.ReviewPhoto;


//@Component
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/travel/") // 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class ReviewController {
  @Autowired ReviewDao reviewDao;
  @Autowired CommentDao commentDao;
  @Autowired ServletContext sc;
  @Autowired ReviewPhotoDao reviewPhotoDao;
  @Autowired ReviewContentDao reviewContentDao;
  
  ReviewPhoto reviewPhoto = new ReviewPhoto();
  ReviewContent reviewContent = new ReviewContent();
  
  

  @RequestMapping(path="rvlist", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String list(
      @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(name = "length", defaultValue = "5") int length) throws Exception {
    
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
  

  
  
  
  @RequestMapping(path="rvphotoList", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String photolist(int no) throws Exception {
    System.out.println(no);
    HashMap<String, Object> result = new HashMap<>();
    try{
      
      List<ReviewContent> list = reviewContentDao.reviewPhotoList(no);
      
      result.put("state", "success");
      result.put("data", list);
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
    
    
  }
  
  
 /* @RequestMapping(path="upload", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String upload(int no) throws Exception {
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      
      List<ReviewPhoto> list = reviewPhotoDao.photoList(no);
      
      result.put("state", "success");
      result.put("data", list);
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
    
    
  }*/
  
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
  public String add(Review review,String reviewContentList, HttpSession session,MultipartFile[] files) throws Exception {
    // 성공하던 실패하던 클라이언트에게 데이터를 보내야 한다. 
    //
    System.out.println(reviewContentList);
    System.out.println(files.length);
    List<ReviewContent> list = new Gson().fromJson(reviewContentList, new TypeToken<List<ReviewContent>>(){}.getType());
    System.out.println(list.size());
    
    
    
    
    
    Member member = (Member)session.getAttribute("member");
    review.setMemberno(member.getNo());
    
    if (files.length != 0) {
        for(int j = 0; j < files.length; j++){
      System.out.println(files[j]);
    }
    }
    
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      
      
      reviewDao.insert(review);
      System.out.println(review);
      
      String newFilename = null;
      for(int i = 0 ; i < list.size() ; i++){
        reviewContent.setReviewBoardNo(review.getReviewboardno());
        reviewContent.setScheduleNo(list.get(i).getScheduleNo());
        reviewContent.setContent(list.get(i).getContent());
        reviewContent.setReviewBoardContentPhotoName(list.get(i).getReviewBoardContentPhotoName());
        if (files.length != 0 && !files[i].isEmpty()) {
          newFilename = FileUploadUtil.getNewFilename(files[i].getOriginalFilename());
          files[i].transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
          reviewContent.setReviewBoardContentPhotoName(newFilename);
        }
        System.out.println(reviewContent);
        reviewContentDao.insert(reviewContent);
      }
      
      
      
      /*for (int i = 0; i < files.length; i++) {
        if (!files[i].isEmpty()) {
          newFilename = FileUploadUtil.getNewFilename(files[i].getOriginalFilename());
          files[i].transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
          reviewPhoto.setReviewBoardNo(review.getReviewboardno());
          reviewPhoto.setReviewPhotoName(newFilename);
          System.out.println(reviewPhoto);
          reviewPhotoDao.insert(reviewPhoto);
          
          
        }
      }*/
    result.put("state", "success");
    } catch(Exception e) {
      e.printStackTrace();
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
  public String update(Review review,int no,MultipartFile[] files) throws Exception {
    System.out.println(no);
    HashMap<String, Object> result = new HashMap<>();
    
    for(int j = 0; j < files.length; j++){
      System.out.println(files[j]);
    }
    
    try{
      System.out.println(files);

      reviewDao.update(review);
      
      for (int i = 0; i < files.length; i++) {
        if (!files[i].isEmpty()) {
          reviewPhotoDao.delete(no);
        }
      }
      
      
      String newFilename = null;
      for (int i = 0; i < files.length; i++) {
        if (!files[i].isEmpty()) {
          newFilename = FileUploadUtil.getNewFilename(files[i].getOriginalFilename());
          files[i].transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
          reviewPhoto.setReviewBoardNo(review.getReviewboardno());
          reviewPhoto.setReviewPhotoName(newFilename);
          
          reviewPhotoDao.insert(reviewPhoto);
        } else {
          newFilename = FileUploadUtil.getNewFilename(files[i].getOriginalFilename());
          files[i].transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
          reviewPhoto.setReviewBoardNo(review.getReviewboardno());
          reviewPhoto.setReviewPhotoName(newFilename);
          reviewPhotoDao.insert(reviewPhoto);
        }
        
      }
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
    System.out.println(no);
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
