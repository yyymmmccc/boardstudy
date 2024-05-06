<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/header.jsp" %>

<section class="mt-8">
	<div class="container mx-auto">
		<form action="/board/doModify" method="GET">
			<div class="table-box-type-1">
				<table>
					<colgroup>
						<col width="200">
					</colgroup>
					<tbody>
						<tr>
							<th>게시판</th>
							<td>
								<select name="categoryId">
									<option value="1">공지사항</option>
									<option value="2">자유게시판</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" value="${board.title }"/></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content" cols="30" rows="10">${board.content }</textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div>
				<input type="hidden" name="boardId" value="${board.boardId }"/>
				<button class="btn btn-outline btn-success" onclick="history.back()">뒤로가기</button>
				<button class="btn btn-outline btn-success">수정</button>
			</div>
		</form>
	</div>
</section>


<%@ include file="../common/footer.jsp" %>