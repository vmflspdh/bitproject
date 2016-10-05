package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;



public class Qna implements Serializable {
   private static final long serialVersionUID = 1L;
   static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  protected int no;
  protected int qno;
  protected String title;
  protected String writer;
  protected String contents;
  protected Date createDate;
  protected String createdDate2;
  protected int viewCount;
  protected transient String password;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getQno() {
    return qno;
  }
  public void setQno(int qno) {
    this.qno = qno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
    this.createdDate2 = format.format(createDate);
  }
  public String getCreatedDate2() {
    return createdDate2;
  }
  public void setCreatedDate2(String str) {
    this.createDate = Date.valueOf(str);
    this.createdDate2 =str;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  

  
}