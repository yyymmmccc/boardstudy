package com.example.boardstudy.service;

import com.example.boardstudy.vo.Member;
import com.example.boardstudy.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final이 붙은놈 빈 객체를 컨테이너가 관리

public class MemberService {

    private final MemberMapper memberMapper;

    public void doJoin(Member member){

        memberMapper.doJoin(member);
    }

    public Member getMember(String loginId) {

        return memberMapper.getMember(loginId);
    }

    public void doModify(Member member) {
        memberMapper.doModify(member);
    }
}
