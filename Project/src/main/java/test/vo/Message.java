package test.vo;

import java.io.Serializable;
import java.sql.Date;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int messageNo;
	protected int sendMemberNo;
	protected int receiveMemberNo;
	protected String receiveUser;
	protected String contents;
	protected Date sendDate;
	protected int state;
	protected String myPhoto;
	protected int travelMainNo;
	protected int schduleNo;
	
	
	public int getSchduleNo() {
		return schduleNo;
	}
	public void setSchduleNo(int schduleNo) {
		this.schduleNo = schduleNo;
	}
	public int getTravelMainNo() {
		return travelMainNo;
	}
	public void setTravelMainNo(int travelMainNo) {
		this.travelMainNo = travelMainNo;
	}
	public String getMyPhoto() {
		return myPhoto;
	}
	public void setMyPhoto(String myPhoto) {
		this.myPhoto = myPhoto;
	}
	public String getReceiveUser() {
		return receiveUser;
	}
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	public int getReceiveMemberNo() {
		return receiveMemberNo;
	}
	public void setReceiveMemberNo(int receiveMemberNo) {
		this.receiveMemberNo = receiveMemberNo;
	}
	public int getSendMemberNo() {
		return sendMemberNo;
	}
	public void setSendMemberNo(int sendMemberNo) {
		this.sendMemberNo = sendMemberNo;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
  @Override
  public String toString() {
    return "Message [messageNo=" + messageNo + ", sendMemberNo=" + sendMemberNo + ", receiveMemberNo=" + receiveMemberNo
        + ", receiveUser=" + receiveUser + ", contents=" + contents + ", sendDate=" + sendDate + ", state=" + state
        + ", myPhoto=" + myPhoto + ", travelMainNo=" + travelMainNo + ", schduleNo=" + schduleNo + "]";
  }
	
	
}
