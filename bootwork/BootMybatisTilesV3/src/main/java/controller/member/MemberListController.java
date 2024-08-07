package controller.member;

import data.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberListController {

    @NonNull
    private MemberService memberService;

    @GetMapping("/member/list")
    public String memberList(Model model)
    {
        int totalCount=memberService.getTotalCount();
        List<MemberDto> list=memberService.getAllMembers();

        model.addAttribute("list",list);
        model.addAttribute("totalCount", totalCount);

        return "member/memberlist";
    }

    @GetMapping("/member/detail")
    public String detail(@RequestParam int num, Model model)
    {
        MemberDto dto=memberService.getData(num);
        model.addAttribute("dto", dto);
        return "member/detailpage";
    }



}