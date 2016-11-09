package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.Review;
import test.vo.ReviewContent;



public interface ReviewContentDao {
  List<ReviewContent> selectList(int no) throws Exception;
  int insert(Map<String,Object> paramMap) throws Exception;
}
