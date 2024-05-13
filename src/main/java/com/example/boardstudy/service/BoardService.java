package com.example.boardstudy.service;

import com.example.boardstudy.mapper.BoardMapper;
import com.example.boardstudy.vo.Board;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    public void incrementHit(int boardId, HttpServletRequest request, HttpServletResponse response) {

        Cookie[] cookies = request.getCookies(); // detail로 요청을 보낼 때 내가 가지고 있는 쿠키들을 불러옴
        Cookie oldCookie = null;

        if(cookies != null) {                           // 회원의 쿠키의 값이 있을 때
            for(Cookie cookie : cookies) {
                if(cookie.getName().contains("hit")) {  // Name이 hit인 쿠키가 있는경우
                    oldCookie = cookie;					// 해당 쿠키를 old쿠키에 넣음
                }
            }
        }

        if(oldCookie != null) {   // hit 이라는 name의 쿠키가 있는경우
            if(!oldCookie.getValue().contains("[" + boardId + "]")) { // hit 이름의 쿠키는 있지만 , 특정 게시글은 처음방문 했을 때
                oldCookie.setValue(oldCookie.getValue() + "[" + boardId + "]"); // name : hit, value에 해당 게시글 id 추가
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 5); // 쿠키의 수명은 300초
                response.addCookie(oldCookie);	// 방금 생성한 쿠키를 추가해줌
                boardMapper.incrementHit(boardId);
            }
        }

        else { // hit이라는 쿠키가 존재하지 않는경우 -> hit이라는 이름의 쿠키 생성
            Cookie newCookie = new Cookie("hit", "[" + boardId + "]"); // hit : 7 생성
            newCookie.setMaxAge(60); // 쿠키 유효기간
            newCookie.setPath("/");  // 모든 경로에서 쿠기 접근 가능
            response.addCookie(newCookie);	// 방금 생성한 쿠키를 추가해줌
            boardMapper.incrementHit(boardId);
        }
    }
}
