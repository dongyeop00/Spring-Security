package com.gdy.springsecurity.Service;

import com.gdy.springsecurity.Dto.MemberDTO;
import com.gdy.springsecurity.Entity.MemberEntity;
import com.gdy.springsecurity.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(MemberDTO memberDTO){

        //db에 이미 동일한 username을 가진 회원이 존재하는지?
        boolean isUser = memberRepository.existsByUsername(memberDTO.getUsername());
        if(isUser){
            return;
        }

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(memberDTO.getUsername());
        memberEntity.setPassword(bCryptPasswordEncoder.encode(memberDTO.getPassword()));
        memberEntity.setRole("ROLE_USER");

        /*
        String password = bCryptPasswordEncoder.encode(memberDTO.getPassword());
        String Role = "ROLE_ADMIN";
        MemberEntity memberEntity = MemberEntity.toJoinmemberEntity(memberDTO,password,Role);

         */
        memberRepository.save(memberEntity);

    }
}
