package com.example.boardstudy.controller;

import com.example.boardstudy.service.BoardService;
import com.example.boardstudy.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/list")
    public String list(Model model, @RequestParam(value="categoryId") int categoryId){

         List<Board> boards = boardService.getBoards(categoryId);

         model.addAttribute("boards", boards);

        return "/board/list";
    }

    @GetMapping("/board/detail")
    public String detail(Model model, @RequestParam(value="boardId") int boardId){

        Board board = boardService.getBoard(boardId);
        model.addAttribute("board", board);

        return "/board/detail";
    }

    @GetMapping("/board/modify")
    public String modify(Model model, @RequestParam(value="boardId") int boardId){

        Board board = boardService.getBoard(boardId);
        model.addAttribute("board", board);

        return "/board/modify";
    }

    @GetMapping("/board/doModify")
    public String doModify(@RequestParam(value="categoryId") int categoryId,
                           @RequestParam(value="boardId") int boardId, @RequestParam(value="title") String title,
                           @RequestParam(value="content") String content){

        boardService.modifyBoard(categoryId, boardId, title, content);

        return "/home/main";
    }

    @GetMapping("/board/doDelete")
    public String doDelete(@RequestParam(value="boardId") int boardId){

        boardService.doDelete(boardId);

        return "/home/main";
    }



}
