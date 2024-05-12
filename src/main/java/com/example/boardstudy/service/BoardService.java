package com.example.boardstudy.service;

import com.example.boardstudy.mapper.BoardMapper;
import com.example.boardstudy.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Board> getBoards(int categoryId, int startPageIndex, int currentPagePostsLen) {

        return boardMapper.getBoards(categoryId, startPageIndex, currentPagePostsLen);
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

    public int getBoardCnt(int categoryId) {
        return boardMapper.getBoardCnt(categoryId);
    }
}
