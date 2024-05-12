package com.example.boardstudy.vo;

import lombok.Data;

@Data
public class Paging {
    private int page; // 현재 페이지 번호
    private final int currentPagePostsLen = 10; // 현재 페이지에서 보여줄 글의 수
    private int viewPageLen = 10;                  // 보여줄 페이지의 갯수
    private int startPageIndex;                    // 보여줄 글의 시작범위 설정 (1page이면 0번글부터, 2page면 10번글부터)
    private int totalPage;                         // 총 페이지의 갯수
    private int endPage;                           // 보여줄 페이지의 끝번호
    private int startPage;                         // 보여줄 페이지의 시작번호

    public Paging(int page, int totalPageCnt){
        this.page = page;
        this.totalPage = totalPageCnt;
        calc();
    }

    public void calc() {

        startPageIndex = (page - 1) * currentPagePostsLen;
        // 게시글 시작번호를 알려줄 변수 (1페이지면 0번 글부터, 2페이지면 10번 글부터)

        totalPage = (int) Math.ceil((double) totalPage / 10);
        // 예를들어 totalPage 값이 243이라면 24페이지가 아닌 / 25페이지로 보이게 보정

        endPage = (int) (Math.ceil((double) page / viewPageLen) * viewPageLen);
        // 현재 페이지가 1일 때 보여줄 페이지 갯수(10) 0.1 -> Math.ceil 반올림하면 1. -> * 10 줄하면 10
        // endPage = 10, 20, 30, 40...

        startPage = (endPage - viewPageLen) + 1;
        // startPage = 1, 11, 21, 31 ...

        if (endPage > totalPage) { // startPage, endPage = 20 ~ 30 인데 totalPage가 27이라면 28, 29. 30 이 나오면 안되므로 endPage를 27로 바꿔줌
            endPage = totalPage;
        }
    }

}
