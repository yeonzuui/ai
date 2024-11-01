<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function(){
			/* $.get(요청경로, callback(data, status){
					date: 요청경로 수행 결과(중복된 ID입니다/사용 가능한 ID입니다)
					status: success/fail
			}) */
			// sol 1(버튼 있)
			$('button').click(function(){
				var id = $('input[name="id"]').val();
				$.get('midConfirm.jsp?id=' + id, function(data, status){
					if(status == 'success'){
						$('span#idConfirm').html(data);
					}//if
				});//$.get 함수
			}); // click 함수
			// sol 2(버튼 없)
			$('input[name="id"]').keyup(function(){
				var id = $(this).val();
				if(id.length < 3){
					$('span#idConfirm').text('id는 3글자 이상');
				}else{
					$.get('midConfirm.jsp?id=' + id, function(data, status){
						if(status == 'success'){
							$('span#idConfirm').html(data);
						}//if
					});//$.get 함수
				}//if
			});//keyup 이벤트
		}); //ready함수
	</script>
</head>
<body>
	아이디 <input type="text" name="id" autocomplete="off"> <button>중복체크</button><br>
	<span id="idConfirm"></span>
</body>
</html>