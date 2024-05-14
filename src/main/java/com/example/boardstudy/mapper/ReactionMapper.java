package com.example.boardstudy.mapper;

import com.example.boardstudy.vo.Member;
import com.example.boardstudy.vo.Reaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReactionMapper {

    void insertReaction(@Param("boardId") int boardId, @Param("point") int point, @Param("memberId") int memberId);

    Reaction getReaction(@Param("boardId") int boardId, @Param("memberId") int memberId);

    void deleteReaction(@Param("boardId") int boardId, @Param("memberId") int memberId);
}
