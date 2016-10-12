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
	@Autowired TravelMainDao travelMainDao;
	@Autowired TravelLocationDao travelLocationDao;
	@Autowired TravelMyStyleDao travelMystyleDao;
	@Autowired TravelScheduleDao travelScheduleDao;

	@RequestMapping(path="travelMainAdd")
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
	
	
	@RequestMapping(path="travelMainUpdate")
	public Object update(TravelMain travelMain) throws Exception {
		try {
			//HashMap<String,Object> paramMap = new HashMap<>();
			//paramMap.put("no", travelMain.getScheduleNo());
			travelMainDao.update(travelMain);
			travelMystyleDao.update(travelMain);
			travelLocationDao.update(travelMain);
			travelScheduleDao.update(travelMain);
			return JsonResult.success();
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="travelMainDelete")
	public Object delete(TravelMain travelMain) throws Exception {
		
		try {
			travelMystyleDao.delete(travelMain);
			travelScheduleDao.delete(travelMain);
			travelLocationDao.delete(travelMain);
			travelMainDao.delete(travelMain);
		  return JsonResult.success();
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
		
}
