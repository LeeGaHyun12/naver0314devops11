package controller.guest;

import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class GuestListController {

    @GetMapping("/guest/list")
    public String list()
    {
        return "guest/guestlist";
    }

}