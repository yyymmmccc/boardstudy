package com.example.boardstudy.controller;

import com.example.boardstudy.service.CommentService;
import com.example.boardstudy.util.Util;
import com.example.boardstudy.vo.Comment;
import com.example.boardstudy.vo.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/comment/insertComment")
    @ResponseBody
    public String insertComment(HttpSession session, @RequestParam(value = "boardId") int boardId,
                              @RequestParam(value = "content") String content){

        Member member = (Member) session.getAttribute("member");

        commentService.insertComment(boardId, member.getMemberId(), content);

        return Util.replace(String.format("/board/detail?boardId=%d", boardId));
    }

    @GetMapping("/comment/getComment")
    @ResponseBody
    public Comment getComment(@RequestParam(value = "commentId") int commentId){
        Comment comment = commentService.getComment(commentId);

        return comment;
    }

    @GetMapping("/comment/modifyComment")
    public String modifyComment(@RequestParam(value = "commentId") int commentId,
                                @RequestParam(value = "content") String content){
        commentService.modifyComment(commentId, content);

        return null;
    }

    @GetMapping("/comment/commentDelete")
    @ResponseBody
    public String commentDelete(@RequestParam(value = "commentId") int commentId,
                                @RequestParam(value = "boardId") int boardId){
        commentService.commentDelete(commentId);

        return Util.replace(String.format("/board/detail?boardId=%d", boardId));
    }

}
