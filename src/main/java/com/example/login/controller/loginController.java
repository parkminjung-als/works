package com.example.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/")
    public String login(Model model) {
        return ("/login");
    }

    @GetMapping("/success") // 성공 페이지 경로
    public String successPage(Model model) {
        // 사용자 정보를 모델에 추가하거나 다른 데이터를 전달 가능
        model.addAttribute("message", "Login successful!");
        return "success"; // success.html로 리다이렉트
    }
}
