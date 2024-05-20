package com.bitcamp.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HomeController {

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String home(Locale locale, Model model) {
//        Shopdto dto1=new Shopdto();
//        dto1.setSang("머리띠");
//        dto1.setPhoto("30.jpg");
//        dto1.setPrice(130000);
//        dto1.setSu(3);
//
//        Shopdto dto2=new Shopdto("머리끈","26.jpg",9000,5);
//
//        model.addAttribute("dto1",dto1);
//        model.addAttribute("dto2",dto2);
//        System.out.println(dto1.toString());
//        System.out.println(dto2);//tostring 생략가능
//        model.addAttribute("msg","HelloSpringFramework");
//        model.addAttribute("today",new Date());
//
//        return "home";
//    }

    @GetMapping("/")
    public String hello(){
        return "start";
    }

    @GetMapping("/board/list")
    public String hello2(Model model){
        model.addAttribute("msg","안녕하세요 반가워요!!");
        return "result1";
    }
    @GetMapping("/guest/list")
    public ModelAndView hello3(){
        ModelAndView mview=new ModelAndView();
        mview.addObject("today",new Date());
        mview.setViewName("result2");
        return mview;
    }

}