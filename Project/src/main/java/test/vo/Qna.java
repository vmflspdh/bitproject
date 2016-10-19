package test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;



public class Qna implements Serializable {
   private static final long serialVersionUID = 1L;
   static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

   protected int no;
   protected int comMemberNo;
   protected int qno;
   protected int qcno;
   protected String title;
   protected String writer;
   protected String contents;
   protected String commentContents;
   protected Date createDate;
   protected Date cmtCreateDate;
   protected int viewCount;
   public int getNo() {
     return no;
   }
   public void setNo(int no) {
     this.no = no;
   }
   public int getComMemberNo() {
     return comMemberNo;
   }
   public void setComMemberNo(int comMemberNo) {
     this.comMemberNo = comMemberNo;
   }
   public int getQno() {
     return qno;
   }
   public void setQno(int qno) {
     this.qno = qno;
   }
   public int getQcno() {
     return qcno;
   }
   public void setQcno(int qcno) {
     this.qcno = qcno;
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
   public String getCommentContents() {
     return commentContents;
   }
   public void setCommentContents(String commentContents) {
     this.commentContents = commentContents;
   }
   public Date getCreateDate() {
     return createDate;
   }
   public void setCreateDate(Date createDate) {
     this.createDate = createDate;
   }
   public Date getCmtCreateDate() {
     return cmtCreateDate;
   }
   public void setCmtCreateDate(Date cmtCreateDate) {
     this.cmtCreateDate = cmtCreateDate;
   }
   public int getViewCount() {
     return viewCount;
   }
   public void setViewCount(int viewCount) {
     this.viewCount = viewCount;
   }
  @Override
  public String toString() {
    return "Qna [no=" + no + ", comMemberNo=" + comMemberNo + ", qno=" + qno + ", qcno=" + qcno + ", title=" + title
        + ", writer=" + writer + ", contents=" + contents + ", commentContents=" + commentContents + ", createDate="
        + createDate + ", cmtCreateDate=" + cmtCreateDate + ", viewCount=" + viewCount + "]";
  }
   
   
   
   
   
   


  
}