package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;



public class ReviewContent implements Serializable {
   private static final long serialVersionUID = 1L;
   
   protected int reviewBoardContentNo;
   protected int reviewBoardNo;
   protected int scheduleNo;
   protected String content;
   protected String reviewBoardContentPhotoName;
   protected Date startDate;
   protected Date endDate;
   protected String continent;
   protected String nation;
   protected String city;
  public int getReviewBoardContentNo() {
    return reviewBoardContentNo;
  }
  public void setReviewBoardContentNo(int reviewBoardContentNo) {
    this.reviewBoardContentNo = reviewBoardContentNo;
  }
  public int getReviewBoardNo() {
    return reviewBoardNo;
  }
  public void setReviewBoardNo(int reviewBoardNo) {
    this.reviewBoardNo = reviewBoardNo;
  }
  public int getScheduleNo() {
    return scheduleNo;
  }
  public void setScheduleNo(int scheduleNo) {
    this.scheduleNo = scheduleNo;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getReviewBoardContentPhotoName() {
    return reviewBoardContentPhotoName;
  }
  public void setReviewBoardContentPhotoName(String reviewBoardContentPhotoName) {
    this.reviewBoardContentPhotoName = reviewBoardContentPhotoName;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public String getContinent() {
    return continent;
  }
  public void setContinent(String continent) {
    this.continent = continent;
  }
  public String getNation() {
    return nation;
  }
  public void setNation(String nation) {
    this.nation = nation;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  
  @Override
  public String toString() {
    return "ReviewContent [reviewBoardContentNo=" + reviewBoardContentNo + ", reviewBoardNo=" + reviewBoardNo
        + ", scheduleNo=" + scheduleNo + ", content=" + content + ", reviewBoardContentPhotoName="
        + reviewBoardContentPhotoName + ", startDate=" + startDate + ", endDate=" + endDate + ", continent=" + continent
        + ", nation=" + nation + ", city=" + city + "]";
  }
   
     
   
   
  
   

  
}