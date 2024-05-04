package com.example.boardstudy.service;

import com.example.boardstudy.dto.MemberDTO;
import com.example.boardstudy.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final이 붙은놈 빈 객체를 컨테이너가 관리

public class MemberService {

    private final MemberMapper memberMapper;

    public void doJoin(String loginId, String loginPw, String name, String nickname, String tel, String email, String address) {
        memberMapper.doJoin(loginId, loginPw, name, nickname, tel, email, address);
    }

    public MemberDTO test(int i) {
        return memberMapper.test(i);
    }
}
