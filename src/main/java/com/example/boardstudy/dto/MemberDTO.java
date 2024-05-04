package com.example.boardstudy.dto;

import lombok.Data;

@Data

public class MemberDTO {
    private String memberId;
    private String loginId;
    private String loginPw;
    private String nickname;
    private String tel;
    private String email;
    private String address;
    private String role;
    private String regDate;
    private String updateDate;

}

