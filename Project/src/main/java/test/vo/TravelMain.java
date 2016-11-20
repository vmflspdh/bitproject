package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class TravelMain implements Serializable {



  private static final long serialVersionUID = 1L;

  static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  protected int travelMainNo;
  protected int memberNo;
  protected String title;
  protected String selfIntroduce;
  protected int scheduleNo;
  protected int locationNo;
  protected Date startDate;
  protected Date endDate;
  protected String continent;
  protected String nation;
  protected String city;
  protected double lat;
  protected double lng;
  protected int styleNo;
  protected String styleName;
  protected int travelMainPNo;


  protected String startDate1;
  protected String endDate1;


  public int getTravelMainNo() {
    return travelMainNo;
  }

  public void setTravelMainNo(int travelMainNo) {
    this.travelMainNo = travelMainNo;
  }

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSelfIntroduce() {
    return selfIntroduce;
  }

  public void setSelfIntroduce(String selfIntroduce) {
    this.selfIntroduce = selfIntroduce;
  }

  public int getScheduleNo() {
    return scheduleNo;
  }

  public void setScheduleNo(int scheduleNo) {
    this.scheduleNo = scheduleNo;
  }


  public int getLocationNo() {
    return locationNo;
  }

  public void setLocationNo(int locationNo) {
    this.locationNo = locationNo;
  }

  public String getStartDate1() {
    return startDate1;
  }


  public Date getStartDate() {
    return startDate;
  }



  public void setStartDate(Date startDate) {
    this.startDate = startDate;
    this.startDate1 = format.format(startDate);
  }

  public void setStartDate(String str) {
    this.startDate = Date.valueOf(str);
    this.startDate1 = str;
  }




  public Date getEndDate() {
    return endDate;
  }


  public String getEndDate1() {
    return endDate1;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
    this.endDate1 = format.format(endDate);
  }

  public void setEndDate(String str) {
    this.endDate = Date.valueOf(str);
    this.endDate1 = str;
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



  public int getStyleNo() {
    return styleNo;
  }



  public void setStyleNo(int styleNo) {
    this.styleNo = styleNo;
  }



  public String getStyleName() {
    return styleName;
  }



  public void setStyleName(String styleName) {
    this.styleName = styleName;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLng() {
    return lng;
  }

  public void setLng(double lng) {
    this.lng = lng;
  }







  public int getTravelMainPNo() {
    return travelMainPNo;
  }

  public void setTravelMainPNo(int travelMainPNo) {
    this.travelMainPNo = travelMainPNo;
  }








  @Override
  public String toString() {
    return "TravelMain [travelMainNo=" + travelMainNo + ", memberNo=" + memberNo + ", title=" + title
        + ", selfIntroduce=" + selfIntroduce + ", scheduleNo=" + scheduleNo + ", locationNo=" + locationNo
        + ", startDate=" + startDate + ", endDate=" + endDate + ", continent=" + continent + ", nation=" + nation
        + ", city=" + city + ", lat=" + lat + ", lng=" + lng + ", styleNo=" + styleNo + ", styleName=" + styleName
        + ", travelMainPNo=" + travelMainPNo + ", startDate1=" + startDate1 + ", endDate1=" + endDate1 + "]";
  }







}
