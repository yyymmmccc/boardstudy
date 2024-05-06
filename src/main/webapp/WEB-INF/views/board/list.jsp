<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/header.jsp" %>

	<section class="mt-8">
		<div class="container mx-auto">
			<div class="mb-2 flex justify-between">
				<div>
					<form method="GET">
							<select data-value="${searchType}" name="searchType">
								<option value="title">제목</option>
								<option value="body">내용</option>
								<option value="titleBody">제목 + 내용</option>
							</select>
						<input class="mt-2" type="text" name="searchKeyword" value="${searchKeyword }" placeholder="검색어를 입력하세요."/>
						<input type="hidden" name="boardId" value="${board.boardId }"/>
						<button>검색</button>
					</form>
				</div>
			</div>
			<div class="table-box-type-1">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${boards}">
						<tr>
							<td>${board.boardId}</td>
							<td><a class="hover:underline" href="detail?boardId=${board.boardId }">${board.title}</a></td>
							<td>${board.nickname}</td>
							<td>${board.regDate}</td>
							<td>${board.hit }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${!empty sessionScope}">
                <div class="mt-2 flex justify-end">
                    <a href="/board/write?categoryId=${categoryId}" class="btn btn-outline btn-success">글 작성</a>
                </div>
                </c:if>
			</div>
        </div>
	</section>
<%@ include file="../common/footer.jsp" %>