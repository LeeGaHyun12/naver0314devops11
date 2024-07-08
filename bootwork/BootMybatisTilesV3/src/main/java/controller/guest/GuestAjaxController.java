package controller.guest;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import data.service.GuestService;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import naver.cloud.NcpObjectStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class GuestAjaxController {
    @NonNull
    private GuestService guestService;
    @NonNull
    private MemberService memberService;
    @NonNull
    private NcpObjectStorageService storageService;

    private String bucketName="bitcamp-bucket-56";
    private String folderName="guestphoto";

    @PostMapping("/addguest")
    public void guestInsert(
            @RequestParam String gcontent,
            //required=false: null값일 경우도 값을 받음(원래는 400번 오류)
            @RequestParam(value = "upload",required = false) List<MultipartFile> upload,
            HttpSession session
    ){
        //세션으로부터 로그인한 아이디를 얻는다
        String myid=(String) session.getAttribute("loginid");
        //아이디에 해당하는 이름 얻기
        String writer=memberService.getDataById(myid).getName();
        //dto에 데이터들 넣기
        GuestDto dto=GuestDto.builder()
                .writer(writer)
                .myid(myid)
                .gcontent(gcontent)
                .build();
        guestService.insertGuest(dto);//이때 guestidx로 방금 추가된 시퀀스값이 들어온다
        int guestidx=dto.getGuestidx(); //시퀀스 값을 얻는 것
        //파일을 클라우드 스토리지에 업로드


        //파일을 업로드하지 않을ㄴ경우
        //파일에서 직접 호출하는 경우
//        if(upload.get(0).getOriginalFilename().equals("")) //무조건 insert가 아니라
//            return;

        //등록 버튼 클릭시 파일도 전달되는 방식
        if(upload==null)
            return;

        for(MultipartFile mfile:upload){
            //스토리지에 저장후 파일명 얻기
            String photoname=storageService.uploadFile(bucketName,folderName,mfile);

            //db에 insert
            GuestPhotoDto pdto=new GuestPhotoDto();
            pdto.setGuestidx(guestidx);
            pdto.setPhotoname(photoname);

            //db에 insert
            guestService.insertGuestPhoto(pdto);
        }
    }

    @GetMapping("/datas")
    public List<GuestDto> guestList(){
        //사진을 제외한 방명록 데이터 가져오기
        List<GuestDto> glist=guestService.getAllGuest();
        //각 방명록 글에 첨부된 사진명
        for(GuestDto dto:glist){
            dto.setPhotos(guestService.getGuestPhoto(dto.getGuestidx()));
        }
        return glist;
    }

}
