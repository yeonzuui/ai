// 2.js
/* 동적인 부분(JavaScript)
다른이름으로 저장(utf-8인코딩 방법으로 저장)
*/
name = prompt("이름은 ?", "홍길동"); // 취소를 클릭하면 'null' 리턴
if (name != "null" && name != "") {
    document.write(name + "님 반갑습니다<br>")
}