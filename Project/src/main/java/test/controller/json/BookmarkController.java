package test.controller.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.dao.BookmarkDao;
import test.vo.Bookmark;
import test.vo.JsonResult;
import test.vo.Member;


@Controller
@RequestMapping("/travel/")
public class BookmarkController {
  @Autowired BookmarkDao bookmarkDao;

	@RequestMapping(path="bookmarkList")
	public Object list(HttpSession session) throws Exception {
		
		try {
			HashMap<String,Object> map = new HashMap<>();
			Member member = (Member)session.getAttribute("member");
			int sendMemberNo = member.getNo();
			map.put("bookmarkMemberNo", sendMemberNo);
		  return JsonResult.success(bookmarkDao.viewMyBookmarkList(map));
		  
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="bookmarkCount")
	public Object countList(HttpSession session) throws Exception {
		
		try {
			HashMap<String,Object> map = new HashMap<>();
			int travelMainNo = (int)session.getAttribute("travelPostNo");
			map.put("bookmarkCount", travelMainNo);
		  return JsonResult.success(bookmarkDao.bookmarkCount(map));
		  
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="bookmarkAdd")
  public Object add(HttpSession session) throws Exception {
    
		Bookmark bookmark = new Bookmark();
    Member member = (Member)session.getAttribute("member");
    bookmark.setMemberNo(member.getNo());
    int travelMainNo = (int)session.getAttribute("travelPostNo");
    System.out.println(travelMainNo);
    bookmark.setTravelMainNo(travelMainNo);
    
    try {
    	bookmarkDao.insert(bookmark);
     return JsonResult.success();
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
	
  @RequestMapping(path="bookmarkDelete")
  public Object delete(int no, HttpSession session) throws Exception {

  	Bookmark bookmark = new Bookmark();
  	Member member = (Member)session.getAttribute("member");
  	bookmark.setMemberNo(member.getNo());
  	bookmark.setTravelMainNo(no);
    try {
    	
      bookmarkDao.delete(bookmark);
      return JsonResult.success();

    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
}
