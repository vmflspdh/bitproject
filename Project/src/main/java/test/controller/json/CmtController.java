package test.controller.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import test.dao.CmtDao;
import test.dao.QnaDao;
import test.vo.Qna;

@Controller
@RequestMapping("/travel/")
public class CmtController {
   @Autowired
   QnaDao qnaDao;
   @Autowired
   CmtDao cmtDao;
   Qna qna = new Qna();

   @RequestMapping(path="cmtlist", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String list(
         @RequestParam(defaultValue="1") int pageNo,
         @RequestParam(defaultValue="10") int length,
         HttpSession session) throws Exception {

      HashMap<String,Object> result = new HashMap<>();
      try {
         HashMap<String,Object> map = new HashMap<>();
         qna = (Qna)session.getAttribute("qnabodsno");
         System.out.println(qna.getQno());
         map.put("startIndex", (pageNo - 1) * length);
         map.put("length", length);
         map.put("qnabodsno", qna.getQno());
         
         List<Qna> list = cmtDao.selectList(map);
        result.put("state", "success");
        result.put("data", list);
      
      } catch (Exception e) {
         result.put("state", "fail");
         result.put("data", e.getMessage());
      }
      return new Gson().toJson(result);
   }
   
 
   
   @RequestMapping(path="cmtdetail", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String detail(int qcno) throws Exception {
     HashMap<String,Object> result = new HashMap<>();
     
     try {
       Qna cmt = cmtDao.selectOne(qcno);
       
       if (cmt == null) 
         throw new Exception("해당 번호의 게시물이 존재하지 않습니다.");
       
       result.put("state", "success");
       result.put("data", cmt);
       
     } catch (Exception e) {
       result.put("state", "fail");
       result.put("data", e.getMessage());
     }
     
     return new Gson().toJson(result);
   }




   @RequestMapping(path="cmtadd", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String add(Qna qna) throws Exception {
     // 성공하든 실패하든 클라이언트에게 데이터를 보내야 한다.
     
     HashMap<String,Object> result = new HashMap<>();
     
     try {
       System.out.println(qna.toString());
       System.out.println(cmtDao.insert(qna));
       result.put("state", "success");
       
     } catch (Exception e) {
       result.put("state", "fail");
       result.put("data", e.getMessage());
     }
     
     return new Gson().toJson(result);
   }
   
   //----------------[  test  ]-------------------------------------
/*   @RequestMapping(path="cmtupdate", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String update(Qna qna) throws Exception {
     HashMap<String,Object> result = new HashMap<>();
     try {
       HashMap<String,Object> paramMap = new HashMap<>();
       paramMap.put("qcno", qna.getQcno());
 
       cmtDao.update(qna);
       result.put("state", "success");
       
     } catch (Exception e) {
       result.put("state", "fail");
       result.put("data", e.getMessage());
     }
     
     return new Gson().toJson(result);
   }*/
   
   @RequestMapping(path="cmtdelete", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String delete(int qno) throws Exception {
     HashMap<String,Object> result = new HashMap<>();
     try {
       HashMap<String,Object> paramMap = new HashMap<>();
       paramMap.put("qno", qno);
       
       cmtDao.delete(qno);
       result.put("state", "success");
     } catch (Exception e) {
       result.put("state", "fail");
       result.put("data", e.getMessage());
     }
     return new Gson().toJson(result);
   }
   
   
}