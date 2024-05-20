package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormReadController {
    @GetMapping("/form1") //메소드 이름은 크게 상관없다 매핑 보고 오는 것
    public String form1(){
        return "form1/myform1";
    }
    @GetMapping("/form2") //메소드 이름은 크게 상관없다 매핑 보고 오는 것
    public String form2(){
        return "form2/myform2";
    }
    @GetMapping("/form3") //메소드 이름은 크게 상관없다 매핑 보고 오는 것
    public String form3(){
        return "form3/myform3";
    }

}
