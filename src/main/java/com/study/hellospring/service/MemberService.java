package com.study.hellospring.service;

import com.study.hellospring.domain.Member;
import com.study.hellospring.repository.MemberRepository;
import com.study.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 중복회원 확인
        validateDupulicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 찾기
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findbyId(memberId);
    }

    /**
     * 중복회원 찾기
     */
    private void validateDupulicateMember(Member member) {
        Optional<Member> result = memberRepository.findbyName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


}
