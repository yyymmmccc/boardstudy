package com.example.boardstudy.mapper;

import com.example.boardstudy.vo.Member;
import com.example.boardstudy.vo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {

    int getProductCnt(@Param("categoryId") int categoryId, @Param("searchKeyword") String searchKeyWord);

    List<Product> productLists(@Param("categoryId") int categoryId, @Param("searchKeyword") String searchKeyword, @Param("startPageIndex") int startPageIndex, @Param("currentPagePostsLen") int currentPagePostsLen);
}
