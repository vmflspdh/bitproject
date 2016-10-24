package test.dao;

import java.util.List;

import test.vo.Comment;



public interface CommentDao {
  List<Comment> selectList2(int no) throws Exception;
  int insert(Comment comment) throws Exception;
  int update(Comment comment) throws Exception;
  int delete(int no) throws Exception;
  int countAll(int no) throws Exception;
}
