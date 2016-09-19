package vo;

public class Board {
  int no;
  String title;
  String contents;
  int viewCount;
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", contents=" + contents + ", viewCount=" + viewCount + "]";
  }
  
  
}





