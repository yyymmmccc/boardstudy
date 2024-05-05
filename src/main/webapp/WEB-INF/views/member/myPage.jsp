<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/header.jsp" %>

<section class="mt-10"> <!-- 마진-top 10 -->
	<div>
		<div>
			<form action="/member/doModify" method="GET">
				<input type="hidden" name="memberId" value="${member.memberId }"/>
				<br>
				아이디 : <input type="text" name="loginId" value="${member.loginId}" readonly/>
				<br>
				이름 : <input type="text" name="name" value="${member.name}" readonly/>
				<br>
				닉네임 : <input type="text" name="nickname" value="${member.nickname}"/>
				<br>
				전화번호 : <input type="text" name="tel" value="${member.tel}"/>
				<br>
				이메일 : <input type="text" name="email" value="${member.email}" />
				<br>
				주소 : <input type="text" name="address" value="${member.address}"/>
				<br>
				<button>회원정보수정</button>
				<a class="btn btn-outline btn-success">비밀번호 변경</a>
			</form>
		</div>
	</div>
</section>

<%@ include file="../common/footer.jsp" %>