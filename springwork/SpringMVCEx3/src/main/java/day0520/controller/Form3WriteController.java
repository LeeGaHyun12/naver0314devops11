package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import day0520.dto.FoodDto;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Form3WriteController {
    @PostMapping("/read3")
    public String read3(
            /*폼태그에서 같은 이름을 자동으로 읽어온다
            * Model에 foodDto라는 이름으로 저장이 된다*/
            //@ModelAttribute FoodDto dto

            @ModelAttribute("fdto") FoodDto dto

            )
    {

    return "form3/result3";
    }
}

