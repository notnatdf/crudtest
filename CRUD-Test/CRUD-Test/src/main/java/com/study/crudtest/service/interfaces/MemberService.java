package com.study.crudtest.service.interfaces;

import com.study.crudtest.domain.Member;
import com.study.crudtest.domain.MemberRole;
import com.study.crudtest.dto.LoginDTO;
import com.study.crudtest.dto.SignUpFormDTO;
import com.study.crudtest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface MemberService {
    ResponseEntity signup(SignUpFormDTO formDTO);

    ResponseEntity login(LoginDTO loginDTO);
}



