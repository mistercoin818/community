package com.madcamp.community.controller;

import com.madcamp.community.domain.Userauth;
import com.madcamp.community.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
    private final JoinService joinService;

    @Autowired
    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public String checkForm() {
        return "join";
    }

    @PostMapping("/join")
    public String checkSubmit(
            @RequestParam String userId,
            @RequestParam String password,
            @RequestParam String userName,
            @RequestParam String school,
            @RequestParam Integer studentId,
            @RequestParam Integer groupNum,
            @RequestParam String githubAcct,
            Model model
    ) {
        Userauth userauth = joinService.findByKAISTId(studentId);
        if (userauth != null && userauth.getName().equals(userName)) {
            joinService.createUser(userId, password, userName, school, studentId, groupNum, githubAcct);
            return "redirect:/login"; // 회원 가입 후 로그인 페이지로 리다이렉트
        } else {
            model.addAttribute("message", "캠프 참여 인증이 필요합니다.");
            return "join";
        }
    }
}
