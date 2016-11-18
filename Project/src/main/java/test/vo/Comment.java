/* 역할: 게시물 데이터를 보관 
 * 뭔가 데이터를 보관하는 역할자를 "값 객체(VO; Value Object)"라 부른다.
 * => 다른 말로 "(비즈니스) 도메인 객체(Domain Object)"라 부른다.
 * => 또 다른 말로 "데이터 전송 용으로 사용하는 객체(DTO; Data Transfer Object)"라 부른다.
 * => 용어 정리: VO == DTO == 도메인 객체 
 */
package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class Comment implements Serializable {

  private static final long serialVersionUID = 1L;
  static SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm");
  static ParsePosition pos = new ParsePosition(0);


  protected int reviewcommentNo;
  protected int reviewboardNo;
  protected int memberNo;
  protected String memberName;
  protected String cmMemberPhoto;
    protected String content;
  protected Date createdDate;
  protected String createdDate2;
 
  

  public int getReviewcommentNo() {
    return reviewcommentNo;
  }
  public void setReviewcommentNo(int reviewcommentNo) {
    this.reviewcommentNo = reviewcommentNo;
  }
  public int getReviewboardNo() {
    return reviewboardNo;
  }
  public void setReviewboardNo(int reviewboardNo) {
    this.reviewboardNo = reviewboardNo;
  }
  public int getMemberNo() {
    return memberNo;
  }
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  public String getMemberName() {
    return memberName;
  }
  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public String getCreatedDate2() {
    return createdDate2;
  }
  public void setCreatedDate2(String createdDate2) {
    this.createdDate2 = createdDate2;
  }
  

  public String getCmMemberPhoto() {
    return cmMemberPhoto;
  }
  public void setCmMemberPhoto(String cmMemberPhoto) {
    this.cmMemberPhoto = cmMemberPhoto;
  }
  
  
}
