package test.dao;

import java.util.List;

import test.vo.Invite;



public interface InviteDao {
  int insert(Invite invite) throws Exception;
  int inviteAgreeInsert(Invite invite) throws Exception;
  int inviteCheck(Invite invite) throws Exception;
  int inviteCount(int no)throws Exception;
  List<Invite> inviteList(int no) throws Exception;
  int inviteAgree(int no)throws Exception;
  int inviteRefuse(int no)throws Exception;
  List<Invite> inviteAgreeList(int no) throws Exception;
  
}
