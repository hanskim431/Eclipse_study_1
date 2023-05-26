<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<h1>등록</h1>
	<form action="${ctxPath}/board/register" method="post" class="boardForm">
		<label>제목 : <input type="text" name="title" placeholder="제목을 입력하세요" ></label><br>
		<label>작성자 : <input type="text" name="writer" placeholder="이름을 입력하세요" ></label><br>
		<label>내용 : <textarea name="content"></textarea></label><br>
		<button class="list btn">취소</button>
		<button class="btn">저장</button>
	</form>
<%@ include file="../layout/footer.jsp" %>

<script>
$(function() {
	let boardForm = $('.boardForm')
		
	$('.list').click(function(e){
		e.preventDefault()
		$('[name="bno"],[name="title"],[name="content"]').remove() // 선택 된 게시물에서 목록으로 나올 때 bno=1이 붙는것을 제거
		boardForm.attr('action','list')
				.attr('method','get')
				.submit()
	});
	
})
</script>
