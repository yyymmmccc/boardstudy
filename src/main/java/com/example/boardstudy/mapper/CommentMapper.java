package com.example.boardstudy.mapper;

import com.example.boardstudy.vo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    void insertComment(@Param("boardId") int boardId, @Param("memberId") int memberId , @Param("content") String content);


    List<Comment> getComments(@Param("boardId") int boardId);

    void commentDelete(@Param("commentId") int commentId);

    Comment getComment(@Param("commentId") int commentId);

    void modifyComment(@Param("commentId") int commentId, @Param("content") String content);
}
