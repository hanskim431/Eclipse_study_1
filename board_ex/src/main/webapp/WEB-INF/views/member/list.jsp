<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<h1>리스트</h1>
	<div class="row">
		<div class="col">
			<c:choose>
				<c:when test="${not empty list}">
					<table>
						<tr>
							<th>회원번호</th>
							<th>아이디</th>
							<th>비밀번호</th> 
							<th>이름</th>
							<th>이메일</th> 
							<th>가입일</th>
						</tr>
						<c:forEach items="${list}" var="vo">
							<tr>
								<td>${vo.mno}</td>
								<td>${vo.id}</td>
								<td>${vo.pwd}</td>
								<td><a href="${ctxPath}/member/detail?mno=${vo.mno}" >${vo.name}</a></td>
								<td>${vo.email}</td>
								<td>${vo.joindate}</td>
							</tr>
						</c:forEach>	
					</table>
				</c:when>
				<c:otherwise>
					사용자 정보가 없습니다.
				</c:otherwise>
			</c:choose>
		</div> <!-- col end -->
	</div> <!-- row end -->
</div> <!-- container end -->


<%@ include file="../layout/footer.jsp" %>

<script>

</script>