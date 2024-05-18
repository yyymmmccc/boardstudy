package com.example.boardstudy.controller;

import com.example.boardstudy.service.MemberService;
import com.example.boardstudy.service.ProductService;
import com.example.boardstudy.util.Util;
import com.example.boardstudy.vo.Member;
import com.example.boardstudy.vo.Paging;
import com.example.boardstudy.vo.Product;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/list")
    public String productList(Model model, @RequestParam(value = "categoryId") int categoryId,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "searchKeyword", defaultValue = "") String searchKeyWord){

        int totalPageCnt = productService.getProductCnt(categoryId, searchKeyWord);
        System.out.println(totalPageCnt);

        Paging paging = new Paging(page, totalPageCnt, 8);

        List<Product> products = productService.productLists(categoryId, searchKeyWord, paging.getStartPageIndex(), paging.getCurrentPagePostsLen());

        model.addAttribute("categoryId", categoryId);
        model.addAttribute("products", products);
        model.addAttribute("paging", paging);
        model.addAttribute("searchKeyword", searchKeyWord);
        return "/product/list";
    }

}
