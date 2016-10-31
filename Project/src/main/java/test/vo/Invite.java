/* 역할: 게시물 데이터를 보관 
 * 뭔가 데이터를 보관하는 역할자를 "값 객체(VO; Value Object)"라 부른다.
 * => 다른 말로 "(비즈니스) 도메인 객체(Domain Object)"라 부른다.
 * => 또 다른 말로 "데이터 전송 용으로 사용하는 객체(DTO; Data Transfer Object)"라 부른다.
 * => 용어 정리: VO == DTO == 도메인 객체 
 */
package test.vo;

import java.io.Serializable;

public class Invite implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int inviteNo;
  protected int memberNo;
  protected int memberNo2;
  protected String inviteName;
  protected String inviteEmail;
  protected int inviteGender;
  protected int state;
  protected String invitePhoto;
  protected int inviteBoardNo;
  
  public int getInviteBoardNo() {
    return inviteBoardNo;
  }
  public void setInviteBoardNo(int inviteBoardNo) {
    this.inviteBoardNo = inviteBoardNo;
  }
  public int getInviteNo() {
    return inviteNo;
  }
  public void setInviteNo(int inviteNo) {
    this.inviteNo = inviteNo;
  }
  public int getMemberNo() {
    return memberNo;
  }
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  public int getMemberNo2() {
    return memberNo2;
  }
  public void setMemberNo2(int memberNo2) {
    this.memberNo2 = memberNo2;
  }
  public String getInviteName() {
    return inviteName;
  }
  public void setInviteName(String inviteName) {
    this.inviteName = inviteName;
  }
  public String getInviteEmail() {
    return inviteEmail;
  }
  public void setInviteEmail(String inviteEmail) {
    this.inviteEmail = inviteEmail;
  }
  public int getInviteGender() {
    return inviteGender;
  }
  public void setInviteGender(int inviteGender) {
    this.inviteGender = inviteGender;
  }
  public int getState() {
    return state;
  }
  public void setState(int state) {
    this.state = state;
  }
  public String getInvitePhoto() {
    return invitePhoto;
  }
  public void setInvitePhoto(String invitePhoto) {
    this.invitePhoto = invitePhoto;
  }
  
  @Override
  public String toString() {
    return "Invite [inviteNo=" + inviteNo + ", memberNo=" + memberNo + ", memberNo2=" + memberNo2 + ", inviteName="
        + inviteName + ", inviteEmail=" + inviteEmail + ", inviteGender=" + inviteGender + ", state=" + state
        + ", invitePhoto=" + invitePhoto + ", inviteBoardNo=" + inviteBoardNo + "]";
  }
  
  
  
  
  
  
  
}
