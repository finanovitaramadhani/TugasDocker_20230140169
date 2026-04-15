package com.tugas.deploy6.controller;

import com.tugas.deploy6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    List<User> data = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if(username.equals("admin") && password.equals("20230140169")) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("data", data);
        return "home";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/save")
    public String save(@RequestParam String nama,
                       @RequestParam String nim,
                       @RequestParam String jk) {

        data.add(new User(nama, nim, jk));
        return "redirect:/home";
    }
}