package test.dao;

import java.util.List;

import test.vo.Invite;



public interface InviteDao {
  int insert(Invite invite) throws Exception;
  int inviteCount(int no)throws Exception;
  List<Invite> inviteList(int no) throws Exception;
}
