/* 역할: 게시물 데이터를 보관 
 * 뭔가 데이터를 보관하는 역할자를 "값 객체(VO; Value Object)"라 부른다.
 * => 다른 말로 "(비즈니스) 도메인 객체(Domain Object)"라 부른다.
 * => 또 다른 말로 "데이터 전송 용으로 사용하는 객체(DTO; Data Transfer Object)"라 부른다.
 * => 용어 정리: VO == DTO == 도메인 객체 
 */
package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Review implements Serializable {
  private static final long serialVersionUID = 1L;
  static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  protected int reviewboardno;
  protected int travelno;
  protected int memberno;
  protected String membername;
  protected String title ;
  protected String content;
  protected String createdDate;
  protected int viewcount;
  protected int commentCount;
  public int getReviewboardno() {
    return reviewboardno;
  }
  public void setReviewboardno(int reviewboardno) {
    this.reviewboardno = reviewboardno;
  }
  public int getTravelno() {
    return travelno;
  }
  public void setTravelno(int travelno) {
    this.travelno = travelno;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public String getMembername() {
    return membername;
  }
  public void setMembername(String membername) {
    this.membername = membername;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }
  public int getViewcount() {
    return viewcount;
  }
  public void setViewcount(int viewcount) {
    this.viewcount = viewcount;
  }
  public int getCommentCount() {
    return commentCount;
  }
  public void setCommentCount(int commentCount) {
    this.commentCount = commentCount;
  }
  
  
  
  
  
}







