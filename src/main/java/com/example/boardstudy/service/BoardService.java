package com.example.boardstudy.service;

import com.example.boardstudy.mapper.BoardMapper;
import com.example.boardstudy.vo.Board;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BoardService {
    private BoardMapper boardMapper;
    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<Board> getBoards(int categoryId, String searchType, String searchKeyword,
                                 int startPageIndex, int currentPagePostsLen) {

        return boardMapper.getBoards(categoryId, searchType, searchKeyword, startPageIndex, currentPagePostsLen);
    }

    public Board getBoard(int boardId) {

        return boardMapper.getBoard(boardId);
    }

    public void modifyBoard(int categoryId, int boardId, String title, String content) {
        boardMapper.modifyBoard(categoryId, boardId, title, content);
    }

    public void doDelete(int boardId) {
        boardMapper.doDelete(boardId);
    }

    public void doWrite(int memberId, int categoryId, String title, String content) {
        boardMapper.doWrite(memberId, categoryId, title, content);
    }

    public int getBoardCnt(int categoryId, String searchType, String searchKeyword) {
        return boardMapper.getBoardCnt(categoryId, searchType, searchKeyword);
    }

    public void incrementHit(int boardId) {
        boardMapper.incrementHit(boardId);
    }
}
