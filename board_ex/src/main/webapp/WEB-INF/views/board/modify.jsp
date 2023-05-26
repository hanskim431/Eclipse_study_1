<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<title>modify</title>
<h1>수정</h1>
	<form action="${ctxPath }/board/update?bno=${vo.bno}" method="post" class="boardForm">
		<label>제목 : <input type="text" name="title" value="${vo.title}"></label><br>
		<label>작성자 : ${vo.writer}</label><br>
		<label>내용 : <textarea name="content" value="${vo.content}"></textarea></label>
		<button class="btn listBoard">취소</button>
		<button class="btn">저장</button>
	</form>
<%@ include file="../layout/footer.jsp" %>

<script type="text/javascript">
$(function() {
	console.log("jQuery START");

	let boardForm = $('.boardForm')
	
	$('.listBoard').click(function(e){
		e.preventDefault() // 태그의 기본 동작 금지
		$('[name="bno"],[name="title"],[name="content"]').remove() // 선택 된 게시물에서 목록으로 나올 때 bno=1이 붙는것을 제거
		boardForm.attr('method','get') // form 태그의 method 속성을 get으로 지정
				 .attr('action','list') // localhost:8090/board_ex/board/list요청
				 .submit()
	})
})
</script>