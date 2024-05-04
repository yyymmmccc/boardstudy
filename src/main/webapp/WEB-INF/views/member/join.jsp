<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원가입"/>

<%@ include file="../common/header.jsp" %>

<section class="mt-8">
		<div class="container mx-auto">
			<form action="/member/doJoin" method="GET" > <!-- 전송버튼을 눌렀을 때 자기자신 객체를 가지고 join_submit 메서드 실행 -->
				<div class="table-box-type-1">
					<table>
						<colgroup>
							<col width="200">
						</colgroup>
						<tbody>
							<tr height="100">
								<th>아이디</th>
								<td>
									<input class="input input-bordered w-3/5" type="text" name="loginId" placeholder="아이디를 입력해주세요" onblur="loginIdDupChk(this);"/></div>
									<div id="loginIdChkMsg" class="text-base mt-2 h-5"></div>
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td>
									<input id="loginPw" class="input input-bordered w-3/5" type="loginPw" name="loginPw" placeholder="비밀번호를 입력해주세요" onblur="pwValiChk();"/>
									<div id="loginPwChkMsg" class="text-base mt-2 h-5">*영문/숫자/특수문자를 조합하여 8~16자로 입력해주세요.</div>
								</td>
							</tr>
							<tr>
								<th>이름</th>
								<td>
									<input class="input input-bordered w-3/5" type="text" name="name" placeholder="이름을 입력해주세요" onblur="nameChk(this);"/>
									<div id="loginNameChkMsg" class="text-base mt-2 h-5"></div>
								</td>
							</tr>
							<tr>
								<th>닉네임</th>
								<td>
									<input class="input input-bordered w-3/5" type="text" name="nickname" placeholder="닉네임을 입력해주세요" onblur="loginNickNameDupChk(this);"/>
									<div id="loginNickNameChkMsg" class="text-base mt-2 h-5"></div>
								</td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td>
									<input class="input input-bordered w-3/5" type="tel" name="tel" placeholder="전화번호를 입력해주세요." onblur="loginPhoneNumChk(this);"/>
									<div id="loginPhoneNumChkMsg" class="text-base mt-2 h-5"></div>
								</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>
									<input class="input input-bordered w-3/5" type="email" name="email" placeholder="이메일을 입력해주세요" onblur="loginEmailChk(this);"/>
									<div id="loginEmailChkMsg" class="text-base mt-2 h-5"></div>
								</td>
							</tr>
							<tr>
                                <th>주소</th>
                                <td>
                                    <input class="input input-bordered w-3/5" type="text" name="address" placeholder="주소를 입력해주세요" onblur="loginEmailChk(this);"/>
                                    <div id="loginEmailChkMsg" class="text-base mt-2 h-5"></div>
                                </td>
                            </tr>
							<tr>
								<td colspan="2"><button>회원가입</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
	</div>
</section>

<%@ include file="../common/footer.jsp" %>