package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Member implements Serializable{


  private static final long serialVersionUID = 1L;
  
  protected int no;
  protected String name;
  protected String email;
  protected String password;
  protected Date birthday;
  protected int gender;
  protected Timestamp registedDate;
  protected String memberPhoto;
  protected int memberRequest;
  


  

  public int getMemberRequest() {
    return memberRequest;
  }


  public void setMemberRequest(int memberRequest) {
    this.memberRequest = memberRequest;
  }


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




  public Timestamp getRegistedDate() {
    return registedDate;
  }




  public void setRegistedDate(Timestamp registedDate) {
    this.registedDate = registedDate;
  }




  public String getMemberPhoto() {
    return memberPhoto;
  }




  public void setMemberPhoto(String memberPhoto) {
    this.memberPhoto = memberPhoto;
  }



  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", birthday="
        + birthday + ", gender=" + gender + ", registedDate=" + registedDate + ", memberPhoto=" + memberPhoto + "]";
  }

}
