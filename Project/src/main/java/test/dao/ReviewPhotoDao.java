package test.dao;

import java.util.List;

import test.vo.ReviewPhoto;

public interface ReviewPhotoDao {
  int insert(ReviewPhoto reviewPhoto)throws Exception;
  List<ReviewPhoto> photoList(int no) throws Exception;
  int delete(int no) throws Exception;
}
