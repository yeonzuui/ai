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
			// p태그와 input 태그에 내용을 넣기
			$('p#msg').html('<b>중복된 아이디입니다</b>');
			// $('p#msg').text('<b>사용 가능한 아이디입니다</b>')
			$('input[name="msg"]').val('Hello, jQuery');
			// button 클릭 시: p태그 안의 내용과 input 태그의 value를 가져와서 alert창에 출력
			$('button').click(function(){
				var pMsgTag = $('p#msg').html(); // <b>중복된 아이디입니다</b>
				var pMsgText = $('p#msg').text(); // 중복된 아아디입니다
				var inputMsg = $('input[name="msg"]').val();//'value값'
				alert(pMsgTag + '\n' + pMsgText + '\n' + inputMsg);
			});
		}); 
	</script>
</head>
<body>
	<p id="msg"></p>
	<p>
		정보: 
		<input type="text" name="msg">
	</p>
	<button>msg 내용 alert</button>
</body>
</html>