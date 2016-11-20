package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.TravelMainFile;

public interface TravelMainFileDao {
  int insert(TravelMainFile travelMainFile);
  List<TravelMainFile> selectList(Map<String,Object> paramMap) throws Exception;
  int delete(int no) throws Exception;
  int update(TravelMainFile travelMainFile) throws Exception;
}
