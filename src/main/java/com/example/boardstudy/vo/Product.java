package com.example.boardstudy.vo;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private int categoryId;
    private String name;
    private String image;
    private String content;
    private String size;
    private int quantity;
    private int price;
    private String regDate;
    private String updateDate;
}
