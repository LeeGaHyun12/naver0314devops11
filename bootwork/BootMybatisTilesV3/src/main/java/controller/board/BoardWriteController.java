package controller.board;

import data.dto.MemberDto;
import data.dto.ReBoardDto;
import data.service.MemberService;

import naver.cloud.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.service.ReBoardService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.UUID;

@Controller
@RequestMapping("/board")
public class BoardWriteController {
    @Autowired
    private ReBoardService boardService;

    @Autowired
    private MemberService memberService;
    private String bucketName="bitcamp-bucket-56";
    private String folderName="photocommon";

    @Autowired
    private NcpObjectStorageService storageService;

    @GetMapping("/form")
    public String form(
            //새글일경우 null 값들이 넘어오므로 초기값을 지정한다
            //답글일경우는 원글이 갖고있는 각종 정보가 넘어온다
            @RequestParam(defaultValue = "0") int num,
            @RequestParam(defaultValue = "0") int regroup,
            @RequestParam(defaultValue = "0") int restep,
            @RequestParam(defaultValue = "0") int relevel,
            @RequestParam(defaultValue = "1") int currentPage,
            Model model
            ){
        //답글일경우 제목을 얻어서 model에 저장한다
        String subject="";
        if(num>0){
            subject="[답글]"+boardService.getData(num).getSubject();
        }
        model.addAttribute("num",num);
        model.addAttribute("regroup",regroup);
        model.addAttribute("restep",restep);
        model.addAttribute("relevel",relevel);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("subject",subject);

        return "board/writeform";
    }

    @PostMapping("/insert")
    public String insert(
            @ModelAttribute ReBoardDto dto,
            @RequestParam("upload") MultipartFile upload,
            @RequestParam int currentPage,
            HttpServletRequest request,
            HttpSession session
    )
    {
//        //업로드할 폴더
//        String saveFolder=request.getSession().getServletContext().getRealPath("/save");
//        //업로드하지 않았을경우 "no",업로드했을경우 랜덤파일명으로 저장
//        String photo=upload.getOriginalFilename();
//
//        if(photo.equals("")){
//            photo="no";
//        }else {
//            //확장자 분리
//            String ext=photo.split("\\.")[1];
//            photo= UUID.randomUUID()+"."+ext;
//
//            //실제 폴더에 업로드
//            try {
//                upload.transferTo(new File(saveFolder+"/"+photo));
//            } catch (IllegalStateException|IOException e) {
//                e.printStackTrace();
//            }
//        }
        //스토리지에 업로드하기
        String photo=storageService.uploadFile(bucketName,folderName,upload);
        dto.setUploadphoto(photo); //업로드된 UUID 파일명을 dto에 저장

//        dto.setUploadphoto(photo);

        //세션으로부터 아이디 얻기
        String loginid=(String) session.getAttribute("loginid");
        dto.setMyid(loginid);

        //member db로부터 아이디에 해당하는 이름을 얻어서 dto에 저장
        String writer=memberService.getDataById(loginid).getName();
        dto.setWriter(writer);

        //db insert
        boardService.insertBoard(dto);

        //확인할 거... 추가후 저장된 시퀀스 값
        System.out.println("num="+dto.getNum());

        //추가 후 상세페이지로 이동
        return "redirect:./detail?num="+dto.getNum()+"&currentPage="+currentPage;
    }

}