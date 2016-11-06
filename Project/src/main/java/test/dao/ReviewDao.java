package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.Review;



public interface ReviewDao {
  List<Review> selectList(Map<String,Object> paramMap) throws Exception;
  Review selectOne(int no) throws Exception;
  List<Review> selectOneByMember(int no) throws Exception;
  int insert(Review review) throws Exception;
  int update(Review review) throws Exception;
  int viewCountUpdate(int no) throws Exception;
  int delete(int no) throws Exception;
  int countAll() throws Exception;
  List<Review> detailReviewList(int no)throws Exception;
}
