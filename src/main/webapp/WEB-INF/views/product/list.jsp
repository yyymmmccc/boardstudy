<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/header.jsp" %>

<div class="mb-2 flex row-cols-s-10 justify-content-center">
    <a href="/product/list?categoryId=3">OUTER</a>
    <a href="/product/list?categoryId=4">TOP</a>
    <a href="/product/list?categoryId=14">shorTop</a>
    <a href="/product/list?categoryId=5">BOTTOM</a>
    <a href="/product/list?categoryId=6">ACC</a>
</div>

<section class="py-5">
    <div class="mb-2 flex justify-between">
        <div>
            <form action="/product/list" method="GET">
                <input class="mt-2" type="text" name="searchKeyword" value="${searchKeyword }" placeholder="검색어를 입력하세요."/>
                <input type="hidden" name="categoryId" value="${categoryId }"/>
                <button>검색</button>
            </form>
        </div>
    </div>
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach var="product" items="${products}">
                <div class="col mb-5">
                    <div class="card h-100">
                        <a href="/product/detail?productId=${product.productId}"><img class="card-img-top" src="${product.image}" alt="왜 안나옴" /></a>
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                ${product.productId}
                                <h5 class="fw-bolder">${product.name}</h5>
                                <!-- Product price-->
                                가격 : ${product.price}
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="mt-4 flex justify-center">
        <div class="join">
            <!-- 처음 페이지가 아닐 때 이전버튼 화면에 출력 -->
            <c:if test="${paging.startPage > 1 }">
                <a class="join-item btn" href="/product/list?categoryId=${categoryId}&page=${paging.startPage-1}">이전</a>
            </c:if>

            <!-- 반복문으로 페이지 번호 출력 -->
            <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
                <a class="join-item btn ${paging.page == i ? 'btn-active' : ' '}" href="/product/list?categoryId=${categoryId }&page=${i }">${i }</a>
            </c:forEach>

            <!-- 마지막 페이지가 아닐 때 다음버튼 화면에 출력-->
            <c:if test="${paging.totalPage != paging.endPage}">
                <a class="join-item btn" href="/product/list?categoryId=${categoryId }&page=${paging.endPage+1}">다음</a>
            </c:if>
        </div>
    </div>
</section>
<%@ include file="../common/footer.jsp" %>