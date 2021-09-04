package com.study.hellospring.repository;

import com.study.hellospring.domain.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findbyId(Long id);

    Optional<Member> findbyName(String name);

    List<Member> findAll();

}
