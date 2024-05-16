package com.example.boardstudy.controller;

import com.example.boardstudy.service.ReactionService;
import com.example.boardstudy.util.Util;
import com.example.boardstudy.vo.Member;
import com.example.boardstudy.vo.Reaction;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReactionController {
    private ReactionService reactionService;

    @Autowired
    public ReactionController(ReactionService reactionService){
        this.reactionService = reactionService;
    }

    @GetMapping("/reaction/insertReaction")
    @ResponseBody
    public String insertReaction(HttpSession session, @RequestParam(value = "boardId") int boardId
            , @RequestParam(value = "point") int point){

        Member member = (Member) session.getAttribute("member");

        reactionService.insertReaction(boardId, point, member.getMemberId());

        return Util.replace(String.format("/board/detail?boardId=%d", boardId));
    }

    @GetMapping("/reaction/getReaction")
    @ResponseBody
    public Reaction getReaction(HttpSession session, @RequestParam(value = "boardId") int boardId){

        int memberId;
        Member member = (Member) session.getAttribute("member");
        if(member == null){ memberId = 0;}
        else{memberId = member.getMemberId();}

        Reaction reaction = reactionService.getReaction(boardId, memberId);

        return reaction;
    }

    @GetMapping("/reaction/deleteReaction")
    @ResponseBody
    public String deleteReaction(HttpSession session, @RequestParam(value = "boardId") int boardId){

        Member member = (Member) session.getAttribute("member");

        reactionService.deleteReaction(boardId, member.getMemberId());

        return Util.replace(String.format("/board/detail?boardId=%d", boardId));
    }
}
