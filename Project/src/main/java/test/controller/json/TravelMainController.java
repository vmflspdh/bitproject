package test.controller.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.dao.MemberDao;
import test.dao.TravelLocationDao;
import test.dao.TravelMainDao;
import test.dao.TravelMyStyleDao;
import test.dao.TravelScheduleDao;
import test.dao.TravelStyleDao;
import test.vo.JsonResult;
import test.vo.TravelMain;


@Controller
@RequestMapping("/travel/")
public class TravelMainController {
	@Autowired MemberDao memberDao;
	@Autowired TravelMainDao travelMainDao;
	@Autowired TravelLocationDao travelLocationDao;
	@Autowired TravelMyStyleDao travelMystyleDao;
	@Autowired TravelScheduleDao travelScheduleDao;
	@Autowired TravelStyleDao travelStyleDao;

	@RequestMapping(path="formAdd")
	public Object add(TravelMain travelMain) throws Exception {
		
		try {
			travelMainDao.insert(travelMain);
			travelMystyleDao.insert(travelMain);
			travelLocationDao.insert(travelMain);
			travelScheduleDao.insert(travelMain);
		  return JsonResult.success();
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	
	@RequestMapping(path="formUpdate")
	public Object update(TravelMain travelMain) throws Exception {
		try {
			HashMap<String,Object> paramMap = new HashMap<>();
			paramMap.put("no", travelMain.getScheduleNo());
			travelMainDao.update(travelMain);
			travelMystyleDao.update(travelMain);
			travelLocationDao.update(travelMain);
			travelScheduleDao.update(travelMain);
			return JsonResult.success();
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	/*
	@RequestMapping(path="delete")
	public Object delete(int no, String password) throws Exception {
		
		try {
			HashMap<String,Object> paramMap = new HashMap<>();
			paramMap.put("no", no);
			paramMap.put("password", password);

			if (boardDao.selectOneByPassword(paramMap) == null) {
				throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다!");
			} 
			boardDao.delete(no);
		  return JsonResult.success();
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	*/
		
}
