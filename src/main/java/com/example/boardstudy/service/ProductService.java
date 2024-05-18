package com.example.boardstudy.service;

import com.example.boardstudy.mapper.MemberMapper;
import com.example.boardstudy.mapper.ProductMapper;
import com.example.boardstudy.vo.Member;
import com.example.boardstudy.vo.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductMapper productMapper;

    public List<Product> productLists(int categoryId, String searchKeyword, int startPageIndex, int currentPagePostsLen) {
        return productMapper.productLists(categoryId, searchKeyword, startPageIndex, currentPagePostsLen);
    }

    public int getProductCnt(int categoryId, String searchKeyWord) {

        return productMapper.getProductCnt(categoryId, searchKeyWord);
    }
}
