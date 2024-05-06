<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="write"/>

<%@ include file="../common/header.jsp" %>	
<section class="mt-8">
    <div class="container mx-auto">
        <form action="/board/doWrite" method="GET">
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
                                    <option value="1" ${categoryId == '1'? 'selected' : ''}>공지사항</option>
                                    <option value="2" ${categoryId == '2'? 'selected' : ''}>자유게시판</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td><input type="text" name="title" placeholder="제목"></td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td><textarea name="content" cols="30" rows="10" placeholder="내용을 입력하세요."></textarea></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div>
                <input type="hidden" name="memberId" value="${sessionScope.member.memberId}">
                <button class="btn btn-outline btn-success" onclick="history.back()">뒤로가기</button>
                <button class="btn btn-outline btn-success">글 작성</button>
            </div>
        </form>
    </div>
</section>

<%@ include file="../common/footer.jsp" %>