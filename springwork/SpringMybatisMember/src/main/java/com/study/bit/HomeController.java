package com.study.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //시작하자마자 호출되는 매핑
    public String home(){
        return "redirect:./member/list";
    }

}
