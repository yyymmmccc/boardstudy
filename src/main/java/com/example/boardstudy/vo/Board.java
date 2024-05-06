package com.example.boardstudy.vo;

import lombok.Data;

@Data
public class Board {
    private int boardId;
    private String title;
    private String content;
    private int hit;
    private String regDate;
    private String updateDate;
    private String categoryId;
    private String memberId;
    private String nickname;
}
