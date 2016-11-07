package test.vo;

import java.io.Serializable;

public class Bookmark implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int travelMainNo;
  protected int memberNo;
  protected String memberPhoto;
  protected String memberName;
  protected int bookmarkCount;
  
  
  
	public int getBookmarkCount() {
		return bookmarkCount;
	}
	public void setBookmarkCount(int bookmarkCount) {
		this.bookmarkCount = bookmarkCount;
	}
	public String getMemberPhoto() {
		return memberPhoto;
	}
	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
  
  
}
