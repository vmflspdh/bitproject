package test.controller.json;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import test.dao.RegistFormDao;
import test.vo.RegistForm;

@Controller
@RequestMapping("/travel/")
public class RegistFormController {
	@Autowired
	RegistFormDao registFormDao;

	@RequestMapping(path="formList", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="5") int length) throws Exception {

		HashMap<String,Object> result = new HashMap<>();
		try {
			HashMap<String,Object> map = new HashMap<>();
			map.put("startIndex", (pageNo - 1) * length);
			map.put("length", length);
			
			List<RegistForm> list = registFormDao.selectList(map);
		  result.put("state", "success");
		  result.put("data", list);
		
		} catch (Exception e) {
			result.put("state", "fail");
			result.put("data", e.getMessage());
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping(path="detail", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String detail(int no) throws Exception {
    HashMap<String,Object> result = new HashMap<>();
		
		try {
			RegistForm registForm = registFormDao.selectOne(no);
			
			if (registForm == null)
				throw new  Exception("해당 번호의 게시물이 존재하지 않습니다.");
		  
			result.put("state", "success");
		  result.put("data", registForm);
		} catch (Exception e) {
			result.put("state", "fail");
			result.put("data", e.getMessage());
		}
		return new Gson().toJson(result);
	}
}
