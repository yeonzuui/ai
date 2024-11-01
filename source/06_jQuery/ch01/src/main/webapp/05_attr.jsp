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
			$('img').mousedown(function(){
				// src의 속성 변경
				$(this).attr('src', 'img/but2.gif'); 
				$(this).attr('alt', 'mouseDown');
			});
			$('img').mouseup(function(){
				// src의 속성 변경
				$(this).attr('src', 'img/but1.gif'); 
				$(this).attr('alt', 'mouseUp');
			});
		}); 
	</script>
</head>
<body>
	<img src="img/but1.gif" alt="mouseUp">
	<img src="img/but1.gif" alt="mouseUp">
	<img src="img/but1.gif" alt="mouseUp">
	<img src="img/but1.gif" alt="mouseUp">
	<img src="img/but1.gif" alt="mouseUp">
</body>
</html>