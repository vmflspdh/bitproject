package test.controller.json;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import test.dao.TravelMainFileDao;
import test.util.FileUploadUtil;
import test.vo.JsonResult;
import test.vo.TravelMainFile;

@Controller
@RequestMapping("/travel/")
public class FileController {

  @Autowired ServletContext sc;
  @Autowired TravelMainFileDao travelMainFileDao;

  @RequestMapping(value="upload", method = RequestMethod.POST)
  public Object upload(TravelMainFile boardFile, MultipartFile[] files) throws IOException {

    System.out.println(boardFile);
    for (int i = 0; i < files.length; i++) {
      System.out.println(files[i]);
      
    }

    
    try {
      String newFilename = null;
      for (int i = 0; i < files.length; i++) {
      if (!files[i].isEmpty()) {
        newFilename = FileUploadUtil.getNewFilename(files[i].getOriginalFilename());
        files[i].transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
        System.out.println(newFilename);
        boardFile.setFileName(newFilename);
        System.out.println(boardFile);
        travelMainFileDao.insert(boardFile);
      }
      }
      return JsonResult.success();
    } catch (Exception e){
      return JsonResult.fail(e.getMessage());

    }





    /* String uploadDir = sc.getRealPath("/upload") + "/";
    Iterator<String> itr =  request.getFileNames();*/
    /* Iterator : 모든 컬랙션으로부터 정보를 얻을 수 있는 인터페이스
     */
    /* MultipartFile mpf = request.getFile(itr.next());
    String originFileName = mpf.getOriginalFilename();

    System.out.println(originFileName);

    String newFilename = null;

    if (mpf != null && ! mpf.isEmpty()) {
      newFilename = FileUploadUtil.getNewFilename(originFileName);
      mpf.transferTo(new File(uploadDir + newFilename));
      BoardFile boardFile = new BoardFile();
      boardFile.setTravelMainNo(54);
      boardFile.setFileName(newFilename);*/
    /*      Member member =(Member)session.getAttribute("member");*/
    /*
      boardFiledao.insert(boardFile);
    }

    return "{\"code\":\"1\", \"msg\":\"file upload success.\",\"data\":\""+newFilename+"\"}";
  }*/
  }
}





