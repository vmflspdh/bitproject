package test.vo;

import java.io.Serializable;

public class TravelMainFile implements Serializable{
  


  private static final long serialVersionUID = 1L;
  
  protected int travelMainPNo;
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

  public int getTravelMainPNo() {
    return travelMainPNo;
  }
  public void setTravelMainPNo(int travelMainPNo) {
    this.travelMainPNo = travelMainPNo;
  }
  

  @Override
  public String toString() {
    return "TravelMainFile [travelMainPNo=" + travelMainPNo + ", travelMainNo=" + travelMainNo + ", fileName="
        + fileName + "]";
  }
}

