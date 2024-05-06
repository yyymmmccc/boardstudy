package com.example.boardstudy.service;

import com.example.boardstudy.vo.Member;
import com.example.boardstudy.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MemberService {

    private final MemberMapper memberMapper;

    public void doJoin(Member member){

        memberMapper.doJoin(member);
    }

    public Member getMemberByLoginId(String loginId) {

        return memberMapper.getMemberByLoginId(loginId);
    }

    public void doModify(Member member) {
        memberMapper.doModify(member);
    }
}
