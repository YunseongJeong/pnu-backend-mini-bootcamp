package com.ll.pnu_backend_mini_bootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/ll")
    @ResponseBody
    public String index(){
        return "Hello Spring";
    }
}
