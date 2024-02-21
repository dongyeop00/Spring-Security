package com.gdy.springsecurity.Repository;

import com.gdy.springsecurity.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {
    boolean existsByUsername(String username);
}
