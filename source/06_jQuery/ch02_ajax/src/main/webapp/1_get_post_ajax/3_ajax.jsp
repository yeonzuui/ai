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
			/* $.get(요청경로, callback) 
			$.post(요청경로, 요청파라미터값의 객체, callback)
			 */
			// sol 1(버튼 있)
			$('button').click(function(){
				var id = $('input[name="id"]').val();
				$.ajax({
					url:      'midConfirm.jsp', // 웹서버가 실행(tomcat)
					// type: 'get',
					// data: 'id=' + id,
					type:     'post',
					data:     {'id': id}, // 객체
					dataType: 'html',
					success:  function(data){/* data: 요청경로 성공시 응답받은 html, 반드시 매개변수 1개 */
						$('span#idConfirm').html(data);
					}, 
					error:    function(code){/* code: 요청경로 실패시 상태정보*/
						alert(code.status + '/' + code.statusText)	;
					} // error 콜백함수
				}); // ajax 함수
			}); // click 함수
			// sol 2(버튼 없)
			$('input[name="id"]').keyup(function(){
				var id = $(this).val();
				if(id.length < 3){
					$('span#idConfirm').text('id는 3글자 이상');
				}else{
					$.ajax({
						url:      'midConfirm.jsp', // 웹서버가 실행(tomcat)
						// type: 'get',
						// data: 'id=' + id,
						type:     'post',
						data:     {'id': id}, // 객체
						dataType: 'html',
						success:  function(data){/* data: 요청경로 성공시 응답받은 html, 반드시 매개변수 1개 */
							$('span#idConfirm').html(data);
						}, 
						error:    function(code){/* code: 요청경로 실패시 상태정보*/
							alert(code.status + '/' + code.statusText)	
						} // error 콜백함수
					}); // ajax 함수
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