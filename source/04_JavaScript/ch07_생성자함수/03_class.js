// ECMA script 6(최신 문법)에서는 class를 만들 수 있음
// class는 toString 필요없음
    // *ECMA: 정보 통신에 대한 표준을 제정하는 비영리 표준화 기구
    // 구동 브라우저가 한정됨. caniuse.com을 통해 지원되는 브라우저를 확인할 것

// class(Person) 생성
    // class 블록 내에서는 constructor 자동 완성
    // 생성자 함수 이름은 무조건 constructor
class Person{
    constructor(name, first, second){
        console.log('생성자 함수 호출');
        this.name   = name;
        this.first  = first;
        this.second = second;
    }
    sum(){
        return this.first + this.second;
    }//sum
}//class

// 객체 생성
var hong = new Person("홍길동", 90, 97); // ={'name':'홍길동', 'first':90, 'second':97, 'sum':fu~}
console.log(hong.name, ',', hong.first, ',', hong.second);
console.log('합계: ' + hong.sum());
console.log(hong);