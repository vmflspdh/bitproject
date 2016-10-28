package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.Calendar;

public interface CalendarDao {
	List<Calendar> selectMyCalendar(Map<String,Object> paramMap) throws Exception;
}
