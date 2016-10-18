package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.TravelMain;

public interface TravelScheduleDao {
  List<TravelMain> selectMySchedule(Map<String,Object> paramMap) throws Exception;
	int insert(TravelMain travelMain) throws Exception;
  int update(TravelMain travelMain) throws Exception;
  int delete(TravelMain travelMain) throws Exception;
}








