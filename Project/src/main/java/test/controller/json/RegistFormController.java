package test.controller.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.dao.RegistFormDao;
import test.vo.JsonResult;
import test.vo.Member;
import test.vo.RegistForm;


@Controller
@RequestMapping("/travel/")
public class RegistFormController {
	@Autowired RegistFormDao registFormDao;
  Member member = new Member();
	
	@RequestMapping(path="formList")
	public Object list(
			@RequestParam(defaultValue="12") int listlength) throws Exception {

		try {
			HashMap<String,Object> map = new HashMap<>();
			map.put("length", listlength);
			
			return JsonResult.success(registFormDao.selectList(map));
			
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="autoComplecation")
	public Object list2() throws Exception {

		try {
			return JsonResult.success(registFormDao.autoComplecation());
			
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="mainSearchList")
	public Object searchList(RegistForm registForm) throws Exception {
		System.out.println(registForm);
		try {
		  HashMap<String,Object> map = new HashMap<>();
		  if (registForm.getCity() != null)
		  map.put("searchCity", registForm.getCity());
		  if (registForm.getStartDate1() != null)
		  map.put("searchSartDate", registForm.getStartDate1());
		  if (registForm.getEndDate1() != null)
		  map.put("searchEndDate", registForm.getEndDate1());
		  return JsonResult.success(registFormDao.afterSearchList(map));
			
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="formDetail")
	public Object detail(int no, HttpSession session) throws Exception {
		
		try {
			RegistForm registForm = registFormDao.selectOne(no);
			session.setAttribute("registform", registForm);
			if (registForm == null)
				throw new  Exception("해당 번호의 게시물이 존재하지 않습니다.");
			session.setAttribute("travelPostNo", registForm.getTravelMainNo());
			
			return JsonResult.success(registForm);
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="formMyList")
	public Object selectMyList(int no, HttpSession session) throws Exception {
		
		try {
			member = (Member)session.getAttribute("member");
			int memno = member.getNo();
			RegistForm registForm = registFormDao.selectOne(no);
			int bodno = registForm.getMemberNo();
			session.setAttribute("travelMemberNo", registForm.getMemberNo());
			if (memno == bodno) {
				return JsonResult.success();
			} else {
				return JsonResult.fail();
			}
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
}
