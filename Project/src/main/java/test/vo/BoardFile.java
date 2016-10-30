package test.vo;

import java.io.Serializable;

public class BoardFile implements Serializable{
  

  private static final long serialVersionUID = 1L;
  
  protected int boardPhotoNo;
  protected int travelMainNo;
  protected String fileName;
  
  
    
  public int getTravelMainNo() {
    return travelMainNo;
  }
  public void setTravelMainNo(int travelMainNo) {
    this.travelMainNo = travelMainNo;
  }
  public String getFileName() {
    return fileName;
  }
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public int getBoardPhotoNo() {
    return boardPhotoNo;
  }
  public void setBoardPhotoNo(int boardPhotoNo) {
    this.boardPhotoNo = boardPhotoNo;
  }
  
  @Override
  public String toString() {
    return "BoardFile [boardPhotoNo=" + boardPhotoNo + ", travelMainNo=" + travelMainNo + ", fileName=" + fileName
        + "]";
  }

}

