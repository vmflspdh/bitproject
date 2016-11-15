package test.vo;

import java.io.Serializable;
import java.sql.Date;

public class Calendar implements Serializable {
 

  private static final long serialVersionUID = 1L;

  protected String title;
  protected Date start;
  protected Date end;
  
  
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Date getStart() {
    return start;
  }
  public void setStart(Date start) {
    this.start = start;
  }
  public Date getEnd() {
    return end;
  }
  public void setEnd(Date end) {
    this.end = end;
  }

  
}
