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
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="5") int length) throws Exception {

		try {
			HashMap<String,Object> map = new HashMap<>();
			map.put("startIndex", (pageNo - 1) * length);
			map.put("length", length);
			
			return JsonResult.success(registFormDao.selectList(map));
		
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="formDetail")
	public Object detail(int no) throws Exception {
		
		try {
			RegistForm registForm = registFormDao.selectOne(no);
			if (registForm == null)
				throw new  Exception("해당 번호의 게시물이 존재하지 않습니다.");
			
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
			System.out.println(memno);
			System.out.println(bodno);
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


