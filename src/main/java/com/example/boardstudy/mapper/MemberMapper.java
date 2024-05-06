package com.example.boardstudy.mapper;

import com.example.boardstudy.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {

    public void doJoin(Member member);

    @Select("SELECT * FROM member WHERE loginId = #{loginId}")
    public Member getMemberByLoginId(String loginId);

    @Update("""
            UPDATE member 
            SET nickname = #{nickname}
                , tel = #{tel}
                , email = #{email}
                , address = #{address}
                , updateDate = NOW()
            WHERE memberId = #{memberId}
            """)
    public void doModify(Member member);
}
