<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layout/header.jsp" %>

	<h1>리스트</h1>
	<a href="${ctxPath}/board/register" method="get">글쓰기</a>
	<table>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>수정일</th>
		</tr>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="b">
					<tr>
							<td>${b.bno}</td>
							<td><a href="get?bno=${b.bno}">${b.title}</a></td>
							<td>${b.writer}</td>
							<td>${b.regDate}</td>
							<td>${b.updateDate}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<tr>
					<td>데이터가 없습니다.</td>
				</tr>
			</c:if>
	</table>
<%@ include file="../layout/footer.jsp" %>