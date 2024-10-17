// 배열: 일반for, for-in, for-of, forEach() 가능
let arr = ["홍길동", 22]; 
for(let idx in arr){
    console.log(idx + ": " + arr[idx]);
}
for(let data of arr){
    console.log(data);
}

// 객체: for-in, for-of 가능
let obj = {'name': '홍길동', 'age': 22}; 
for(let key in obj){
    console.log(key + ": " + obj[key]);
}

// 객체의 속성을 추가
obj.address = '서울시 관악구';
obj.hobby = '수업 복습하면서 괴로워하기';
for(let key in obj){
    console.log(key + ": " + obj[key]);
}

// 객체의 속성 제거
delete(obj.hobby);
console.log('속성 제거 후');
for(let key in obj){
    console.log(key, ': ' , obj[key]);
}