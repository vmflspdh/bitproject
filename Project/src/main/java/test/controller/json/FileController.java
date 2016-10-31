package test.controller.json;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import test.dao.BoardFileDao;
import test.util.FileUploadUtil;
import test.vo.BoardFile;
import test.vo.JsonResult;

@Controller
@RequestMapping("/travel/")
public class FileController {

  @Autowired ServletContext sc;
  @Autowired BoardFileDao boardFiledao;

  @RequestMapping(value="upload", method = RequestMethod.POST)
  public Object upload(BoardFile boardFile, MultipartFile file) throws IOException {

    System.out.println(boardFile);
    System.out.println(file);
    try {
      String newFilename = null;
      if (!file.isEmpty()) {
        newFilename = FileUploadUtil.getNewFilename(file.getOriginalFilename());
        file.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
        System.out.println(newFilename);
        boardFile.setFileName(newFilename);
        System.out.println(boardFile);
        boardFiledao.insert(boardFile);
      }
      return JsonResult.success();
    } catch (IOException e){
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





