package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.Member;

public interface MemberDao {
  
  int insert(Member member) throws Exception;
  
  List<Member> selectList(Map<String,Object> paramMap) throws Exception;
  
  Member selectOne(int no) throws Exception;
  
  Member selectOneByPassword(Map<String,Object> paramMap) throws Exception;
  
 Member selectOneByEmailAndPassword(Map<String,Object> paramMap);
 
  int update(Member member) throws Exception;
  
  int delete(int no) throws Exception;
  
  Member checkEmail(String email) throws Exception;
  
  Member regUserPhoto(int no) throws Exception;
  
}








