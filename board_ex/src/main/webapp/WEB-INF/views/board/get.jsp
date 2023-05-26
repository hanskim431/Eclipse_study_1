<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<title>get</title>

	<form action="${ctxPath}/board/del?bno=${vo.bno}" method="post" class="boardForm">
		<h1>읽기</h1>
		<label>제목 : ${vo.title}</label><br>
		<label>작성자 : ${vo.writer}</label><br>
		<label>내용 : ${vo.content}</label><br>
		<a href="#" class="delBoard ">삭제</a>
		<a href="#" class="updateBoard ">수정</a>
		<a href="#" class="listBoard ">목록</a>
		<input type="hidden" name="bno" value="${vo.bno}">
	</form>
<%@ include file="../layout/footer.jsp" %>

<script type="text/javascript">
$(function() {
	console.log("Jquery START!")
	
	let boardForm = $('.boardForm')
	
	$('.delBoard').click(function(e){
		e.preventDefault()
		$('.boardForm').submit()
	})
	
	$('.listBoard').click(function(e){
		e.preventDefault()
		$('[name="bno"]').remove()
		boardForm.attr('method','get')
					.attr('action','list')
					.submit()
	})

	$('.updateBoard').click(function(e){
		e.preventDefault()
		boardForm.attr('method','get')
					.attr('action','update')
					.submit()
	})
})

</script>