<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/header.jsp" %>

<script>


</script>

<section class="mt-8">
	<div class="container mx-auto pb-10 border-bottom-line">
		<div class="table-box-type-1">
			<table>
				<colgroup>
					<col width="200">
				</colgroup>
				<tbody>
					<tr>
						<th>번호</th>
						<td>${product.productId }</td>
					</tr>
					<tr>
                        <th>상품명</th>
                        <td>${product.name }</td>
                    </tr>
                    <tr>
                        <th>이미지</th>
                        <td><image src="${product.image }"></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>${product.content}</td>
                    </tr>
                    <tr>
                        <th>사이즈</th>
                        <td>${product.size}</td>
				</tbody>
			</table>
		</div>
		<!-- 게시글 수정부분 -->
		<div class="pt-8">
            <button class="btn btn-outline btn-success" onclick="history.back()">뒤로가기</button>
            <c:if test="${sessionScope.member.role == 0}">
                <a class="btn btn-outline btn-info" href="/product/modify?productId=${product.productId}">수정</a>
                <a class="btn btn-outline btn-error" href="/product/delete?productId=${product.productId}" onclick="if(confirm('정말 삭제하시겠습니까?') == false) return false;">삭제</a>
            </c:if>
		</div>
	</div>
</section>

<%@ include file="../common/footer.jsp" %>