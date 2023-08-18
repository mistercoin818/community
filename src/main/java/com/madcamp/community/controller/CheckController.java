package com.madcamp.community.controller;

import com.madcamp.community.domain.Userauth;
import com.madcamp.community.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckController {
    private final CheckService checkService;

    @Autowired
    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping("/check")
    public String checkForm(){
        return "check";
    }

    @PostMapping("/check")
    public String checkSubmit(
            @RequestParam String name,
            @RequestParam int KAISTId,
            Model model){
        Userauth userAuth = checkService.findByKAISTId(KAISTId);

        if (userAuth != null && userAuth.getName().equals(name)) {
            // 일치하는 경우
            return "redirect:/join";
        } else {
            // 일치하지 않는 경우
            model.addAttribute("message", "일치하지 않습니다.");
            return "check";
        }
    }
}
