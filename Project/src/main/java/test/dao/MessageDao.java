package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.Message;

public interface MessageDao {
  int insert(Message message) throws Exception;
  List<Message> selectMyMessageList(Map<String,Object> paramMap) throws Exception;
  List<Message> selectMyMemberList(Map<String,Object> paramMap) throws Exception;
  List<Message> selectUserProfile(Map<String,Object> paramMap) throws Exception;
  List<Message> selectNoPageUserProfile(Map<String,Object> paramMap) throws Exception;
}
