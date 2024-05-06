package com.example.boardstudy.vo;

import lombok.Data;

@Data

public class Member {
    private int memberId;
    private String loginId;
    private String loginPw;
    private String name;
    private String nickname;
    private String tel;
    private String email;
    private String address;
    private String role;
    private String regDate;
    private String updateDate;

}

