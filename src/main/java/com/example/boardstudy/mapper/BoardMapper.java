package com.example.boardstudy.mapper;

import com.example.boardstudy.vo.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("""
            SELECT *, member.nickname
                FROM board, member
                WHERE categoryId = #{categoryId} AND board.memberId = member.memberId
            """)
    public List<Board> getBoards(int categoryId);

    @Select("""
            SELECT *, member.nickname
                FROM board, member
                WHERE boardId = #{boardId} AND board.memberId = member.memberId
            """)
    public Board getBoard(int boardId);

    @Update("""
            UPDATE board
                SET categoryId = #{categoryId}
                    , title = #{title}
                    , content = #{content}
                    , updateDate = NOW()
                WHERE boardId = #{boardId}
            """)
    public void modifyBoard(@Param("categoryId") int categoryId, @Param("boardId") int boardId,
                            @Param("title") String title, @Param("content") String content);

    @Delete("DELETE FROM board WHERE boardId = #{boardId}")
    void doDelete(int boardId);
}
