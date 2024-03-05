package dev.be.moduleapi.service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DemoService {
    @Value("${profile-name}")
    private String name;

    private final MemberRepository memberRepository;
    public String save() {
        memberRepository.save(Member.builder()
                .name("나다")
                .build());
        System.out.println(CodeEnum.SUCCESS.getCode());
        return "save";
    }

    public String find() {
        System.out.println("name : " + name);
        System.out.println(memberRepository.findAll().size());
        return "find";
    }

    public String exception() {
        if(true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "Exception";
    }
}
