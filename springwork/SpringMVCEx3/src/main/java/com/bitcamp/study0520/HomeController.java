package com.bitcamp.study0520;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //시작하자마자 호출되는 매핑
    public String home(){
        return "views/start";
    }

}
