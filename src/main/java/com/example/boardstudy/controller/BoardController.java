package com.example.boardstudy.controller;
import com.example.boardstudy.service.BoardService;
import com.example.boardstudy.vo.Board;
import com.example.boardstudy.vo.Paging;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class BoardController {
    private BoardService boardService;
    private Paging paging;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/list")
    public String list(Model model, @RequestParam(value = "categoryId", defaultValue = "1") int categoryId
                        , @RequestParam(value = "page", defaultValue = "1") int page
                        , @RequestParam(value = "searchType", defaultValue = "") String searchType
                        , @RequestParam(value = "searchKeyword", defaultValue = "") String searchKeyWord){

        int totalPageCnt = boardService.getBoardCnt(categoryId, searchType, searchKeyWord);

        paging = new Paging(page, totalPageCnt);

        List<Board> boards = boardService.getBoards(categoryId, searchType, searchKeyWord,
                                                paging.getStartPageIndex(), paging.getCurrentPagePostsLen());
        // 카테고리 id, 몇번페이지부터, 글 몇개를 보여줄건지

        model.addAttribute("paging", paging);
        model.addAttribute("boards", boards);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchKeyword", searchKeyWord);

        return "/board/list";
    }

    @GetMapping("/board/detail")
    public String detail(Model model, @RequestParam(value="boardId") int boardId
                        , HttpServletRequest request, HttpServletResponse response){

        boardService.incrementHit(boardId, request, response);
        Board board = boardService.getBoard(boardId);

        System.out.println(board.toString());

        model.addAttribute("board", board);

        return "/board/detail";
    }

    @GetMapping("/board/write")
    public String write(Model model, @RequestParam(value="categoryId") int categoryId){

        model.addAttribute("categoryId", categoryId);

        return "/board/write";
    }

    @GetMapping("/board/doWrite")
    public String doWrite(@RequestParam(value = "memberId") int memberId
            , @RequestParam(value = "categoryId") int categoryId
            , @RequestParam(value = "title") String title, @RequestParam(value = "content") String content){

        boardService.doWrite(memberId, categoryId, title, content);

        return "/home/main";
        // 위치 해당 category 리스트로 가야함
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
