<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<form action="${ctxPath}/member/modify?mno=${vo.mno}" method="post">
	<div>
		<div>
			<div>
				<table>
					<thead>
						<tr>
							<td>번호</td>
							<td>${vo.mno}</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>이름</td>
							<td>
								<input type="text" name="name" value="${vo.name}">
							</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td>
								<input type="text" name="id" value="${vo.id}">
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>
								<input type="text" name="pwd" value="${vo.pwd}">
							</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>
								<input type="text" name="email" value="${vo.email}">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button>취소</button>
								<button>저장</button>
							</td>
						</tr>
					</tbody>				
				</table>		
			</div>
		</div>
	</div>
</form>

<%@ include file="../layout/footer.jsp" %>