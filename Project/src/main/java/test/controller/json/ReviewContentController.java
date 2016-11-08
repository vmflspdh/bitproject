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

import test.dao.ReviewContentDao;
import test.dao.TravelScheduleDao;
import test.vo.ReviewContent;
import test.vo.TravelMain;


//@Component
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/travel/") // 이 페이지 컨트롤러의 기본 URL을 지정한다.
public class ReviewContentController {
  @Autowired ReviewContentDao reviewContentDao;
  @Autowired TravelScheduleDao travelScheduleDao;

  TravelMain travelMain = new TravelMain();
  
  @RequestMapping(path="rvclist", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String list(int no) throws Exception {
    
    HashMap<String, Object> result = new HashMap<>();
    try{
      
      List<ReviewContent> list = reviewContentDao.selectList(no);
      
      
      
      //int reviewCount= commentDao.countAll(no);
      
      result.put("state", "success");
      result.put("data", list);
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
  
  
}
