 package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.RegistForm;

public interface RegistFormDao {
	List<RegistForm> selectList(Map<String,Object> paramMap) throws Exception;
	List<RegistForm> afterSearchList(Map<String,Object> paramMap) throws Exception;
	List<RegistForm> autoComplecation() throws Exception;
  RegistForm selectOne(int no) throws Exception;
}
