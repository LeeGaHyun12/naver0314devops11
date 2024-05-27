package member.controller;

import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;

@Controller
@RequestMapping("/member") //공통매핑
@RequiredArgsConstructor
public class MemberListController {
    //@Autowired
    @NonNull
    private MemberService memberService;
    @GetMapping("/list") //공통 매핑이 아닌 멤버의 리스트로 주려면 여기에 /member/list로 주면 된다
    public String list(Model model) {
        int totalCount; //총 갯수

        //전체 목록 가져오기
        List<MemberDto> list=memberService.getAllMembers();

        totalCount= memberService.getTotalCount();

        model.addAttribute("list",list);
        model.addAttribute("totalCount",totalCount);


        return "member/memberlist";
    }



}
