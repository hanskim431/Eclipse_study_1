<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<h1>개인 정보</h1>
	<div class="row">
		<div class="col">
			<form action="${ctxPath}/member/delete?mno=${vo.mno}" method="post" class="detailForm">
				<table>
					<thead>
						<td>번호</td>
						<td>${vo.mno}</td>	
					</thead>
					<tbody>
						<tr>
							<td>이름</td>
							<td>${vo.name}</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td>${vo.id}</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>${vo.pwd}</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>${vo.email}</td>
						</tr>
						<tr>
							<td>가입일</td>
							<td>${vo.joindate}</td>
						</tr>
					</tbody>
				</table>
				<div>
					<button class="list">목록</button>
					<button class="modify">수정</button>
					<button class="delete">삭제</button>
				</div>
			</form>
		</div> <!-- col end -->
	</div> <!-- row end -->
</div> <!-- container end -->

<%@ include file="../layout/footer.jsp" %>

<script type="text/javascript">
$(function(){
	let detailForm = $('.detailForm')
	
	$('.list').click(function(e){
		e.preventDefault()
		detailForm.attr('action', 'list')
				.attr('method', 'get')
				.submit()
		
	})
	
})
</script>