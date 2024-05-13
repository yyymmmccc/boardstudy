package com.example.boardstudy.mapper;

import com.example.boardstudy.vo.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    public List<Board> getBoards(@Param("categoryId") int categoryId, @Param("searchType") String searchType,
                                 @Param("searchKeyword") String searchKeyword, @Param("startPageIndex") int startPageIndex
                                , @Param("currentPagePostsLen") int currentPagePostsLen);

    public Board getBoard(int boardId);

    public void modifyBoard(@Param("categoryId") int categoryId, @Param("boardId") int boardId,
                            @Param("title") String title, @Param("content") String content);

    public void doDelete(int boardId);

    public void doWrite(@Param("memberId") int memberId, @Param("categoryId") int categoryId,
                 @Param("title") String title, @Param("content") String content);

    public int getBoardCnt(@Param("categoryId") int categoryId, @Param("searchType") String searchType, @Param("searchKeyword") String searchKeyword);

    public void incrementHit(@Param("boardId") int boardId);
}
