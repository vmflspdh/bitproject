package test.vo;

import java.io.Serializable;

public class ReviewPhoto implements Serializable{
  


  private static final long serialVersionUID = 1L;
  
  protected int reviewPhotoNo;
  protected int reviewBoardNo;
  protected String reviewPhotoName;
  public int getReviewPhotoNo() {
    return reviewPhotoNo;
  }
  public void setReviewPhotoNo(int reviewPhotoNo) {
    this.reviewPhotoNo = reviewPhotoNo;
  }
  public int getReviewBoardNo() {
    return reviewBoardNo;
  }
  public void setReviewBoardNo(int reviewBoardNo) {
    this.reviewBoardNo = reviewBoardNo;
  }
  public String getReviewPhotoName() {
    return reviewPhotoName;
  }
  public void setReviewPhotoName(String reviewPhotoName) {
    this.reviewPhotoName = reviewPhotoName;
  }
  @Override
  public String toString() {
    return "ReviewPhoto [reviewPhotoNo=" + reviewPhotoNo + ", reviewBoardNo=" + reviewBoardNo + ", reviewPhotoName="
        + reviewPhotoName + "]";
  }
  
  
  
  
}

