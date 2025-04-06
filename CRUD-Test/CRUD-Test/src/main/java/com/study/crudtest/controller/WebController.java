package com.study.crudtest.controller;

import com.study.crudtest.dto.DetailDTO;
import com.study.crudtest.dto.ListDTO;
import com.study.crudtest.service.interfaces.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "crud");
        model.addAttribute("img", "image/img.png");
        return "hello";
    }

    @GetMapping("/home")
    public String index() {
        return "home";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/new")
    public String newPost(){
        return "new";
    }

    private final BoardServiceImpl boardService;

    @GetMapping("/posts")
    public String index(Model model) {
        List<ListDTO> posts = boardService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        DetailDTO post = boardService.getDetail(id);
        model.addAttribute("post", post);
        return "detail";
    }

}
