package com.gdy.springsecurity.Entity;

import com.gdy.springsecurity.Dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MemberEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    private String password;

    private String role;

}
