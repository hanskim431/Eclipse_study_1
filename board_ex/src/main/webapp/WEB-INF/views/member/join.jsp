<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<form action="${ctxPath}/member/join" method="post">
	<div class="container">
		<div class="row">
			<div class="col">
				<table>
					<thead>
						<th></th>
					</thead>
					<tbody>
						<tr>
							<td>이름</td>
							<td>
								<input type="text" name="name" placeholder="이름">
							</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td>
								<input type="text" name="id" placeholder="아이디">
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>
								<input type="text" name="pwd" placeholder="비밀번호">
							</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>
								<input type="text" name="email" placeholder="email@email.com">
							</td>
						</tr>
						<tr>
							<td colspan="2">
							<button>가입</button>
							<button>취소</button>
							</td>
						</tr>
					</tbody>
				</table>		
			</div> <!-- col end -->
		</div> <!-- row end -->
	</div> <!-- container end -->
</form>


<%@ include file="../layout/footer.jsp" %>