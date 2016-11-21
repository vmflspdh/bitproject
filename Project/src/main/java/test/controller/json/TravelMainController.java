package test.controller.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import test.dao.CalendarDao;
import test.dao.MemberDao;
import test.dao.ReviewDao;
import test.dao.TravelLocationDao;
import test.dao.TravelMainDao;
import test.dao.TravelMainFileDao;
import test.dao.TravelMyStyleDao;
import test.dao.TravelScheduleDao;
import test.util.FileUploadUtil;
import test.vo.JsonResult;
import test.vo.Member;
import test.vo.Review;
import test.vo.TravelMain;
import test.vo.TravelMainFile;


@Controller
@RequestMapping("/travel/")
public class TravelMainController {
  @Autowired MemberDao memberDao;
  @Autowired TravelMainDao travelMainDao;
  @Autowired TravelLocationDao travelLocationDao;
  @Autowired TravelMyStyleDao travelMystyleDao;
  @Autowired TravelScheduleDao travelScheduleDao;
  @Autowired CalendarDao calendarDao;
  @Autowired ReviewDao reviewDao;
  @Autowired ServletContext sc;
  @Autowired TravelMainFileDao travelMainFileDao;
  TravelMain travelMain = new TravelMain();
  TravelMainFile travelMainfile = new TravelMainFile();

  
  @RequestMapping(path="scheduleList")
  public Object list(HttpSession session) throws Exception {
    
    try {
      HashMap<String,Object> map = new HashMap<>();
      
      travelMain.setTravelMainNo((Integer)session.getAttribute("travelPostNo"));
      map.put("travelPostNo", travelMain.getTravelMainNo());
      System.out.println(travelMain.getTravelMainNo());
      
      List<TravelMain> list = travelScheduleDao.selectMySchedule(map);
      
      for(int i=0;i<list.size();i++){
        list.get(i).getScheduleNo();
        
      }
      session.setAttribute("schNo", list);
      return JsonResult.success(travelScheduleDao.selectMySchedule(map));
    
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  @RequestMapping(path="tvlReviewList")
  public Object tvlreviewlist(int no,HttpSession session) throws Exception {
    System.out.println(no);
 
    try {
      List<Review> list = reviewDao.detailReviewList(no);
      return JsonResult.success(list);
    
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  
  @RequestMapping(path="travelMainFilelist")
  public Object travelMainFilelist(HttpSession session) throws Exception {

    try {
      HashMap<String,Object> map = new HashMap<>();
      travelMain.setTravelMainNo((Integer)session.getAttribute("travelPostNo"));
      map.put("travelPostNo", travelMain.getTravelMainNo());
      System.out.println(travelMain.getTravelMainNo());
      
      return JsonResult.success(travelMainFileDao.selectList(map));
    
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  @RequestMapping(path="calendarList")
  public Object calendarlist(HttpSession session) throws Exception {

    try {
      HashMap<String,Object> map = new HashMap<>();
      travelMain.setTravelMainNo((Integer)session.getAttribute("travelPostNo"));
      map.put("travelPostNo", travelMain.getTravelMainNo());
      System.out.println(travelMain.getTravelMainNo());
      
      return JsonResult.success(calendarDao.selectMyCalendar(map));
    
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  @RequestMapping(path="travelMainAdd")
  public Object add(TravelMain travelMain, String schedule, HttpSession session, MultipartFile file) throws Exception {
    
    Member member = (Member)session.getAttribute("member");
    travelMain.setMemberNo(member.getNo());
    
    System.out.println(travelMain);

    List<TravelMain> list = new Gson().fromJson(schedule, new TypeToken<List<TravelMain>>(){}.getType());
    
    int index = list.size();
    System.out.println(index);

    
    try {
     travelMainDao.insert(travelMain);
      System.out.println(travelMain);
      
      travelMystyleDao.insert(travelMain);
      System.out.println(travelMain);
      
      String newFilename = null;
     
        if (!file.isEmpty()) {
        newFilename = FileUploadUtil.getNewFilename(file.getOriginalFilename());
        file.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
        System.out.println(newFilename);
        travelMainfile.setTravelMainNo(travelMain.getTravelMainNo());
        travelMainfile.setFileName(newFilename);
        System.out.println(travelMainfile);
        travelMainFileDao.insert(travelMainfile);
      } else {
        travelMainfile.setTravelMainNo(travelMain.getTravelMainNo());
        travelMainfile.setFileName("default");
        travelMainFileDao.insert(travelMainfile);
      }
      

      
      for (int i = 0; i < list.size(); i++) {
        
        travelMain.setContinent(list.get(i).getContinent());
        travelMain.setNation(list.get(i).getNation());
        travelMain.setCity(list.get(i).getCity());
        travelMain.setLat((double)list.get(i).getLat());
        travelMain.setLng((double)list.get(i).getLng());
        
        System.out.println(travelMain);
        
        travelLocationDao.insert(travelMain);
        
        travelMain.setStartDate(list.get(i).getStartDate1());
        travelMain.setEndDate(list.get(i).getEndDate1());
        
        System.out.println(travelMain);
        
        travelScheduleDao.insert(travelMain);
      }
      return JsonResult.success();
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }



  @RequestMapping(path="travelMainUpdate")
  public Object update(TravelMain travelMain, String schedule, MultipartFile file) throws Exception {
    
    List<TravelMain> list = new Gson().fromJson(schedule, new TypeToken<List<TravelMain>>(){}.getType());
    int index = list.size();
    System.out.println(index);
    System.out.println(list);
    
    try {
      
      travelMainDao.update(travelMain);
      System.out.println(travelMain);
      
      travelMystyleDao.update(travelMain);
      System.out.println(travelMain);
      
      for (int i = 0; i < list.size(); i++) {
        
      travelMain.setLocationNo(list.get(i).getLocationNo());
      travelMain.setContinent(list.get(i).getContinent());
      travelMain.setNation(list.get(i).getNation());
      travelMain.setCity(list.get(i).getCity());
      travelMain.setLat(list.get(i).getLat());
      travelMain.setLng(list.get(i).getLng());
      System.out.println(travelMain);
      travelLocationDao.update(travelMain);
      
      travelMain.setScheduleNo(list.get(i).getScheduleNo());
      travelMain.setStartDate(list.get(i).getStartDate1());
      travelMain.setEndDate(list.get(i).getEndDate1());
      System.out.println(travelMain);
      travelScheduleDao.update(travelMain);

      }
            
      System.out.println(file);
              
      String newFilename = null;
      if (file != null) {
        if (!file.isEmpty()) {
          newFilename = FileUploadUtil.getNewFilename(file.getOriginalFilename());
          file.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
          travelMainfile.setTravelMainNo(travelMain.getTravelMainNo());
          travelMainfile.setTravelMainPNo(travelMain.getTravelMainPNo());
          travelMainfile.setFileName(newFilename);
          System.out.println(newFilename);
          System.out.println(travelMainfile);
          travelMainFileDao.update(travelMainfile);
        }
        } else {
          System.out.println("수정할 파일이 없습니다.");
        }
      
      
      return JsonResult.success();
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }

  @RequestMapping(path="travelMainDelete")
  public Object delete(int no) throws Exception {
    System.out.println(no);
    try {
      travelMainDao.delete(no);
      return JsonResult.success();
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }

}
