package com.example.boardstudy.service;

import com.example.boardstudy.mapper.MemberMapper;
import com.example.boardstudy.mapper.ReactionMapper;
import com.example.boardstudy.vo.Member;
import com.example.boardstudy.vo.Reaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReactionService {

    private ReactionMapper reactionMapper;

    @Autowired
    public ReactionService(ReactionMapper reactionMapper){
        this.reactionMapper = reactionMapper;
    }

    public void insertReaction(int boardId, int point, int memberId) {
        Reaction reaction = getReaction(boardId, memberId);

        if(reaction.getPoint() != 0){ // 이미 추천 혹은 비추천을 누른 경우
            deleteReaction(boardId, memberId); // 기존 데이터 삭제
        }

        reactionMapper.insertReaction(boardId, point, memberId);
    }

    public void deleteReaction(int boardId, int memberId) {
        reactionMapper.deleteReaction(boardId, memberId);
    }

    public Reaction getReaction(int boardId, int memberId) {
        return reactionMapper.getReaction(boardId, memberId);
    }
}
