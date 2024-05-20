package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1WriteController {
    @GetMapping("/read1")
    public String read1(
            //form 태그의 name과 읽어올 변수명이 같을 경우 생략가능한 부분

        //@RequestParam("name") String name,
        //@RequestParam("addr") String a, //앞에랑 이름을 다르게 해주면 ("")를 꼭 넣어줘야 함, 같으면 생략 가능
            String name, /* @RequestParam도 생략가능*/
        @RequestParam("addr") String a, /*폼태그와 다른 이름으로 읽을 경우 생략*/
        @RequestParam("age") int myage,
        Model model
        )
    {
        model.addAttribute("name",name);
        model.addAttribute("addr",a);
        model.addAttribute("age",myage);
        model.addAttribute("info",myage>=20?"성인입니다":"미성년자입니다");
        return"form1/result1";
    }
}

