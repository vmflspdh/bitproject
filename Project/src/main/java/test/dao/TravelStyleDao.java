package test.dao;

import test.vo.TravelMain;

public interface TravelStyleDao {
  int insert(TravelMain travelMain) throws Exception;
  int update(TravelMain travelMain) throws Exception;
  int delete(int no) throws Exception;
}








