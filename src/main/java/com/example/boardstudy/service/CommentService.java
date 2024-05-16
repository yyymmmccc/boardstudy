package com.example.boardstudy.service;

import com.example.boardstudy.mapper.CommentMapper;
import com.example.boardstudy.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommentService {

    private CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentMapper commentMapper){
        this.commentMapper = commentMapper;
    }

    public void insertComment(int boardId,  int memberId, String content) {
        commentMapper.insertComment(boardId, memberId, content);
    }

    public List<Comment> getComments(int boardId) {
        return commentMapper.getComments(boardId);
    }

    public Comment getComment(int commentId) {
        return commentMapper.getComment(commentId);
    }

    public void commentDelete(int commentId) {
        commentMapper.commentDelete(commentId);
    }

    public void modifyComment(int commentId, String content) {
        commentMapper.modifyComment(commentId, content);
    }
}
