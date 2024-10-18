// 생성자함수
function Student(name, kor, mat){
    this.name = name;
    this.kor  = kor;
    this.mat  = mat;
}

// prototype
Student.prototype.getSum = function(){
    return this.kor + this.mat;
};
Student.prototype.toString = function(){
    return this.name + ' (' + this.kor + ', ' + this.mat + ', ' + this.getSum() + ')'; 
};

// 생성자함수 이용한 객체배열 생성
var students = [new Student("홍", 70, 90),
                new Student("박", 99, 99),
                new Student("김", 56, 61),
                new Student("윤", 99, 97)
]

// 깊은 복사
var studentsCopy = [...students];

// 총점 기준으로 내림차순 정렬
studentsCopy.sort(function(left, right){
    return right.getSum() - left.getSum(); 
});

console.log('원본');
students.forEach((data, idx) => {
    console.log(idx + '> ' + data.toString());
});
console.log('---------------------------');
console.log('정렬된 복사본');
studentsCopy.forEach((data, idx) => {
    console.log(idx + '> ' + data.toString());
});