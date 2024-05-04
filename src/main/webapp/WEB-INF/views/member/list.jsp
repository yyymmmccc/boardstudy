<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원가입"/>

<%@ include file="../common/header.jsp" %>

<section class="mt-8">
		<div class="container mx-auto">
			<form action="/member/doJoin" method="GET" > <!-- 전송버튼을 눌렀을 때 자기자신 객체를 가지고 join_submit 메서드 실행 -->
				<div class="table-box-type-1">
					<td>${member.memberId}</td>
                    <td>${member.loginId}</td>
				</div>
			</form>
	</div>
</section>

<%@ include file="../common/footer.jsp" %>