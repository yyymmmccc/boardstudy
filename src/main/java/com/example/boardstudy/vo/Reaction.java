package com.example.boardstudy.vo;

import lombok.Data;

@Data
public class Reaction {
    private int reactionId;
    private int boardId;
    private int point;
    private String memberId;
    private String regDate;
}
