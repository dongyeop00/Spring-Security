package com.gdy.springsecurity.Service;

import com.gdy.springsecurity.Dto.CustomMemberDetails;
import com.gdy.springsecurity.Entity.MemberEntity;
import com.gdy.springsecurity.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //로그인을 하면 SecurityConfig가 매개변수 username에 전달해준다.

        MemberEntity byUsername = memberRepository.findByUsername(username);
        if(byUsername != null){
            return new CustomMemberDetails(byUsername); //UserDetails는 dto에 해당함
        }
        return null;
    }
}
