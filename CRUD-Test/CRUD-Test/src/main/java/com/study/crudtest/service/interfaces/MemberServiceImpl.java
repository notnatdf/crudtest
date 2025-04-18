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

@Service
@Transactional
@RequiredArgsConstructor

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public ResponseEntity signup(SignUpFormDTO formDTO) {

        Optional<Member> member = memberRepository.findById(formDTO.getId());

        if (member.isEmpty()) {
            Member newMember = Member.builder()
                    .id(formDTO.getId())
                    .password(formDTO.getPassword())
                    .name(formDTO.getName())
                    .role(MemberRole.USER)
                    .build();

            memberRepository.save(newMember);

            return new ResponseEntity("success", HttpStatus.OK);
        } else {
            return new ResponseEntity("fail",HttpStatus.OK);
        }
    }
    @Override
//    public ResponseEntity login(LoginDTO loginDTO) {
//
//        Optional<Member> member = memberRepository.findById(loginDTO.getId());
//        Member memberEntity = member.orElse(null);
//
//        if (member==null){
//            return new ResponseEntity("해당 아이디를 가진 회원이 존재하지 않습니다.",HttpStatus.OK);
//        }
//
//        if (memberEntity.getPassword().equals(loginDTO.getPassword())){
//            return new ResponseEntity("success",HttpStatus.OK);
//        } else {
//            return new ResponseEntity("비밀번호가 일치하지 않습니다.",HttpStatus.OK);
//        }
//    }
    public ResponseEntity login(LoginDTO loginDTO) {
        return memberRepository.findById(loginDTO.getId())
                .map(member -> {
                    if (member.getPassword().equals(loginDTO.getPassword())) {
                        return new ResponseEntity("success",HttpStatus.OK);
                    } else  {
                        return new ResponseEntity("비밀번호가 일치하지 않습니다.",HttpStatus.UNAUTHORIZED);
                    }
                })
                .orElse(new ResponseEntity("해당 아이디를 가진 회원이 존재하지 않습니다." , HttpStatus.NOT_FOUND));
    }

}



