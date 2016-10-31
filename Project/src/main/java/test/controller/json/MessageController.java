package test.controller.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.dao.MessageDao;
import test.vo.JsonResult;
import test.vo.Member;
import test.vo.Message;


@Controller
@RequestMapping("/travel/")
public class MessageController {
  @Autowired MessageDao messageDao;

  /*@RequestMapping(path="messageMemberList")
  public Object list(HttpSession session) throws Exception {

    try {
      HashMap<String,Object> map = new HashMap<>();
      Member member = (Member)session.getAttribute("member");
      System.out.println(member.getNo());
      //map.put("receiveNo", member.getNo());
      
      List<Message> messageList = messageDao.selectMyMemberList(member.getNo());
      List<Message> sortingList = new ArrayList<>();
      Message message;
      
      for (int i = 0; i < messageList.size(); i++) {
      	System.out.println("이것: " + messageList.get(i));
      }
      for (int i = 0; i < messageList.size(); i++) {
      	for (int j = 0; j < i; j++) {
      		if (messageList.get(j).getSendMemberNo() == messageList.get(i).getSendMemberNo()) {
      			
      			if (messageList.get(j).getMessageNo() < messageList.get(i).getMessageNo()) {
      				System.out.println(sortingList.get(i));
      				int indexNo = sortingList.indexOf(messageList.get(j).getMessageNo());
      				
      				sortingList.remove(indexNo);
      				message = messageList.get(i);
      				sortingList.add(message);
      			} else {
      				break;
      			}
      		} else {
      			break;
      		}
      	}
      	message = messageList.get(i);
				sortingList.add(message);
      }
      for (int i=0; i < sortingList.size(); i++) {
      	System.out.println("sortingList[" + i + "] = " + sortingList.get(i));
      }
      
      return JsonResult.success(sortingList);
    
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }*/
  
  @RequestMapping(path="messageMemberList")
  public Object list(HttpSession session) throws Exception {

    try {
      HashMap<String,Object> map = new HashMap<>();
      Member member = (Member)session.getAttribute("member");
      System.out.println(member.getNo());
      map.put("receiveNo", member.getNo());
      
      return JsonResult.success(messageDao.selectMyMemberList(map));
    
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
	@RequestMapping(path="myMessageList")
	public Object list(int no, HttpSession session) throws Exception {
		
		try {
			HashMap<String,Object> map = new HashMap<>();
			Member member = (Member)session.getAttribute("member");
			int sendMemberNo = member.getNo();
			int receiveMemberNo = no;
			session.setAttribute("receiveMemberNo", receiveMemberNo);
			System.out.println(sendMemberNo);
			System.out.println(receiveMemberNo);
			map.put("receiveNo", no);
			map.put("sendNo", sendMemberNo);
		  return JsonResult.success(messageDao.selectMyMessageList(map));
		  
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@RequestMapping(path="messageAdd")
  public Object add(Message message, HttpSession session) throws Exception {
    
    Member member = (Member)session.getAttribute("member");
    message.setSendMemberNo(member.getNo());
    int receiveMemberNo = (int)session.getAttribute("receiveMemberNo");
    message.setReceiveMemberNo(receiveMemberNo);
    
    try {
    	messageDao.insert(message);
     return JsonResult.success();
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
}
