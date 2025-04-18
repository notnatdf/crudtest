package com.study.crudtest.controller;

import com.study.crudtest.domain.Board;
import com.study.crudtest.dto.LoginDTO;
import com.study.crudtest.dto.PostFormDTO;
import com.study.crudtest.dto.SignUpFormDTO;
import com.study.crudtest.service.interfaces.BoardService;
import com.study.crudtest.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final MemberService memberService;
    private final BoardService boardService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignUpFormDTO formDTO) {
        return memberService.signup(formDTO);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        return memberService.login(loginDTO);
    }

    @PostMapping("/posts")
    public ResponseEntity save(@RequestBody PostFormDTO postFormDTO){
        ResponseEntity responseEntity = boardService.save(postFormDTO);
        return responseEntity;
    }




}
