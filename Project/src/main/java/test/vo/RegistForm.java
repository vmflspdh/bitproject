package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class RegistForm implements Serializable {

  private static final long serialVersionUID = 1L;
	
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	protected int no;
	protected int memberNo;
	protected int travelMainNo;
	protected int locationNo;
	protected int styleNo;
  protected String writer;
  protected String title;
  protected String styleName;
  protected String continent;
  protected String nation;
  protected String city;
  protected String selfIntroduce;
  protected Date startDate;
  protected Date endDate;
  protected String myPhoto;
  protected int travelMainPNo;
  protected String travelPhoto;
  protected int bookmarkCount;
  protected String startDate1;
  protected String endDate1;
  
  
  
  public int getTravelMainPNo() {
    return travelMainPNo;
  }
  public void setTravelMainPNo(int travelMainPNo) {
    this.travelMainPNo = travelMainPNo;
  }
  
	public int getBookmarkCount() {
		return bookmarkCount;
	}
	public void setBookmarkCount(int bookmarkCount) {
		this.bookmarkCount = bookmarkCount;
	}
	public String getTravelPhoto() {
		return travelPhoto;
	}
	public void setTravelPhoto(String travelPhoto) {
		this.travelPhoto = travelPhoto;
	}
	public int getStyleNo() {
		return styleNo;
	}
	public void setStyleNo(int styleNo) {
		this.styleNo = styleNo;
	}
	public int getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(int locationNo) {
		this.locationNo = locationNo;
	}
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
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
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
	public String getSelfIntroduce() {
		return selfIntroduce;
	}
	public void setSelfIntroduce(String selfIntroduce) {
		this.selfIntroduce = selfIntroduce;
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
	public String getMyPhoto() {
		return myPhoto;
	}
	public void setMyPhoto(String myPhoto) {
		this.myPhoto = myPhoto;
	}
	@Override
	public String toString() {
		return "RegistForm [no=" + no + ", memberNo=" + memberNo + ", travelMainNo=" + travelMainNo + ", locationNo="
				+ locationNo + ", styleNo=" + styleNo + ", writer=" + writer + ", title=" + title + ", styleName=" + styleName
				+ ", continent=" + continent + ", nation=" + nation + ", city=" + city + ", selfIntroduce=" + selfIntroduce
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", myPhoto=" + myPhoto + ", travelPhoto=" + travelPhoto
				+ ", bookmarkCount=" + bookmarkCount + ", startDate1=" + startDate1 + ", endDate1=" + endDate1 + "]";
	}

 
	
	
  
  
  
}