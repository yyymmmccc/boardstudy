package com.example.boardstudy.mapper;

import com.example.boardstudy.dto.MemberDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public void doJoin(String loginId, String loginPw, String name, String nickname, String tel, String email, String address);

    public MemberDTO test(int i);
}
