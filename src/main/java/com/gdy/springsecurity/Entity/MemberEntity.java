package com.gdy.springsecurity.Entity;

import com.gdy.springsecurity.Dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class MemberEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;


    private String password;

    private String role;


    public static MemberEntity toJoinmemberEntity(MemberDTO memberDTO, String encode, String Role) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(memberDTO.getUsername());
        memberEntity.setPassword(encode);
        memberEntity.setRole(Role);
        return memberEntity;
    }
}
