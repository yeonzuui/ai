// key값이 속성 변수(name, age)
const person = {'name':'홍길동', 'age':22}; // name, age '' 생략 가능 
console.log('name: ', person.name, ', age: ' + person.age);
person.name = '신길동';
console.log('name: ', person.name, ', age: ' + person['age']);
/**************************************************************/
const arr = ['홍길동', 22]; // arr = {0: '홍길동', 1:22}
arr[0] = '신길동';
console.log(arr[0], arr[1]);