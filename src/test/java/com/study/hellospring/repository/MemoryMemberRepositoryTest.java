package com.study.hellospring.repository;


import com.study.hellospring.domain.Member;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class MemoryMemberRepositoryTest {

    MemberRepository repo = new MemoryMemberRepository();
    @Test
    void save() {
        Member m = new Member();
        m.setName("spring");

        repo.save(m);

        Member result = repo.findbyId(m.getId()).get();
        assertThat(m).isEqualTo(result);

    }

    @Test
    void findbyId() {
    }

    @Test
    void findbyName() {
    }

    @Test
    void findAll() {
    }
}