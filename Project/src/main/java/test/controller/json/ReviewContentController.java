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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import test.dao.CommentDao;
import test.dao.ReviewContentDao;
import test.dao.ReviewDao;
import test.dao.TravelScheduleDao;
import test.util.FileUploadUtil;
import test.vo.ReviewContent;
import test.vo.TravelMain;


//@Component
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/travel/") // 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class ReviewContentController {
  @Autowired ReviewContentDao reviewContentDao;
  @Autowired TravelScheduleDao travelScheduleDao;
  @Autowired ReviewDao reviewDao;
  @Autowired ServletContext sc;
  @Autowired CommentDao commentDao;

  TravelMain travelMain = new TravelMain();
  ReviewContent reviewContent = new ReviewContent();
  
  @RequestMapping(path="rvclist", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String list(int no) throws Exception {
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      List<ReviewContent> list = reviewContentDao.selectOne(no);

      
      //int reviewCount= commentDao.countAll(no);
      
      result.put("state", "success");
      result.put("data", list);
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
        
  }
  
  @RequestMapping(path="rvcupdate", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String viewContentUpdate(ReviewContent reviewContent,MultipartFile[] files) throws Exception {
    System.out.println(files.length);
    System.out.println(reviewContent);
    HashMap<String, Object> result = new HashMap<>();
    try{
      
      reviewContentDao.reviewContentUpdate2(reviewContent);
      String newFilename = null;
      if (!files[0].isEmpty()) {
        newFilename = FileUploadUtil.getNewFilename(files[0].getOriginalFilename());
        files[0].transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
        reviewContent.setReviewBoardContentPhotoName(newFilename);
        System.out.println(reviewContentDao.reviewContentUpdate(reviewContent));
      } else{
        System.out.println(reviewContentDao.reviewContentUpdate2(reviewContent));
      }
      result.put("state", "success");
    } catch(Exception e) {
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }
  

  
  
  
  
  @RequestMapping(path="rvcinsert", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String insert(HttpSession session) throws Exception {
    // 성공하던 실패하던 클라이언트에게 데이터를 보내야 한다. 
    //
    //Member member = (Member)session.getAttribute("member");
    
    
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      HashMap<String,Object> map = new HashMap<>();
      travelMain.setTravelMainNo((Integer)session.getAttribute("travelPostNo"));
      map.put("travelPostNo", travelMain.getTravelMainNo());
      List<TravelMain> list =travelScheduleDao.selectMySchedule(map);
      
      for(int i=0;i<list.size();i++){
        list.get(i).getScheduleNo();
        
      }
      System.out.println((Integer)session.getAttribute("SchNo"));
      //HashMap<String, Object> map = new HashMap<>();
      
     // TravelMain travelMain = new TravelMain();
//      map.put("reviewBoardNo", value);//reviewBoardNo
      session.getAttribute("schNo");
      //map.put("scheduleNo", (TravelMain)session.getAttribute("SchNo"));//scheduleNo
      //reviewContentDao.insert(map);
      
          
          
      result.put("state", "success");
    } catch(Exception e) {
      e.printStackTrace();
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }
  
  
  @RequestMapping(path="rvcdelete", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String delete(int no,HttpSession session) throws Exception {
    
    
    HashMap<String, Object> result = new HashMap<>();
    try{
          
          commentDao.delete(no);//rcno
          reviewContentDao.delete(no);//rbcno
          reviewDao.delete(no);//rbno
          
      result.put("state", "success");
    } catch(Exception e) {
      e.printStackTrace();
      result.put("state", "fail");
      result.put("data", e.getMessage());
    }
    return new Gson().toJson(result);
  }
  
  
}
