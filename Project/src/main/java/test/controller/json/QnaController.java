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

import test.dao.QnaDao;
import test.vo.Qna;

@Controller
@RequestMapping("/travel/")
public class QnaController {
   @Autowired
   QnaDao qnaDao;

   @RequestMapping(path="qnalist", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String list(
         @RequestParam(defaultValue="1") int pageNo,
         @RequestParam(defaultValue="5") int length) throws Exception {

      HashMap<String,Object> result = new HashMap<>();
      System.out.println(pageNo);
      System.out.println(length);
      try {
         HashMap<String,Object> map = new HashMap<>();
         map.put("startIndex", (pageNo - 1) * length);
         map.put("length", length);
         
         List<Qna> list = qnaDao.selectList(map);
        result.put("state", "success");
        result.put("data", list);
      
      } catch (Exception e) {
         result.put("state", "fail");
         result.put("data", e.getMessage());
      }
      return new Gson().toJson(result);
   }
   
   
   @RequestMapping(path="qnaadd", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String add(Qna qna) throws Exception {
     // 성공하든 실패하든 클라이언트에게 데이터를 보내야 한다.
     HashMap<String,Object> result = new HashMap<>();
     
     try {
       qnaDao.insert(qna);
       result.put("state", "success");
       
     } catch (Exception e) {
       result.put("state", "fail");
       result.put("data", e.getMessage());
     }
     
     return new Gson().toJson(result);
   }
   
   @RequestMapping(path="qnadetail", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String detail(int qno, HttpSession session) throws Exception {
     HashMap<String,Object> result = new HashMap<>();
     
     try {
       Qna qna = qnaDao.selectOne(qno);
       session.setAttribute("qnabodsno", qna);
       if (qna == null) 
         throw new Exception("해당 번호의 게시물이 존재하지 않습니다.");
       
       result.put("state", "success");
       result.put("data", qna);
       
     } catch (Exception e) {
       result.put("state", "fail");
       result.put("data", e.getMessage());
     }
     
     return new Gson().toJson(result);
   }
   
/*   @RequestMapping(path="qnaupdate", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String update(Qna qna) throws Exception {
     HashMap<String,Object> result = new HashMap<>();
     try {
       HashMap<String,Object> paramMap = new HashMap<>();
       paramMap.put("qno", qna.getNo());
 
       qnaDao.update(qna);
       result.put("state", "success");
       
     } catch (Exception e) {
       result.put("state", "fail");
       result.put("data", e.getMessage());
     }
     
     return new Gson().toJson(result);
   }*/
   
   @RequestMapping(path="qnadelete", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   @ResponseBody
   public String delete(int qno) throws Exception {
     HashMap<String,Object> result = new HashMap<>();
     try {
       HashMap<String,Object> paramMap = new HashMap<>();
       paramMap.put("qno", qno);
       
       qnaDao.delete(qno);
       result.put("state", "success");
     } catch (Exception e) {
       result.put("state", "fail");
       result.put("data", e.getMessage());
     }
     return new Gson().toJson(result);
   }
   
 
}