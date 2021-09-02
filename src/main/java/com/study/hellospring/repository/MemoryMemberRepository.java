package com.study.hellospring.repository;

import com.study.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long seq = 0;

    @Override
    public Member save(Member member) {
        member.setId(++seq);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findbyId(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findbyName(String name) {
        return store.values().stream()
                .filter(m -> m.getName().equals(name)).findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}