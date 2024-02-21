package com.gdy.springsecurity.Dto;

import com.gdy.springsecurity.Entity.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomMemberDetails implements UserDetails {

    private MemberEntity memberEntity; //데이터가 왔을 때 받을 수 있는 필드 생성해야함

    public CustomMemberDetails(MemberEntity memberEntity){
        this.memberEntity = memberEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //계정의 권한 목록을 리턴
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return memberEntity.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() { // 계정의 비밀번호를 리턴
        return memberEntity.getPassword();
    }

    @Override
    public String getUsername() { //계정의 고유한 값을 리턴
        return memberEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { //계정의 만료 여부 리턴
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정의 잠김 여부 리턴
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호 만료 여부 리턴
        return true;
    }

    @Override
    public boolean isEnabled() { //계정의 활성화 여부 리턴
        return true;
    }
}
