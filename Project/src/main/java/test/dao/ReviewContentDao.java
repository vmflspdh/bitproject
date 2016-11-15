package test.dao;

import java.util.List;

import test.vo.ReviewContent;



public interface ReviewContentDao {
  List<ReviewContent> selectOne(int no) throws Exception;
  List<ReviewContent> reviewPhotoList(int no) throws Exception;
  int insert(ReviewContent reviewContent) throws Exception;
}
