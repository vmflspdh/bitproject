package test.vo;

import java.io.Serializable;
import java.sql.Date;

public class RegistForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int no;
  protected String writer;
  protected String styleName;
  protected String continent;
  protected String nation;
  protected String city;
  protected String selfIntroduce;
  protected Date startDate;
  protected Date endDate;
  protected String myPhoto;
  
  
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
	public String getMyPhoto() {
		return myPhoto;
	}
	public void setMyPhoto(String myPhoto) {
		this.myPhoto = myPhoto;
	}
  
  
  
}
