package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Member implements Serializable{
  


  private static final long serialVersionUID = 1L;
  static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  
  protected int no;
  protected String name;
  protected String email;
  protected String password;
  protected Date birthday;
  protected int gender;
  protected Date registedDate;
  protected String memberPhoto;
  protected int memberRequest;
  
  protected String registedDate1;

  



  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public Date getRegistedDate() {
    return registedDate;
  }

  public void setRegistedDate(Date registedDate) {
    this.registedDate = registedDate;
    this.registedDate1 = format.format(registedDate);
  }

  public String getMemberPhoto() {
    return memberPhoto;
  }

  public void setMemberPhoto(String memberPhoto) {
    this.memberPhoto = memberPhoto;
  }

  public int getMemberRequest() {
    return memberRequest;
  }

  public void setMemberRequest(int memberRequest) {
    this.memberRequest = memberRequest;
  }

  public String getRegistedDate1() {
    return registedDate1;
  }

  public void setRegistedDate(String str) {
    this.registedDate = Date.valueOf(str);
    this.registedDate1 = str;
  }

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", birthday="
        + birthday + ", gender=" + gender + ", registedDate=" + registedDate + ", memberPhoto=" + memberPhoto
        + ", memberRequest=" + memberRequest + ", registedDate1=" + registedDate1 + "]";
  }


}
