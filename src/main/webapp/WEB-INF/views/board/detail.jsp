<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/header.jsp" %>

<script>

    originalId = null;
	originalForm = null;

    function getReaction(){

        $.get('/reaction/getReaction', {

            boardId: ${board.boardId}

        }, function(data){

            if(data.point > 0){
                let goodBtn = $('#goodBtn');
                goodBtn.removeClass('btn-outline'); // btn 이미지 아웃라인삭제
                goodBtn.attr('href', '/reaction/deleteReaction?boardId=${board.boardId }')
            }

            else if(data.point < 0){
                let badBtn = $('#badBtn');
                badBtn.removeClass('btn-outline');
                badBtn.prop('href', '/reaction/deleteReaction?boardId=${board.boardId }')
            }
        }, 'json');
    }

    function commentModify(commentId, i){

    		if(originalForm != null){  // 댓글 수정창이 이미 켜져있는 경우
    			commentModify_cancel(originalId);
    		}

    		$.get('/comment/getComment', {

    			commentId : commentId  // 매개변수로 보냄

    		}, function(comment){

    			let commentContent = $('#' + i);   // #i 즉 id=i 값을 가져올거
    			// commentContent 에 현재 댓글을 보관

    			originalId = i;  // Ex. 3번째 댓글.
    			originalForm = commentContent.html(); // i번째에 해당하는 댓글을 보관

    			// 스크립트에서 만들어진 변수는 \ 를 꼭꼭꼭 달아줘야됨 : ex.\${data.data1.id}
    			let addHtml = `
    				<form action="/comment/modifyComment" method="GET">
    					<input type="hidden" name="commentId" value="\${comment.commentId}"/>
    					<div class="mt-4 border border-red-400 rounded-lg p-4 text-base">
    						<div class="mb-2"><span>수정</span></div>
    						<textarea id="modifyComment" class="textarea textarea-bordered w-full" name="content" placeholder="댓글을 남겨보세요.">\${comment.content}</textarea>
    						<div class="mt-1 flex justify-end">
    							<a class="btn btn-outline btn-info btn-sm mr-2" onclick="commentModify_cancel(\${i});">취소</a>
    							<button class="btn btn-outline btn-info btn-sm">수정</button>
    						</div>
    					</div>
    				</form>
    			`;

    			commentContent.empty(); // commentContent 안에 데이터를 비워줌
    			commentContent.append(addHtml); // ex. 3번 댓글이면 해당 자리에 기존데이터를 없애고 댓글수정창을 보여주게하는게 해줌
    		}, 'json')
    	}

    	function commentModify_cancel(i){ // i번째 댓글 수정창을 원래대로 돌려주는 메서드 (i번째 수정창에서 취소를 누르거나, i번째 수정창에서 다른 )
    		let commentContent = $('#' + i);

    		commentContent.html(originalForm)

    		originalId = null;
    		originalForm = null;
    	}

    getReaction();
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
						<td>${board.boardId }</td>
					</tr>
					<tr>
                        <th>제목</th>
                        <td>${board.title }</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>${board.content}</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>${board.nickname }</td>
                    </tr>
					<tr>
						<th>작성일</th>
						<td>${board.updateDate }</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td><span id="articleDetail_increaseHitCnt">${board.hit }</span></td>
					</tr>
					<tr>
						<th>추천</th>
						<td>
							<div>
								<a id="goodBtn" class="btn btn-outline btn-success btn-xs" href="/reaction/insertReaction?boardId=${board.boardId}&point=1">좋아요👍</a>
								<span class="ml-2">${board.goodReaction }</span>
							</div>
							<div class="mt-2">
								<a id="badBtn" class="btn btn-outline btn-error btn-xs" href="/reaction/insertReaction?boardId=${board.boardId}&point=-1">싫어요👎</a>
								<span class="ml-2">${board.badReaction }</span>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 게시글 수정부분 -->
		<div class="pt-8">
		<button class="btn btn-outline btn-success" onclick="history.back()">뒤로가기</button>
		<c:if test="${sessionScope.member.memberId == board.memberId}">
			<a class="btn btn-outline btn-info" href="modify?boardId=${board.boardId}">수정</a>
			<a class="btn btn-outline btn-error" href="doDelete?boardId=${board.boardId}" onclick="if(confirm('정말 삭제하시겠습니까?') == false) return false;">삭제</a>
		</c:if>
		</div>
	</div>
</section>

<!-- 작성된 댓글 보여주는 곳 -->
<section class="mt-3 text-xl">
	<div class="container mx-auto px-3">
		<h1>댓글</h1>
		<c:forEach var="comment" items="${comments }" varStatus="status">
			<div id="${status.count }" class="text-base py-4 pl-16 border-bottom-line"> <!-- status.count는 반복문이 돌때마다 1씩 증가. (즉, id가 1씩증가) -->

			    <!-- 작성된 댓글 안에서 수정, 삭제하는 버튼 -->
				<div class="flex justify-between items-end">
					<div class="font-bold"><span>${comment.nickname }</span></div>
					<c:if test="${sessionScope.member.memberId == comment.memberId }">
						<div class="dropdown">
							<button class="btn btn-circle btn-ghost btn-s mr-6">
						    	<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" class="inline-block w-5 h-5 stroke-current"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 12h.01M12 12h.01M19 12h.01M6 12a1 1 0 11-2 0 1 1 0 012 0zm7 0a1 1 0 11-2 0 1 1 0 012 0zm7 0a1 1 0 11-2 0 1 1 0 012 0z"></path></svg>
						    </button>
						    <ul tabindex="0" class="menu menu-sm dropdown-content mt-2 z-[1] p-2 shadow bg-base-100 rounded-box w-20">
						        <li><a onclick="commentModify(${comment.commentId}, ${status.count });">수정</a></li>
						        <li><a href="/comment/commentDelete?commentId=${comment.commentId }&boardId=${board.boardId}" onclick="if(confirm('정말 삭제하시겠습니까?') == false) return false;">삭제</a></li>
					     	 </ul>
  						</div>
 					</c:if>
  				</div>

                <!-- 댓글 내용, 날짜 -->
				<div class="my-1 text-lg"><span>${comment.content }</span></div>
				<div class="text-xs text-gray-400"><span>${comment.updateDate }</span></div>

			</div>
		</c:forEach>
		
	<!-- 댓글 작성하는 곳 -->	
	<c:choose>
		<c:when test="${!empty sessionScope.member}"> <!-- 로그인 했을 때. -->
			<form action="/comment/insertComment" method="GET">
				<input type="hidden" name="boardId" value="${board.boardId }"/>
				<div class="mt-4 border border-red-400 rounded-lg p-4 text-base">
					<div class="mb-2"><span>Comment</span></div>
					<textarea id="modifyComment" class="textarea textarea-bordered w-full" name="content" placeholder="댓글을 남겨보세요."></textarea>
					<div class="mt-1 flex justify-end "><button class="btn btn-outline btn-info btn-sm">등록</button></div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<div class="mt-4 border border-red-400 rounded-lg p-4 text-base">
				<div class="mb-2"><span>Comment..</span></div>
				<textarea class="textarea textarea-bordered w-full" placeholder="로그인 후 이용가능합니다." onclick="location.href='/member/login'"></textarea>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
</section>

<%@ include file="../common/footer.jsp" %>