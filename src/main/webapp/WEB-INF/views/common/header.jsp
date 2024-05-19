<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 테일윈드 불러오기 -->
<link href="https://cdn.jsdelivr.net/npm/daisyui@4.6.0/dist/full.min.css" rel="stylesheet" type="text/css" />
<script src="https://cdn.tailwindcss.com"></script>
<!-- 노말라이즈, 라이브러리 -->

<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- 폰트어썸 불러오기 -->
<link rel="stylesheet" href="/common/common.css"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<title>쇼핑몰</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="/">로고</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <li class="nav-item"><a class="nav-link" href="/product/list?categoryId=14">Shop</a></li>
                    <li class="nav-item"><a class="nav-link" href="/board/list?categoryId=1">Notice</a></li>
                    <li class="nav-item"><a class="nav-link" href="/board/list?categoryId=2">Free</a></li>
                </ul>
                <div class="d-flex">
                    <c:if test="${empty sessionScope.member}">
                        <class="btn btn-outline-dark"><a class="nav-link" href="/member/login">로그인</a>
                        <class="btn btn-outline-dark"><a class="nav-link" href="/member/join">회원가입</a>
                    </c:if>
                    <c:if test="${!empty sessionScope.member}">
                        <class="btn btn-outline-dark"><a class="nav-link" href="/member/myPage">마이페이지</a>
                        <class="btn btn-outline-dark"><a class="nav-link" href="/member/logout">로그아웃</a>
                        <class="btn btn-outline-dark"><a class="nav-link" href="/member/logout">장바구니<span class="badge bg-dark text-white ms-1 rounded-pill">0</span></a>
                    </c:if>
                </div>
            </div>
        </div>
    </nav>