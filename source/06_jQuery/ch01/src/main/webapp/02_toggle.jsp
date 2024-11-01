<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		div#toggle{
			width: 200px;
			height: 100px;
			line-height: 100px;
			text-align: center;
			background-color: red;
		}	
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function(){
			// $('선택자').함수();
			$('h1.goShow').click(function(){
				$('div#toggle').show();
			});
			$('h2.goHide').click(function(){
				$('div#toggle').hide();
			});
			$('button').click(function(){
				$('#toggle').toggle();
			});
		}); 
	</script>
</head>
<body>
	<button>toggling</button>
	<h1 class="goShow">보이게</h1>
	<h2 class="goHide">사라지게</h2>
	<div id="toggle"><b>toggle되는 부분</b></div>
</body>
</html>