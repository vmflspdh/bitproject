package test.vo;

import java.sql.Date;

public class Schedule {

  protected int travelMainNo;
  protected int scheduleNo;
  protected Date startDate;
  protected Date endDate;
  protected int locationNo;

  
  public Schedule() {
    super();
  }
  
  public Schedule(int scheduleNo, int travelMainNo, Date startDate, Date endDate, int locationNo) {
    super();
    this.scheduleNo = scheduleNo;
    this.travelMainNo = travelMainNo;
    this.startDate = startDate;
    this.endDate = endDate;
    this.locationNo = locationNo;
  }
  
  
  public int getScheduleNo() {
    return scheduleNo;
  }

  public void setScheduleNo(int scheduleNo) {
    this.scheduleNo = scheduleNo;
  }

  public int getTravelMainNo() {
    return travelMainNo;
  }

  public void setTravelMainNo(int travelMainNo) {
    this.travelMainNo = travelMainNo;
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

  public int getLocationNo() {
    return locationNo;
  }

  public void setLocationNo(int locationNo) {
    this.locationNo = locationNo;
  }




}
