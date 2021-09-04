package com.study.hellospring;


import com.study.hellospring.repository.JpaMemberRepository;
import com.study.hellospring.repository.MemberRepository;
import com.study.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfiguration {

    private EntityManager em;

    @Autowired
    public SpringConfiguration(EntityManager em) {
        this.em = em;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}
