package com.example.boardstudy.vo;

import lombok.Data;

@Data

public class Comment {
    private int commentId;
    private int boardId;
    private int memberId;
    private String content;
    private String nickname;
    private String regDate;
    private String updateDate;
}

